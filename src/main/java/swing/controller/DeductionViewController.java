package swing.controller;

import java.beans.PropertyVetoException;
import java.math.BigDecimal;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import swing.api.ViewActions;
import swing.api.Deduction;
import swing.api.DeductionTableModel;
import swing.api.DeductionType;
import swing.view.AddDeductionView;
import swing.view.DeductionView;
import swing.view.MainFrame;

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
			SwingUtilities.invokeLater(() ->{
			AddDeductionView addView = AddDeductionViewController.INSTANCE.getView();
			boolean isViewAdded = Stream.of(MainFrame.contentPane.getComponents()).anyMatch(i -> i instanceof AddDeductionView);
			if(!isViewAdded) {
				MainFrame.contentPane.add(addView);
				addView.moveToFront();
			}
			
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

	public void addDeduction(Deduction deduction) {
		// TODO Auto-generated method stub
		
	}

}
