package swing.controller;

import javax.swing.DefaultComboBoxModel;

import swing.api.AccountType;
import swing.view.MainView;

public enum MainViewController {
	INSTANCE;

	private MainView view;

	private MainViewController() {
		initView();

	}

	private void initView() {
		view = new MainView();
		bindListeners();
		populateCombos();
	}

	private void bindListeners() {
		view.getDeductBtn().addActionListener(e -> openDeductionForm());
		view.getClearBtn().addActionListener(e -> clearForm());
		view.getCalcBtn().addActionListener(e -> calculateTotal());
	}

	private void openDeductionForm() {

	}

	private void clearForm() {

	}

	private void calculateTotal() {

	}

	private void populateCombos() {
		if (view != null) {
			view.getAccountTypeCombo().setModel(new DefaultComboBoxModel<>(AccountType.values()));
		}

	}

	public MainView getView() {
		return view;
	}

}
