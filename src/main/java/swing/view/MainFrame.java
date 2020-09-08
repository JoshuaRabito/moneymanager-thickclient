package swing.view;

import java.awt.HeadlessException;
import javax.swing.DefaultDesktopManager;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame {

	private static final String GREETING = "Joshua, good to see you again. \nRemember that you work hard and deserve a drink."
        +"\nNow, let us talk money!";
  private JMenuItem deductionItem;
	private JMenuItem netIncomeItem;
	private JMenuItem loadItem;
	private JMenuItem lookAndFeelItem;
	public static JDesktopPane contentPane = new JDesktopPane();

	public MainFrame() throws HeadlessException {
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
		
		manageMenu.add(deductionItem);
		manageMenu.add(netIncomeItem);
		
		JMenu optionsMenu = new JMenu("Options");
		loadItem = new JMenuItem("Load");
		lookAndFeelItem = new JMenuItem("Look And Feel");
		optionsMenu.add(loadItem);
		optionsMenu.add(lookAndFeelItem);
		menuBar.add(manageMenu);
		menuBar.add(optionsMenu);//for import/export
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

	public JDesktopPane getContentPane() {
		return contentPane;
	}
	
	

}
