package swing.controller;

import java.math.BigDecimal;
import javax.swing.DefaultComboBoxModel;
import model.Deduction;
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
		view.getSaveBtn().addActionListener(e -> saveDeduction());
	}

	private void saveDeduction() {
		Deduction deduction = buildDeduction();
		DeductionViewController.INSTANCE.addDeduction(deduction);
		
	}

	private Deduction buildDeduction() {
		Deduction deduction = new Deduction();
		deduction.setAmount(BigDecimal.valueOf(Double.valueOf(view.getAmountTxt().getText())));
		deduction.setName(view.getNameTxt().getName());
		deduction.setType(DeductionType.valueOf(view.getTypeCombo().getModel().getSelectedItem().toString()));
		return deduction;
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
