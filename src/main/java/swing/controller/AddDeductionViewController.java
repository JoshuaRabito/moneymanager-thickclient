package swing.controller;

import javax.swing.DefaultComboBoxModel;

import swing.api.AccountType;
import swing.api.DeductionType;
import swing.api.ViewActions;
import swing.view.AddDeductionView;

public enum AddDeductionViewController implements ViewActions<AddDeductionView>{
	INSTANCE;
	
	private AddDeductionView view;

	private AddDeductionViewController() {
		initView();

	}

	private void initView() {
		view = new AddDeductionView();
		view.setVisible(true);
		bindListeners();
		populateCombos();
		
	}

	@Override
	public void bindListeners() {
		
	}

	@Override
	public void populateCombos() {
		view.getTypeCombo().setModel(new DefaultComboBoxModel<>(DeductionType.values()));
		
	}

	@Override
	public AddDeductionView getView() {
		return view;
	}

	@Override
	public void clearForm() {
		
	}

}
