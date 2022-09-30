package com.joshuacodes.moneymanagerclient.controller;

import com.joshuacodes.moneymanagerclient.api.BookBalanceRestClient;
import com.joshuacodes.moneymanagerclient.api.DeductionTableModel;
import com.joshuacodes.moneymanagerclient.api.ViewActions;
import com.joshuacodes.moneymanagerclient.model.AccountDTO;
import com.joshuacodes.moneymanagerclient.model.DeductionDTO;
import com.joshuacodes.moneymanagerclient.model.DeductionsInMemory;
import com.joshuacodes.moneymanagerclient.validator.LoadFinanceValidator;
import com.joshuacodes.moneymanagerclient.view.AddDeductionView;
import com.joshuacodes.moneymanagerclient.view.LoadFinanceView;
import com.joshuacodes.moneymanagerclient.view.MainFrame;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.beans.PropertyVetoException;
import java.util.List;
import javax.swing.SwingUtilities;

@ApplicationScoped
public class LoadFinanceController implements ViewActions<LoadFinanceView> {

  private LoadFinanceView view;
  private LoadFinanceValidator validator;

  @Inject
  private BookBalanceRestClient restClient;

  @Inject
  private DeductionsInMemory deductionsInMemory;

  @Inject
  private AddDeductionViewController addDeductionViewController;



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
    view.getViewBtn().addActionListener(e -> showAddDeductionView());
  }

  private void showAddDeductionView() {
    SwingUtilities.invokeLater(() -> {

      AddDeductionView addView = addDeductionViewController.getView();
      addDeductionViewController
          .loadDeductionInView(((DeductionTableModel) view.getDeductionTable().getModel())
              .getDeduction(view.getDeductionTable().getSelectedRow()));
      MainFrame.contentPane.add(addView);
      addView.toFront();
      addView.setVisible(true);
      try {
        addView.setSelected(true);
      } catch (PropertyVetoException ex) {
        ex.printStackTrace();
      }

    });

  }

  private void loadFinances() {
    boolean isValid = validator.validate(view.getAccountNameTxt().getText(),
        view.getCreatedDatePicker().getDate(), view.getFirstNameTxt().getText(),
        view.getLastNameTxt().getText());
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
    AccountDTO account = restClient.loadFinances(view.getAccountNameTxt().getText(),
        view.getCreatedDatePicker().getDate());
    loadDataInGrid(account.getDeductions());
    loadDataInForm(account);
    loadDeductionsInMemory(account);
  }

  private void loadDeductionsInMemory(AccountDTO account) {
    deductionsInMemory.removeAll();
    account.getDeductions().stream().forEach(deduction -> deductionsInMemory.add(deduction));
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
