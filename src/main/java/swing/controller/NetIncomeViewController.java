package swing.controller;

import java.awt.Component;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import swing.api.AccountType;
import swing.view.DeductionView;
import swing.view.NetIncomeView;

public enum NetIncomeViewController {
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

	private void bindListeners() {
		view.getDeductBtn().addActionListener(e -> openDeductionForm());
		view.getClearBtn().addActionListener(e -> clearForm());
		view.getCalcBtn().addActionListener(e -> calculateTotal());
	}

	private void openDeductionForm() {
		SwingUtilities.invokeLater(() -> {
			DeductionView deductionView = DeductionViewController.INSTANCE.getView();
			JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(view);

			topFrame.add(deductionView);
			
	

			
		});

	}

	private void clearForm() {

	}

	private void calculateTotal() {

	}

	private void populateCombos() {
		view.getAccountTypeCombo().setModel(new DefaultComboBoxModel<>(AccountType.values()));

	}

	public NetIncomeView getView() {
		return view;
	}

}
