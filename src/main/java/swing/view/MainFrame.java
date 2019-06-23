package swing.view;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import swing.controller.DeductionViewController;
import swing.controller.NetIncomeViewController;

public class MainFrame extends JFrame {

	private JMenuItem deductionItem;
	private JMenuItem netIncomeItem;

	public MainFrame() throws HeadlessException {
		this.setTitle("Money Manager 1.0");
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		init();
	}

	private void init() {
		JMenuBar menuBar = buildMenu();
		setJMenuBar(menuBar);
		setVisible(true);
		setSize(800, 800);
		JOptionPane.showMessageDialog(this, "Let's talk money!");
	}

	private JMenuBar buildMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu jMenu = new JMenu("Options");
		deductionItem = new JMenuItem("Deductions");
		netIncomeItem = new JMenuItem("Net Income");

		jMenu.add(deductionItem);
		jMenu.add(netIncomeItem);
		menuBar.add(jMenu);
		return menuBar;
	}

	public JMenuItem getDeductionItem() {
		return deductionItem;
	}

	public JMenuItem getNetIncomeItem() {
		return netIncomeItem;
	}

}
