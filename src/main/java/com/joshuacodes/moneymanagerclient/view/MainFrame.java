package com.joshuacodes.moneymanagerclient.view;

import javax.swing.DefaultDesktopManager;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import com.joshuacodes.moneymanagerclient.api.ResourcesBundleReader;

public class MainFrame extends JFrame {

	private static final String GREETING = ResourcesBundleReader.getString("greeting");
    private JMenuItem deductionItem;
	private JMenuItem netIncomeItem;
	private JMenuItem loadItem;
	private JMenuItem lookAndFeelItem;
	private JMenuItem searchItem;
	public static JDesktopPane contentPane = new JDesktopPane();

	public MainFrame() {
		this.setTitle("Money Manager 1.0");
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		init();
	}

	private void init() {
		setContentPane(contentPane);
		contentPane.setDesktopManager(new DefaultDesktopManager());
		JMenuBar menuBar = buildMenu();
		setJMenuBar(menuBar);
		setSize(800, 800);
		setLocationRelativeTo(null);
		JOptionPane.showMessageDialog(this, GREETING);
	}

	private JMenuBar buildMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu manageMenu = new JMenu("Manage");
		deductionItem = new JMenuItem("Deductions");
		netIncomeItem = new JMenuItem("Net Income");
	    loadItem = new JMenuItem("Load");
	    searchItem = new JMenuItem("Search");
		
		manageMenu.add(deductionItem);
		manageMenu.add(netIncomeItem);
		manageMenu.add(loadItem);
		manageMenu.add(searchItem);
		
		JMenu optionsMenu = new JMenu("Options");
		lookAndFeelItem = new JMenuItem("Look And Feel");
		optionsMenu.add(lookAndFeelItem);
		menuBar.add(manageMenu);
		menuBar.add(optionsMenu);
		return menuBar;
	}

	public JMenuItem getDeductionItem() {
		return deductionItem;
	}

	public JMenuItem getNetIncomeItem() {
		return netIncomeItem;
	}

	public JMenuItem getLookAndFeelItem() {
		return lookAndFeelItem;
	}
	
    public JMenuItem getLoadItem() {
      return loadItem;
    }

	public JMenuItem getSearchItem() {
		return searchItem;
	}

	public JDesktopPane getContentPane() {
		return contentPane;
	}
	
	

}
