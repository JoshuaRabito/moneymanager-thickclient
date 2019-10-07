package swing.controller;

import java.beans.PropertyVetoException;

import javax.swing.SwingUtilities;

import swing.view.DeductionView;
import swing.view.MainFrame;
import swing.view.NetIncomeView;

public enum MainFrameController {
	INSTANCE;

	private MainFrame mainFrame;

	private MainFrameController() {
		
	}

	
	
	public MainFrame initMainFrame() {
		init();
		bindListeners();
		return mainFrame;
	}
	
	private void init() {
		this.mainFrame = new MainFrame();
		
	}

	private void bindListeners() {
		mainFrame.getDeductionItem().addActionListener(e -> {
			openDeductionView();
		});
		
		mainFrame.getNetIncomeItem().addActionListener(e -> {
			openNetIncomeView();
		});
		
		
	}
	
	private void openDeductionView() {
		SwingUtilities.invokeLater(() ->{
			DeductionView deductionView = DeductionViewController.INSTANCE.getView();
			mainFrame.getContentPane().add(deductionView);
		});
		
		
	}
	
	private void openNetIncomeView() {
		SwingUtilities.invokeLater(() ->{
			NetIncomeView netView = NetIncomeViewController.INSTANCE.getView();
			mainFrame.getContentPane().add(netView);
			
			
		});
		
	}

	
	

}
