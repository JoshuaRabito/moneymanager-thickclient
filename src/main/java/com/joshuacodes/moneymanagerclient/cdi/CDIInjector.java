package com.joshuacodes.moneymanagerclient.cdi;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import com.joshuacodes.moneymanagerclient.api.BookBalanceRestClient;
import com.joshuacodes.moneymanagerclient.controller.AddDeductionViewController;
import com.joshuacodes.moneymanagerclient.controller.DeductionViewController;
import com.joshuacodes.moneymanagerclient.controller.LoadFinanceController;
import com.joshuacodes.moneymanagerclient.controller.LookAndFeelViewController;
import com.joshuacodes.moneymanagerclient.controller.MainFrameController;
import com.joshuacodes.moneymanagerclient.controller.NetIncomeViewController;
import com.joshuacodes.moneymanagerclient.model.DeductionsInMemory;

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
  private BookBalanceRestClient restClient;
  
  @Inject 
  private Logger logger;


  public void init() {
    logger.log(Level.INFO, "Setting CDI Injections");
    
  }

}
