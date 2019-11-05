package swing.controller;

import java.math.BigDecimal;

import swing.api.Deduction;
import swing.api.DeductionTableModel;
import swing.api.DeductionType;
import swing.view.DeductionView;

public enum DeductionViewController {
	INSTANCE;

	private DeductionView view;

	private DeductionViewController() {
		initView();

	}

	private void initView() {
		view = new DeductionView();
		view.setVisible(true);
		bindListeners();
		populateCombos();

	}

	private void bindListeners() {
		view.getAddBtn().addActionListener(e -> {
			DeductionTableModel model 
				= (DeductionTableModel) view.getDeductionsTable().getModel();
			model.addDeduction(new Deduction("Rent", DeductionType.RENT, BigDecimal.valueOf(1152.0)));
		});
		
		view.getDeleteBtn().addActionListener(e -> {
			DeductionTableModel model 
			= (DeductionTableModel) view.getDeductionsTable().getModel();
			model.removeDeduction(view.getDeductionsTable().getSelectedRow());
		});

	}

	private void populateCombos() {
		// TODO Auto-generated method stub

	}

	public DeductionView getView() {
		return view;
	}

}
