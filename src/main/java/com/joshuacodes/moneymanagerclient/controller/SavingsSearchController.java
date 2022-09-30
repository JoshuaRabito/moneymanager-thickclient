package com.joshuacodes.moneymanagerclient.controller;

import com.joshuacodes.moneymanagerclient.api.BookBalanceRestClient;
import com.joshuacodes.moneymanagerclient.api.ViewActions;
import com.joshuacodes.moneymanagerclient.model.DeductionDTO;
import com.joshuacodes.moneymanagerclient.validator.SavingsSearchViewValidator;
import com.joshuacodes.moneymanagerclient.view.SavingsSearchView;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.logging.Logger;

@ApplicationScoped
public class SavingsSearchController implements ViewActions<SavingsSearchView> {

  @Inject
  private Logger logger;

  @Inject
  private BookBalanceRestClient restClient;

  private SavingsSearchView view;

  private SavingsSearchViewValidator validator;



  public SavingsSearchController() {
    initView();
  }

  private void initView() {
    view = new SavingsSearchView();
    view.setVisible(true);
    validator = new SavingsSearchViewValidator(view);
    bindListeners();

  }

  @Override
  public void bindListeners() {
    view.getSearchBtn().addActionListener(e -> searchForDeduction());
    view.getCloseBtn().addActionListener(e -> close());
    view.getClearBtn().addActionListener(e -> clearForm());


  }

  private void searchForDeduction() {
    boolean isValid =
        validator.validate(view.getDeductionNameTxt().getText());
    if (isValid) {
      
      // send pojo to rest endpoint for search
      DeductionDTO loadedDTO = restClient.searchSavingsForDeduction(view.getDeductionNameTxt().getText());
      loadSavingsDTO(loadedDTO);
    }

  }

  private void loadSavingsDTO(DeductionDTO loadedDTO) {
    this.view.getAmountTxt().setText(loadedDTO.getAmount().toPlainString());
    this.view.getDeductionNameTxt().setText(loadedDTO.getName());
    
  }

  @Override
  public SavingsSearchView getView() {
    return this.view;
  }

  @Override
  public void clearForm() {
    view.getAmountTxt().setText(null);
    view.getDeductionNameTxt().setText(null);
  }

  @Override
  public void close() {
    clearForm();
    view.dispose();
  }

}
