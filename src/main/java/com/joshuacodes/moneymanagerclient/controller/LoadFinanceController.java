package com.joshuacodes.moneymanagerclient.controller;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import com.joshuacodes.moneymanagerclient.api.BookBalanceRestClient;
import com.joshuacodes.moneymanagerclient.api.DeductionTableModel;
import com.joshuacodes.moneymanagerclient.api.ViewActions;
import com.joshuacodes.moneymanagerclient.model.AccountDTO;
import com.joshuacodes.moneymanagerclient.model.DeductionDTO;
import com.joshuacodes.moneymanagerclient.validator.LoadFinanceValidator;
import com.joshuacodes.moneymanagerclient.view.LoadFinanceView;

@ApplicationScoped
public class LoadFinanceController implements ViewActions<LoadFinanceView> {

  private LoadFinanceView view;
  private LoadFinanceValidator validator;

  @Inject
  private BookBalanceRestClient restClient;



  public LoadFinanceController() {
    initView();
  }

  private void initView() {
    view = new LoadFinanceView();
    validator = new LoadFinanceValidator(view);
    bindListeners();
  }

  @Override
  public void bindListeners() {
    view.getCloseBtn().addActionListener(e -> close());
    view.getClearBtn().addActionListener(e -> clearForm());
    view.getLoadBtn().addActionListener(e -> loadFinances());
  }

  private void loadFinances() {
    boolean isValid =
        validator.validate(view.getAccountNameTxt().getText(), view.getDatePicker().getDate(),
            view.getFirstNameTxt().getText(), view.getLastNameTxt().getText());
    if (isValid) {
      // send data to rest end point for storage
      sendSearchDataToEndPoint();
    }
  }

  private void sendSearchDataToEndPoint() {
    AccountDTO account =
        restClient.loadFinances(view.getAccountNameTxt().getText(), view.getDatePicker().getDate());
    loadDataInGrid(account.getDeductions());
  }

  private void loadDataInGrid(List<DeductionDTO> deductions) {
    DeductionTableModel model = (DeductionTableModel) view.getDeductionTable().getModel();
    model.addDeductions(deductions);
  }

  @Override
  public LoadFinanceView getView() {
    return view;
  }

  @Override
  public void clearForm() {
    view.getFirstNameTxt().setText("");
    view.getLastNameTxt().setText("");
    view.getAccountNameTxt().setText("");
    view.getDatePicker().setDate(null);
    removeDeductionsFromTable();

  }

  private void removeDeductionsFromTable() {
    DeductionTableModel model = (DeductionTableModel) view.getDeductionTable().getModel();
    model.removeAllDeductions();
  }

  @Override
  public void close() {
    clearForm();
    view.dispose();
  }



}
