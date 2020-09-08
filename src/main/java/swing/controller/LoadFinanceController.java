package swing.controller;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import model.AccountDTO;
import model.DeductionDTO;
import swing.api.BookBalanceRestClient;
import swing.api.DeductionTableModel;
import swing.api.ViewActions;
import swing.validator.LoadFinanceValidator;
import swing.view.LoadFinanceView;
import swing.view.MainFrame;

@ApplicationScoped
public class LoadFinanceController implements ViewActions<LoadFinanceView> {

  private LoadFinanceView view;
  private LoadFinanceValidator validator;



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
    AccountDTO account = BookBalanceRestClient.getInstance()
        .loadFinances(view.getAccountNameTxt().getText(), view.getDatePicker().getDate());
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
    DeductionTableModel model = (DeductionTableModel)view.getDeductionTable().getModel();
    model.removeAllDeductions();
  }

  @Override
  public void close() {
    clearForm();
    MainFrame.contentPane.getDesktopManager().closeFrame(view);
  }



}
