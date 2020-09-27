  package com.joshuacodes.moneymanagerclient.event;

import javax.swing.JInternalFrame;

public class CloseScreenEvent {
  
  private JInternalFrame frame;

  public CloseScreenEvent(JInternalFrame frame) {
    super();
    this.frame = frame;
  }

  public JInternalFrame getFrame() {
    return frame;
  }

  public void setFrame(JInternalFrame frame) {
    this.frame = frame;
  }
  
  
  

}
