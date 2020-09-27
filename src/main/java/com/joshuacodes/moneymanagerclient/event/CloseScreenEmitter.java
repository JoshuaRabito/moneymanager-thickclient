package com.joshuacodes.moneymanagerclient.event;

import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.swing.JInternalFrame;

@Dependent
public class CloseScreenEmitter {
  
  @Inject
  private Event<CloseScreenEvent> closeEvent;
  
  @Inject
  private Logger logger; 
  
  public void closeScreen(JInternalFrame frame) {
    closeEvent.fire(new CloseScreenEvent(frame));
  }
  
  
  
  
  

}
