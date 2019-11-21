package swing.controller;

import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;

import swing.api.AccountType;
import swing.api.ViewableCombo;
import swing.view.DeductionView;
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
		view.getDeductBtn().addActionListener(e -> openDeductionForm());
		view.getClearBtn().addActionListener(e -> clearForm());
		view.getCalcBtn().addActionListener(e -> calculateTotal());
	}

	private void openDeductionForm() {
		SwingUtilities.invokeLater(() -> {
			DeductionView deductionView = DeductionViewController.INSTANCE.getView();
			MainFrame.contentPane.add(deductionView);
			
		});

	}

	@Override
	public void clearForm() {
		view.getAmountText().setText("");
		view.getAccountTypeCombo().setSelectedItem(null);
//		view.getDeductionList().set
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

	@Override
	public void close() {
		view.dispose();
		
	}

}
