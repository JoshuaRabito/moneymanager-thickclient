package swing.controller;

import java.beans.PropertyVetoException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.swing.SwingUtilities;

import model.DeductionDTO;
import swing.api.DeductionTableModel;
import swing.api.ViewActions;
import swing.view.AddDeductionView;
import swing.view.DeductionView;
import swing.view.MainFrame;

@ApplicationScoped
public class DeductionViewController implements ViewActions<DeductionView>{

	private DeductionView view;
	
	@Inject
	private AddDeductionViewController addDeductionViewController;
	
	@Inject 
	private DeductionsInMemory deductionsInMemory;

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
				
				AddDeductionView addView = addDeductionViewController.getView();
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
			deductionsInMemory.remove(model.getDeduction(view.getDeductionsTable().getSelectedRow()));
			model.removeDeduction(view.getDeductionsTable().getSelectedRow());		
		});
		
		view.getCloseBtn().addActionListener(e -> close());
		
		view.getClearBtn().addActionListener(e -> clearForm());

	}

	@Override
	public DeductionView getView() {
		return view;
	}

	@Override
	public void clearForm() {
		DeductionTableModel model = (DeductionTableModel)view.getDeductionsTable().getModel();
		model.removeAllDeductions();
		deductionsInMemory.removeAll();
	}

	public void addDeduction(DeductionDTO deduction) {
		DeductionTableModel model = (DeductionTableModel) view.getDeductionsTable().getModel();
		model.addDeduction(deduction);
		
	}

	@Override
	public void close() {
		view.dispose();
		
	}

}
