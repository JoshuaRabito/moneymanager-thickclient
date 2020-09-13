package cdi;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import swing.api.BookBalanceRestClient;
import swing.controller.AddDeductionViewController;
import swing.controller.DeductionViewController;
import swing.controller.DeductionsInMemory;
import swing.controller.LoadFinanceController;
import swing.controller.LookAndFeelViewController;
import swing.controller.MainFrameController;
import swing.controller.NetIncomeViewController;

@Dependent
public class CDIInjector {
  
  @Inject
  private DeductionsInMemory deductionsInMemory;
  
  @Inject
  private AddDeductionViewController addDeductionsViewController;
    
  @Inject
  private DeductionViewController deductionsViewController;
  
  @Inject
  private LoadFinanceController loadFinanceController;
  
  @Inject
  private LookAndFeelViewController lookAndFeelViewController;
  
  @Inject
  private MainFrameController mainFrameController;
  
  @Inject
  private NetIncomeViewController netIncomeViewController;
  
  @Inject
  private LoadFinanceController financeController;
  
  @Inject
  private BookBalanceRestClient restClient;


  public void init() {
    // TODO Auto-generated method stub
    
  }

}
