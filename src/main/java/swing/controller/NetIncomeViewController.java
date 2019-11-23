package swing.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;

import model.Deduction;
import swing.api.AccountType;
import swing.api.ViewableCombo;
import swing.view.MainFrame;
import swing.view.NetIncomeView;

public enum NetIncomeViewController implements ViewableCombo<NetIncomeView>{
	INSTANCE;

	private NetIncomeView view;

	private NetIncomeViewController() {
		initView();
	}

	private void initView() {
		view = new NetIncomeView();
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
		Set<Deduction> deductions = DeductionsInMemory.INSTANCE.getDeductions();
		BigDecimal grossAmount = BigDecimal.valueOf(Double.valueOf(view.getGrossAmountTxt().getText()));
		for (Deduction deduction : deductions) {
			grossAmount = grossAmount.subtract(deduction.getAmount());
		}
		
		view.getNetAmountText().setValue(grossAmount);
		
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
		MainFrame.contentPane.getDesktopManager().closeFrame(view);	
	}

}
