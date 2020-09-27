package com.joshuacodes.moneymanagerclient.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import org.springframework.http.HttpStatus;
import com.joshuacodes.moneymanagerclient.api.BookBalanceRestClient;
import com.joshuacodes.moneymanagerclient.api.ViewActions;
import com.joshuacodes.moneymanagerclient.api.ViewableCombo;
import com.joshuacodes.moneymanagerclient.model.AccountType;
import com.joshuacodes.moneymanagerclient.model.BookBalanceExport;
import com.joshuacodes.moneymanagerclient.model.DeductionDTO;
import com.joshuacodes.moneymanagerclient.model.DeductionsInMemory;
import com.joshuacodes.moneymanagerclient.validator.NetIncomeViewValidator;
import com.joshuacodes.moneymanagerclient.view.NetIncomeView;

@ApplicationScoped
public class NetIncomeViewController implements ViewableCombo<NetIncomeView>, ViewActions<NetIncomeView> {

  private NetIncomeView view;
  private NetIncomeViewValidator validator;
  
  @Inject 
  private DeductionsInMemory deductionsInMemory;
  
  @Inject
  private Logger logger;
  
  @Inject
  private BookBalanceRestClient restClient;

  private NetIncomeViewController() {
    initView();
  }

  private void initView() {
    view = new NetIncomeView();
    validator = new NetIncomeViewValidator(view);
    bindListeners();
    populateCombos();
  }

  @Override
  public void bindListeners() {
    view.getCloseBtn().addActionListener(e -> close());
    view.getClearBtn().addActionListener(e -> clearForm());
    view.getCalcBtn().addActionListener(e -> calculateTotal());
    view.getAddDeductionsBtn().addActionListener(e -> addDeductions());
    view.getSaveBtn().addActionListener(e -> save());
  }


  private void save() {
    // validate net has been calculated
    boolean isValid =
        validator.validate(view.getGrossAmountTxt().getText(), view.getDeductionList().getModel());
    if (isValid) {
      // build managedFinanceExport
      BookBalanceExport export = buildBookBalanceExport();
      // send data to rest end point for storage
      sendExportToRestEndPoint(export);
    }

  }

  private void sendExportToRestEndPoint(BookBalanceExport export) {
    HttpStatus status = restClient.postBookBalance(export);
    logger.log(Level.INFO, "Status of posting finances is {0}", status);

  }

  private BookBalanceExport buildBookBalanceExport() {
    Set<DeductionDTO> deductions = deductionsInMemory.getDeductions();
    BigDecimal net = BigDecimal.valueOf(Double.valueOf(view.getNetAmountText().getText()));
    net = net.setScale(2, RoundingMode.UNNECESSARY);
    BigDecimal gross = BigDecimal.valueOf(Double.valueOf(view.getGrossAmountTxt().getText()));
    gross = gross.setScale(2, RoundingMode.UNNECESSARY);

    JComboBox<AccountType> accountTypeCombo = view.getAccountTypeCombo();

    return new BookBalanceExport.ExportBuilder()
        .setDeductList(Arrays.asList(deductions.toArray(new DeductionDTO[deductions.size()])))
        .setType(accountTypeCombo.getItemAt(accountTypeCombo.getSelectedIndex()))
        .setfName(view.getFirstNameTxt().getText()).setlName(view.getLastNameTxt().getText())
        .setAccountName(view.getAccountNameTxt().getText())
        .setGross(gross)
        .setNet(net).build();
  }

  private void addDeductions() {
    Set<DeductionDTO> deductions = deductionsInMemory.getDeductions();
    if (isDeductionsEntered(deductions)) {
      view.getDeductionList().setListData(deductions.toArray(new DeductionDTO[deductions.size()]));
    }

  }

  private boolean isDeductionsEntered(Set<DeductionDTO> deductions) {
    return deductions != null && !deductions.isEmpty();
  }

  @Override
  public void clearForm() {
    view.getGrossAmountTxt().setText("");
    view.getNetAmountText().setText("");
    view.getFirstNameTxt().setText("");
    view.getLastNameTxt().setText("");
    view.getAccountNameTxt().setText("");
    view.getAccountTypeCombo().setSelectedItem(null);
    view.getDeductionList().setListData(new DeductionDTO[0]);
  }

  private void calculateTotal() {
    boolean isValid =
        validator.validate(view.getGrossAmountTxt().getText(), view.getDeductionList().getModel());
    if (isValid) {
      Set<DeductionDTO> deductions = deductionsInMemory.getDeductions();
      BigDecimal grossAmount =
          BigDecimal.valueOf(Double.valueOf(view.getGrossAmountTxt().getText()));
      for (DeductionDTO deduction : deductions) {
        grossAmount = grossAmount.subtract(deduction.getAmount());
      }

      view.getNetAmountText().setValue(grossAmount);
    }
  }

  @Override
  public void populateCombos() {
    view.getAccountTypeCombo().setModel(new DefaultComboBoxModel<>(AccountType.values()));

  }

  @Override
  public NetIncomeView getView() {
    return view;
  }

  @Override
  public void close() {
    clearForm();
    view.dispose();
  }

}
