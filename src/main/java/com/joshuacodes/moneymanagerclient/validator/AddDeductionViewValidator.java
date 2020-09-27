package com.joshuacodes.moneymanagerclient.validator;

import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;
import com.joshuacodes.moneymanagerclient.view.AddDeductionView;

/**
 * {@code AddDeductionViewValidator} class.
 * 
 * <p>
 * This class validates the {@link AddDeductionView} and should be used as such.
 * </p>
 * @author Rabito, Joshua
 * @since 11-29-19
 *
 */
public class AddDeductionViewValidator {

	private AddDeductionView addDeductionView;

	public AddDeductionViewValidator(AddDeductionView view) {
		this.addDeductionView = view;
	}

	public boolean validate(String amountTxt, String nameTxt) {
		
		return isAmountEntered(amountTxt) && isNameEntered(nameTxt);
	}

	private boolean isAmountEntered(String amountTxt) {
		boolean isValid = true;
		if(StringUtils.isEmpty(amountTxt)) {
			isValid = false;
			JOptionPane.showMessageDialog(addDeductionView, "Please enter an amount for the deduction.", "No Amount",
					JOptionPane.ERROR_MESSAGE);
		}
		return isValid;
	}
	
	private boolean isNameEntered(String nameTxt) {
		boolean isValid = true;
		if(StringUtils.isEmpty(nameTxt)) {
			isValid = false;
			JOptionPane.showMessageDialog(addDeductionView, "Please enter a name for the deduction.", "No Name",
					JOptionPane.ERROR_MESSAGE);
		}
		return isValid;
	}

}
