package swing.controller;

import java.math.BigDecimal;

import javax.swing.DefaultComboBoxModel;

import model.Deduction;
import swing.api.DeductionType;
import swing.api.ViewableCombo;
import swing.validator.AddDeductionViewValidator;
import swing.view.AddDeductionView;
import swing.view.MainFrame;

public enum AddDeductionViewController implements ViewableCombo<AddDeductionView>{
	INSTANCE;
	
	private AddDeductionView view;
	private AddDeductionViewValidator validator;

	private AddDeductionViewController() {		
		initView();
		validator = new AddDeductionViewValidator(view);
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
		view.getCloseBtn().addActionListener(e -> close());
	}

	private void saveDeduction() {
		if(validator.validate(view.getAmountTxt().getText(), view.getNameTxt().getText())) {
			Deduction deduction = buildDeduction();
			DeductionViewController.INSTANCE.addDeduction(deduction);
			DeductionsInMemory.INSTANCE.add(deduction);
		}				
	}

	private Deduction buildDeduction() {
		Deduction deduction = new Deduction();
		deduction.setAmount(BigDecimal.valueOf(Double.valueOf(view.getAmountTxt().getText())));
		deduction.setName(view.getNameTxt().getText());
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
		view.getTypeCombo().setSelectedItem(null);
		view.getNameTxt().setText("");
		view.getNameTxt().setText("");
	}

	@Override
	public void close() {
		MainFrame.contentPane.getDesktopManager().closeFrame(view);
		
	}

}
