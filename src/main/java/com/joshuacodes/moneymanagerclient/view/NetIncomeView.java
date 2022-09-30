package com.joshuacodes.moneymanagerclient.view;

import com.joshuacodes.moneymanagerclient.api.MyInternalFrameListener;
import com.joshuacodes.moneymanagerclient.model.AccountType;
import com.joshuacodes.moneymanagerclient.model.DeductionDTO;
import java.awt.Font;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import net.miginfocom.swing.MigLayout;

public class NetIncomeView extends JInternalFrame {

  private static final String WRAP = "wrap";
  private static final String ALIGN_LABEL = "align label";
  private JComboBox<AccountType> accountTypeCombo;
  private JFormattedTextField grossAmountTxt;
  private JList<DeductionDTO> deductionList;
  private JButton closeBtn;
  private JButton clearBtn;
  private JButton calcBtn;
  private JButton saveBtn;
  private JButton addDeductionsBtn;
  private JFormattedTextField netAmountText;
  private JTextField firstNameTxt;
  private JTextField lastNameTxt;
  private JTextField accountNameTxt;

  public NetIncomeView() {
    init();
  }

  private void init() {
    setTitle("Money Manager");
    setVisible(true);
    setClosable(true);
    setIconifiable(true);
    setMaximizable(true);
    setResizable(true);
    setSize(500, 500);
    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    addInternalFrameListener(new MyInternalFrameListener<NetIncomeView>(this));

    buildForm();
  }



  private void buildForm() {
    // build panels for form and buttons
    JPanel formPanel = buildFormPanel();

    getContentPane().add(formPanel);
  }

  private JPanel buildFormPanel() {
    JPanel formPanel = new JPanel(new MigLayout());
    JLabel greetinglbl = new JLabel("Lets Manage some money!");
    greetinglbl.setFont(greetinglbl.getFont().deriveFont(Font.BOLD | Font.ITALIC, 18));

    JLabel fnameLbl = new JLabel("First name:");
    firstNameTxt = new JTextField();
    firstNameTxt.setColumns(7);
    JLabel lnameLbl = new JLabel("Last name:");
    lastNameTxt = new JTextField();
    lastNameTxt.setColumns(7);
    JLabel accountNameLbl = new JLabel("Account Name:");
    accountNameTxt = new JTextField();
    accountNameTxt.setColumns(15);

    JLabel accountTypeLbl = new JLabel("Account Type:");
    accountTypeCombo = new JComboBox<>();
    JLabel payAmountLbl = new JLabel("Gross amount:");
    grossAmountTxt = new JFormattedTextField(new DecimalFormat("#####.##"));
    grossAmountTxt.setColumns(7);
    grossAmountTxt.setEditable(true);
    JLabel dedctionLbl = new JLabel("Deductions:");
    deductionList = new JList<>();
    JScrollPane jScrollPane = new JScrollPane(deductionList);
    addDeductionsBtn = new JButton("Add Deductions");
    JLabel netAmountLbl = new JLabel("Net Amount:");
    netAmountText = new JFormattedTextField(new DecimalFormat("#####.##"));
    netAmountText.setColumns(7);
    netAmountText.setEnabled(false);

    formPanel.add(greetinglbl, "span, center, gapbottom 15");
    formPanel.add(fnameLbl, ALIGN_LABEL);
    formPanel.add(firstNameTxt, WRAP);
    formPanel.add(lnameLbl, ALIGN_LABEL);
    formPanel.add(lastNameTxt, WRAP);
    formPanel.add(accountNameLbl, ALIGN_LABEL);
    formPanel.add(accountNameTxt, WRAP);
    formPanel.add(accountTypeLbl, ALIGN_LABEL);
    formPanel.add(accountTypeCombo, WRAP);
    formPanel.add(payAmountLbl, ALIGN_LABEL);
    formPanel.add(grossAmountTxt, WRAP);
    formPanel.add(dedctionLbl, ALIGN_LABEL);
    formPanel.add(jScrollPane, ALIGN_LABEL);
    formPanel.add(addDeductionsBtn, WRAP);
    formPanel.add(netAmountLbl, ALIGN_LABEL);
    formPanel.add(netAmountText, WRAP);

    JPanel buttonPanel = buildButtonPanel();
    formPanel.add(buttonPanel, "dock south");
    return formPanel;
  }

  private JPanel buildButtonPanel() {
    JPanel buttonPanel = new JPanel(new MigLayout("", "[center, grow]"));
    closeBtn = new JButton("Close");
    clearBtn = new JButton("Clear");
    calcBtn = new JButton("Calculate");
    saveBtn = new JButton("Save");
    buttonPanel.add(saveBtn);
    buttonPanel.add(calcBtn, "");
    buttonPanel.add(clearBtn, "");
    buttonPanel.add(closeBtn);

    return buttonPanel;
  }

  public JComboBox<AccountType> getAccountTypeCombo() {
    return accountTypeCombo;
  }

  public JList<DeductionDTO> getDeductionList() {
    return deductionList;
  }

  public JFormattedTextField getGrossAmountTxt() {
    return grossAmountTxt;
  }

  public JFormattedTextField getNetAmountText() {
    return netAmountText;
  }

  public JButton getSaveBtn() {
    return saveBtn;
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

  public JTextField getFirstNameTxt() {
    return firstNameTxt;
  }

  public JTextField getLastNameTxt() {
    return lastNameTxt;
  }

  public JTextField getAccountNameTxt() {
    return accountNameTxt;
  }

  public void setAccountNameTxt(JTextField accountNameTxt) {
    this.accountNameTxt = accountNameTxt;
  }



}
