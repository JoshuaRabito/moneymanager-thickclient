package swing.controller;

import java.beans.PropertyVetoException;
import java.math.BigDecimal;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import swing.api.ViewActions;
import swing.api.Deduction;
import swing.api.DeductionTableModel;
import swing.api.DeductionType;
import swing.view.AddDeductionView;
import swing.view.DeductionView;

public enum DeductionViewController implements ViewActions<DeductionView>{
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
	
	@Override
	public void bindListeners() {
		view.getAddBtn().addActionListener(e -> {
//			DeductionTableModel model 
//				= (DeductionTableModel) view.getDeductionsTable().getModel();
//			model.addDeduction(new Deduction("Rent", DeductionType.RENT, BigDecimal.valueOf(1152.0)));
			SwingUtilities.invokeLater(() ->{
			AddDeductionView addView = AddDeductionViewController.INSTANCE.getView();
			JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(view);

			topFrame.add(addView);
			});
		});
		
		view.getDeleteBtn().addActionListener(e -> {
			DeductionTableModel model 
			= (DeductionTableModel) view.getDeductionsTable().getModel();
			model.removeDeduction(view.getDeductionsTable().getSelectedRow());
		});

	}

	@Override
	public void populateCombos() {
		// TODO Auto-generated method stub

	}

	@Override
	public DeductionView getView() {
		return view;
	}

	@Override
	public void clearForm() {
		// TODO Auto-generated method stub
		
	}

}
