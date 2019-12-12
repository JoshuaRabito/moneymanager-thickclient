package swing.validator;

import javax.swing.JOptionPane;
import javax.swing.ListModel;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import model.Deduction;
import swing.view.NetIncomeView;

/**
 * {@code NetIncomeViewValidator} class.
 * 
 * <p>
 * This class validates the {@link NetIncomeView} and should be used as such.
 * </p>
 * @author Rabito, Joshua
 * @since 11-29-19
 *
 */
public class NetIncomeViewValidator {  

	private NetIncomeView view;

	public NetIncomeViewValidator(NetIncomeView view) {
		this.view = view;
	}

	public boolean validate(String grossAmt, ListModel<Deduction> listModel) {
	
		return validateGrossEntered(grossAmt)
				&& validateDeductionsEntered(listModel);
	}
	
	private boolean validateGrossEntered(String grossAmt) {
		boolean isValid = true;
		if(StringUtils.isEmpty(grossAmt)) {
			isValid = false;
			JOptionPane.showMessageDialog(view, "Please enter a gross before calculating.", "No Gross Amount",
					JOptionPane.ERROR_MESSAGE);
		}
		return isValid;
	}
	
	private boolean validateDeductionsEntered(ListModel<Deduction> listModel) {
		boolean isValid = true;
		if(listModel.getSize() == 0) {
			isValid = false;
			JOptionPane.showMessageDialog(view, "Please enter a deduction in Deductions view before calculating.", "No Deductions",
					JOptionPane.ERROR_MESSAGE);
		}
		return isValid;
		
	}

}
