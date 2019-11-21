package swing.controller;

import java.beans.PropertyVetoException;
import java.math.BigDecimal;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import model.Deduction;
import swing.api.DeductionTableModel;
import swing.api.ViewActions;
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

	}
	
	@Override
	public void bindListeners() {
		view.getAddBtn().addActionListener(e -> {
			SwingUtilities.invokeLater(() -> {
				
				AddDeductionView addView = AddDeductionViewController.INSTANCE.getView();
				MainFrame.contentPane.add(addView);
				addView.toFront();
				addView.setVisible(true);
				try {
					addView.setSelected(true);
				} catch (PropertyVetoException ex) {
					ex.printStackTrace();
				}

			});
		});
		
		view.getDeleteBtn().addActionListener(e -> {
			DeductionTableModel model 
			= (DeductionTableModel) view.getDeductionsTable().getModel();
			DeductionsInMemory.INSTANCE.remove(model.getDeduction(view.getDeductionsTable().getSelectedRow()));
			model.removeDeduction(view.getDeductionsTable().getSelectedRow());		
		});
		
		view.getCloseBtn().addActionListener(e -> close());

	}

	@Override
	public DeductionView getView() {
		return view;
	}

	@Override
	public void clearForm() {
		DeductionTableModel model = (DeductionTableModel)view.getDeductionsTable().getModel();
		model.removeAllDeductions();
	}

	public void addDeduction(Deduction deduction) {
		DeductionTableModel model = (DeductionTableModel) view.getDeductionsTable().getModel();
		model.addDeduction(deduction);
		
	}

	@Override
	public void close() {
		view.dispose();
		
	}

}
