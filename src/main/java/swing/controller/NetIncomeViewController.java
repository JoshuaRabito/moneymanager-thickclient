package swing.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import org.springframework.http.HttpStatus;
import model.AccountType;
import model.BookBalanceExport;
import model.Deduction;
import swing.api.BookBalanceRestClient;
import swing.api.ViewableCombo;
import swing.validator.NetIncomeViewValidator;
import swing.view.MainFrame;
import swing.view.NetIncomeView;

@ApplicationScoped
public class NetIncomeViewController implements ViewableCombo<NetIncomeView> {

  private NetIncomeView view;
  private NetIncomeViewValidator validator;
  
  @Inject 
  private DeductionsInMemory deductionsInMemory;

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
    HttpStatus status = BookBalanceRestClient.getInstance().postBookBalance(export);
    System.out.println(status);

  }

  private BookBalanceExport buildBookBalanceExport() {
    return BookBalanceExport.ExportBuilder.newInstance().with(exportBuilder -> {
      Set<Deduction> deductions = deductionsInMemory.getDeductions();
      JComboBox<AccountType> accountTypeCombo = view.getAccountTypeCombo();

      exportBuilder
          .setDeductList(Arrays.asList(deductions.toArray(new Deduction[deductions.size()])));
      exportBuilder.setType(accountTypeCombo.getItemAt(accountTypeCombo.getSelectedIndex()));
      exportBuilder.setfName(view.getFirstNameTxt().getText());
      exportBuilder.setlName(view.getLastNameTxt().getText());
      exportBuilder.setAccountName(view.getAccountNameTxt().getText());

      BigDecimal gross = BigDecimal.valueOf(Double.valueOf(view.getGrossAmountTxt().getText()));
      gross = gross.setScale(2, RoundingMode.UNNECESSARY);
      exportBuilder.setGross(gross);


      BigDecimal net = BigDecimal.valueOf(Double.valueOf(view.getNetAmountText().getText()));
      net = net.setScale(2, RoundingMode.UNNECESSARY);
      exportBuilder.setNet(net);
    }).build();
  }

  private void addDeductions() {
    Set<Deduction> deductions = deductionsInMemory.getDeductions();
    if (isDeductionsEntered(deductions)) {
      view.getDeductionList().setListData(deductions.toArray(new Deduction[deductions.size()]));
    }

  }

  private boolean isDeductionsEntered(Set<Deduction> deductions) {
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
    view.getDeductionList().setListData(new Deduction[0]);
  }

  private void calculateTotal() {
    boolean isValid =
        validator.validate(view.getGrossAmountTxt().getText(), view.getDeductionList().getModel());
    if (isValid) {
      Set<Deduction> deductions = deductionsInMemory.getDeductions();
      BigDecimal grossAmount =
          BigDecimal.valueOf(Double.valueOf(view.getGrossAmountTxt().getText()));
      for (Deduction deduction : deductions) {
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
    MainFrame.contentPane.getDesktopManager().closeFrame(view);
  }

}
