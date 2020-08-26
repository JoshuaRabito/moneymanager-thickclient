package swing.controller;

import javax.enterprise.context.ApplicationScoped;
import model.AccountDTO;
import model.FinanceSearchDTO;
import swing.api.BookBalanceRestClient;
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
      // build finanace search param
      FinanceSearchDTO searchDto = buildSearchDTO();
      // send data to rest end point for storage
      sendSearchDtoToEndPoint(searchDto);
    }
  }

  private void sendSearchDtoToEndPoint(FinanceSearchDTO searchDto) {
    AccountDTO account = BookBalanceRestClient.getInstance().loadFinances(searchDto);
    System.out.println(account);
  }

  private FinanceSearchDTO buildSearchDTO() {
    FinanceSearchDTO dto = new FinanceSearchDTO();
    dto.setAccountName(view.getAccountNameTxt().getText());
    dto.setDateCreated(view.getDatePicker().getDate());
    dto.setFirstName(view.getFirstNameTxt().getText());
    dto.setLastName(view.getLastNameTxt().getText());
    return dto;
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

  }

  @Override
  public void close() {
    clearForm();
    MainFrame.contentPane.getDesktopManager().closeFrame(view);
  }



}
