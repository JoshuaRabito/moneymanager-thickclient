package swing.view;

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
import model.AccountType;
import model.DeductionDTO;
import net.miginfocom.swing.MigLayout;
import swing.api.MyInternalFrameListener;

public class NetIncomeView extends JInternalFrame {

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
    setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
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
    formPanel.add(fnameLbl, "align label");
    formPanel.add(firstNameTxt, "wrap");
    formPanel.add(lnameLbl, "align label");
    formPanel.add(lastNameTxt, "wrap");
    formPanel.add(accountNameLbl, "align label");
    formPanel.add(accountNameTxt, "wrap");
    formPanel.add(accountTypeLbl, "align label");
    formPanel.add(accountTypeCombo, "wrap");
    formPanel.add(payAmountLbl, "align label");
    formPanel.add(grossAmountTxt, "wrap");
    formPanel.add(dedctionLbl, "align label");
    formPanel.add(jScrollPane, "align label");
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
