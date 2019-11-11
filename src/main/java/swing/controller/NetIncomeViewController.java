package swing.controller;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import swing.api.AccountType;
import swing.api.ViewActions;
import swing.view.DeductionView;
import swing.view.NetIncomeView;

public enum NetIncomeViewController implements ViewActions<NetIncomeView>{
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

	@Override
	public void clearForm() {

	}

	private void calculateTotal() {

	}

	@Override
	public void populateCombos() {
		view.getAccountTypeCombo().setModel(new DefaultComboBoxModel<>(AccountType.values()));

	}

	@Override
	public NetIncomeView getView() {
		return view;
	}

}
