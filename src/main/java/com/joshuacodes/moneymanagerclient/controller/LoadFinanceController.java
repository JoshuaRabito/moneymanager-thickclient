package com.joshuacodes.moneymanagerclient.controller;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import com.joshuacodes.moneymanagerclient.api.BookBalanceRestClient;
import com.joshuacodes.moneymanagerclient.api.DeductionTableModel;
import com.joshuacodes.moneymanagerclient.api.ViewActions;
import com.joshuacodes.moneymanagerclient.model.AccountDTO;
import com.joshuacodes.moneymanagerclient.model.DeductionDTO;
import com.joshuacodes.moneymanagerclient.model.DeductionsInMemory;
import com.joshuacodes.moneymanagerclient.validator.LoadFinanceValidator;
import com.joshuacodes.moneymanagerclient.view.LoadFinanceView;

@ApplicationScoped
public class LoadFinanceController implements ViewActions<LoadFinanceView> {

  private LoadFinanceView view;
  private LoadFinanceValidator validator;

  @Inject
  private BookBalanceRestClient restClient;
  
  @Inject
  private DeductionsInMemory deductionsInMemory;



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
    view.getDeductionTable().getSelectionModel().addListSelectionListener(e -> enableViewBtn());
  }

  private void loadFinances() {
    boolean isValid =
        validator.validate(view.getAccountNameTxt().getText(), view.getCreatedDatePicker().getDate(),
            view.getFirstNameTxt().getText(), view.getLastNameTxt().getText());
    if (isValid) {
      // send data to rest end point for storage
      sendSearchDataToEndPoint();
    }
  }
  
  private void enableViewBtn() {
    view.getViewBtn().setEnabled(isRowSelected());
  }
  

  private boolean isRowSelected() {
    return view.getDeductionTable().getSelectedRow() != -1;
  }

  private void sendSearchDataToEndPoint() {
    AccountDTO account =
        restClient.loadFinances(view.getAccountNameTxt().getText(), view.getCreatedDatePicker().getDate());
    loadDataInGrid(account.getDeductions());
    loadDataInForm(account);
    deductionsInMemory.removeAll();
    deductionsInMemory.getDeductions().addAll(account.getDeductions());
  }

  private void loadDataInGrid(List<DeductionDTO> deductions) {
    DeductionTableModel model = (DeductionTableModel) view.getDeductionTable().getModel();
    model.addDeductions(deductions);
  }
  
  private void loadDataInForm(AccountDTO account) {
    view.getAccountNameTxt().setText(account.getAccountName());
    view.getCreatedDatePicker().setDate(account.getDateCreated());
    view.getNetAmountTxt().setText(String.valueOf(account.getNetAmount())); 
  }

  @Override
  public LoadFinanceView getView() {
    return view;
  }

  @Override
  public void clearForm() {
    view.getFirstNameTxt().setText(null);
    view.getLastNameTxt().setText(null);
    view.getAccountNameTxt().setText(null);
    view.getCreatedDatePicker().setDate(null);
    view.getNetAmountTxt().setText(null);
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
