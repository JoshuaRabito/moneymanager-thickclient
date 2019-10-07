package swing.controller;

import swing.api.Deduction;
import swing.api.DeductionTableModel;
import swing.view.DeductionView;

public enum DeductionViewController {
	INSTANCE;

	private DeductionView view;

	private DeductionViewController() {
		initView();

	}

	private void initView() {
		view = new DeductionView();
		bindListeners();
		populateCombos();

	}

	private void bindListeners() {
		view.getAddBtn().addActionListener(e -> {
			DeductionTableModel model 
				= (DeductionTableModel) view.getDeductionsTable().getModel();
			model.addDeduction(new Deduction());
		});

	}

	private void populateCombos() {
		// TODO Auto-generated method stub

	}

	public DeductionView getView() {
		return view;
	}

}
