package com.joshuacodes.moneymanagerclient.event;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import com.joshuacodes.moneymanagerclient.view.MainFrame;

@ApplicationScoped
public class CloseScreenObserver {
  
  @Inject
  private Logger logger;
  
  public void closeScreen(@Observes CloseScreenEvent event) {
    logger.log(Level.FINE, "Closing screen event observed.");
    MainFrame.contentPane.getDesktopManager().closeFrame(event.getFrame()); 

  }


}
