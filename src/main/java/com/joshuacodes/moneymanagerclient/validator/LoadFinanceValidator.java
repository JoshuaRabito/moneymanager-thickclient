package com.joshuacodes.moneymanagerclient.validator;

import com.joshuacodes.moneymanagerclient.view.LoadFinanceView;
import java.util.Date;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;

public class LoadFinanceValidator {

  private LoadFinanceView view;

  public LoadFinanceValidator(LoadFinanceView view) {
    this.view = view;
  }

  public boolean validate(String accountName, Date dateCreated, String firstName, String lastName) {
    return isNameOrDateEntered(accountName, dateCreated) && isNameEntered(firstName, lastName);
  }

  private boolean isNameOrDateEntered(String accountName, Date dateCreated) {
    boolean isValid = true;
    if(StringUtils.isBlank(accountName) && dateCreated == null) {
      isValid = false;
      JOptionPane.showMessageDialog(view, "Please enter an account name or date created.", "No Account Name or Creation Date",
          JOptionPane.ERROR_MESSAGE);
    }
    return isValid;
  }
  
  private boolean isNameEntered(String firstName, String lastName) {
    boolean isValid = true;
    if(StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName)) {
      isValid = false;
      JOptionPane.showMessageDialog(view, "Please enter a first name and last name.", "User Name Not Entered",
          JOptionPane.ERROR_MESSAGE);
    }
    return isValid;
  }

}
