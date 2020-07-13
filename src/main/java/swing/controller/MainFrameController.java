package swing.controller;

import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import swing.view.DeductionView;
import swing.view.LookAndFeelView;
import swing.view.MainFrame;
import swing.view.NetIncomeView;

@ApplicationScoped
public class MainFrameController {

	private MainFrame mainFrame;
	private Map components;
	
	@Inject
	private LookAndFeelViewController lookAndFeelViewController;
	
	@Inject 
	private DeductionViewController deductionViewController;
	
	@Inject 
	private NetIncomeViewController netIncomeViewController;

	private MainFrameController() {
		components = new HashMap<>();
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
			refreshDesktopPane();
			openDeductionView();
		});
		
		mainFrame.getNetIncomeItem().addActionListener(e -> {
			refreshDesktopPane();
			openNetIncomeView();
		});
		
		mainFrame.getLookAndFeelItem().addActionListener(e -> {
			refreshDesktopPane();
			openLookAndFeelView();
		});
		
		mainFrame.getLoadItem().addActionListener(e -> {
		  refreshDesktopPane();
          openLoadView();
		});
	}



	private void openLookAndFeelView() {
		SwingUtilities.invokeLater(() -> {

			LookAndFeelView lookAndFeelView = lookAndFeelViewController.getView();
			mainFrame.getContentPane().add(lookAndFeelView);
			lookAndFeelView.toFront();
			lookAndFeelView.setVisible(true);
			try {
				lookAndFeelView.setSelected(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		});

	}



	private void refreshDesktopPane() {
		mainFrame.getContentPane().removeAll();
		mainFrame.getContentPane().updateUI();
	}
	
	private void openDeductionView() {
		SwingUtilities.invokeLater(() ->{
			
			DeductionView deductionView = deductionViewController.getView();
			mainFrame.getContentPane().add(deductionView);
			deductionView.toFront();
			deductionView.setVisible(true);
			try {
				deductionView.setSelected(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		});
		
		
	}
	
	private void openNetIncomeView() {
		SwingUtilities.invokeLater(() ->{
			NetIncomeView netView = netIncomeViewController.getView();
			mainFrame.getContentPane().add(netView);
			netView.toFront();
			netView.setVisible(true);
			try {
				netView.setSelected(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		});
		
	}
	
	private void openLoadView() {
//      SwingUtilities.invokeLater(() ->{
////          NetIncomeView netView = LoadFinanceController.INSTANCE.getView();
//          mainFrame.getContentPane().add(netView);
//          netView.toFront();
//          netView.setVisible(true);
//          try {
//              netView.setSelected(true);
//          } catch (PropertyVetoException e) {
//              e.printStackTrace();
//          }
//      });
      
  }


	public void updateComponents() {
		SwingUtilities.updateComponentTreeUI(mainFrame);
		
	}

	
	

}
