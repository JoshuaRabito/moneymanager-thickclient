package swing.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;

import model.Deduction;
import swing.api.AccountType;
import swing.api.ViewableCombo;
import swing.validator.NetIncomeViewValidator;
import swing.view.MainFrame;
import swing.view.NetIncomeView;

public enum NetIncomeViewController implements ViewableCombo<NetIncomeView>{
	INSTANCE;

	private NetIncomeView view;
	private NetIncomeViewValidator validator;

	private NetIncomeViewController() {
		initView();
	}

	private void initView() {
		view = new NetIncomeView();
		validator = new NetIncomeViewValidator(view);
		bindListeners();
		populateCombos();
	}

	@Override
	public void bindListeners() {
		view.getCloseBtn().addActionListener(e -> close());
		view.getClearBtn().addActionListener(e -> clearForm());
		view.getCalcBtn().addActionListener(e -> calculateTotal());
		view.getAddDeductionsBtn().addActionListener(e -> addDeductions());
	}


	private void addDeductions() {
		Set<Deduction> deductions = DeductionsInMemory.INSTANCE.getDeductions();
		view.getDeductionList().setListData(deductions.toArray(new Deduction[deductions.size()]));
		
	}

	@Override
	public void clearForm() {
		view.getGrossAmountTxt().setText("");
		view.getAccountTypeCombo().setSelectedItem(null);
		view.getDeductionList().setListData(new Deduction[0]);
	}

	private void calculateTotal() {
		boolean isValid = validator.validate(view.getGrossAmountTxt().getText(), view.getDeductionList().getModel());
		if(isValid) {
			Set<Deduction> deductions = DeductionsInMemory.INSTANCE.getDeductions();
			BigDecimal grossAmount = BigDecimal.valueOf(Double.valueOf(view.getGrossAmountTxt().getText()));
			for (Deduction deduction : deductions) {
				grossAmount = grossAmount.subtract(deduction.getAmount());
			}
			
			view.getNetAmountText().setValue(grossAmount);
		}	
	}

	@Override
	public void populateCombos() {
		view.getAccountTypeCombo().setModel(new DefaultComboBoxModel<>(AccountType.values()));

	}

	@Override
	public NetIncomeView getView() {
		return view;
	}

	@Override
	public void close() {
		clearForm();
		MainFrame.contentPane.getDesktopManager().closeFrame(view);	
	}

}
