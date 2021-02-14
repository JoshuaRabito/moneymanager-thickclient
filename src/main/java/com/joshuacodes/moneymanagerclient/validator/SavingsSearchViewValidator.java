package com.joshuacodes.moneymanagerclient.validator;

import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;
import com.joshuacodes.moneymanagerclient.view.SavingsSearchView;

public class SavingsSearchViewValidator {

  private SavingsSearchView view;

  public SavingsSearchViewValidator(SavingsSearchView view) {
    this.view = view;
  }

  public boolean validate(String deductionName) {
    
    return isDeductionNameEntered(deductionName);
  }

  private boolean isDeductionNameEntered(String deductionName) {
    boolean isValid = true;
    if(StringUtils.isBlank(deductionName)) {
      isValid = false;
      JOptionPane.showMessageDialog(view, "Please enter a deduction name to search for.", "Deduction Name Not Entered",
          JOptionPane.ERROR_MESSAGE);
    }
    return isValid;
  }

}
