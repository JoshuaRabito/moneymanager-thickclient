package swing.view;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import model.Deduction;
import net.miginfocom.swing.MigLayout;
import swing.api.AccountType;
import swing.api.Closeable;
import swing.api.DeductionType;

public class NetIncomeView extends JInternalFrame implements Closeable {

	private JComboBox<AccountType> accountTypeCombo;
	private JFormattedTextField grossAmountTxt;
	private JList<Deduction> deductionList;
	private JButton closeBtn;
	private JButton clearBtn;
	private JButton calcBtn;
	private JButton addDeductionsBtn;
	private JFormattedTextField netAmountText;

	public NetIncomeView() {
		init();
	}

	private void init() {
		setTitle("Money Manager 1.0");
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setSize(600, 500);

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addVetoableChangeListener(this::closePrompt);
		buildForm();
	}

	@Override
	public void closePrompt(PropertyChangeEvent propertyChangeEvent) {
		if (JInternalFrame.IS_CLOSED_PROPERTY.equals(propertyChangeEvent.getPropertyName())) {
			JOptionPane.showConfirmDialog(this, "Are you Sure you want to close the window?");
		}
	}

	private void buildForm() {
		// build panels for form and buttons
		JPanel formPanel = buildFormPanel();

		add(formPanel);
	}

	private JPanel buildFormPanel() {
		JPanel formPanel = new JPanel(new MigLayout());
		JLabel greetinglbl = new JLabel("Lets Manage some money!");
		JLabel accountTypeLbl = new JLabel("Account Type");
		accountTypeCombo = new JComboBox<>();
		JLabel payAmountLbl = new JLabel("Gross amount:");
		grossAmountTxt = new JFormattedTextField(new DecimalFormat("#####.##"));
		grossAmountTxt.setColumns(7);
		grossAmountTxt.setEditable(true);
		JLabel dedctionLbl = new JLabel("Deductions");
		deductionList = new JList<>();
		addDeductionsBtn = new JButton("Add Deductions");
		JLabel netAmountLbl = new JLabel("Net Amount");
		netAmountText = new JFormattedTextField(new DecimalFormat("#####.##"));
		netAmountText.setColumns(7);
		netAmountText.setEnabled(false);

		formPanel.add(greetinglbl, "span, center, gapbottom 15");
		formPanel.add(accountTypeLbl, "align label");
		formPanel.add(accountTypeCombo, "wrap");
		formPanel.add(payAmountLbl, "align label");
		formPanel.add(grossAmountTxt, "wrap");
		formPanel.add(dedctionLbl, "align label");
		formPanel.add(deductionList, "align label");
		formPanel.add(addDeductionsBtn, "wrap");
		formPanel.add(netAmountLbl, "align label");
		formPanel.add(netAmountText, "wrap");

		JPanel buttonPanel = buildButtonPanel();
		formPanel.add(buttonPanel, "dock south");
		return formPanel;
	}

	private JPanel buildButtonPanel() {
		JPanel buttonPanel = new JPanel(new MigLayout("", "[center, grow]"));
		closeBtn = new JButton("Close");
		clearBtn = new JButton("Clear");
		calcBtn = new JButton("Calculate");
		buttonPanel.add(calcBtn, "");
		buttonPanel.add(clearBtn, "");
		buttonPanel.add(closeBtn);
		return buttonPanel;
	}

	public JComboBox<AccountType> getAccountTypeCombo() {
		return accountTypeCombo;
	}

	public JList<Deduction> getDeductionList() {
		return deductionList;
	}

	public JFormattedTextField getGrossAmountTxt() {
		return grossAmountTxt;
	}

	public JFormattedTextField getNetAmountText() {
		return netAmountText;
	}

	public JButton getCloseBtn() {
		return closeBtn;
	}

	public JButton getClearBtn() {
		return clearBtn;
	}

	public JButton getCalcBtn() {
		return calcBtn;
	}

	public JButton getAddDeductionsBtn() {
		return addDeductionsBtn;
	}
	
	

}
