package swing.view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;
import net.miginfocom.swing.MigLayout;
import swing.api.DeductionTableModel;
import swing.api.MyInternalFrameListener;

public class LoadFinanceView extends JInternalFrame {

  private JTextField firstNameTxt;
  private JTextField lastNameTxt;
  private JTextField accountNameTxt;
  private JXDatePicker datePicker;
  private JButton closeBtn;
  private JButton clearBtn;
  private JButton loadBtn;
  private JTable deductionTable;

  public LoadFinanceView() {
    init();
  }

  private void init() {
    setTitle("Load Finances");
    setClosable(true);
    setMaximizable(true);
    setResizable(true);
    setSize(520, 500);

    setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
    addInternalFrameListener(new MyInternalFrameListener<LoadFinanceView>(this));
    buildForm();
  }

  private void buildForm() {
    JPanel formPanel = buildFormPanel();
    getContentPane().add(formPanel);
    
  }
  
  private JPanel buildFormPanel() {
    JPanel formPanel = new JPanel(new MigLayout());
    JLabel greetinglbl = new JLabel("Lets Manage some money!");
    greetinglbl.setFont(greetinglbl.getFont().deriveFont(Font.BOLD | Font.ITALIC, 18));

    JLabel fnameLbl = new JLabel("First name:");
    firstNameTxt = new JTextField();
    firstNameTxt.setColumns(15);
    JLabel lnameLbl = new JLabel("Last name:");
    lastNameTxt = new JTextField();
    lastNameTxt.setColumns(15);
    JLabel accountNameLbl = new JLabel("Account Name:");
    accountNameTxt = new JTextField();
    accountNameTxt.setColumns(15);

    JLabel dateCreatedLbl = new JLabel("Date Created:");
    datePicker = new JXDatePicker();

    formPanel.add(greetinglbl, "span, center, gapbottom 15");
    formPanel.add(fnameLbl, "align label");
    formPanel.add(firstNameTxt, "wrap");
    formPanel.add(lnameLbl, "align label");
    formPanel.add(lastNameTxt, "wrap");
    formPanel.add(accountNameLbl, "align label");
    formPanel.add(accountNameTxt, "wrap");
    formPanel.add(dateCreatedLbl, "align label");
    formPanel.add(datePicker, "wrap");
   
    deductionTable = new JTable(new DeductionTableModel());
    JScrollPane accountsPane = new JScrollPane(deductionTable);
    
    formPanel.add(accountsPane, "span");
    JPanel buttonPanel = buildButtonPanel();
    formPanel.add(buttonPanel, "dock south");
    return formPanel;
  }

  private JPanel buildButtonPanel() {
    JPanel buttonPanel = new JPanel(new MigLayout("", "[center, grow]"));
    closeBtn = new JButton("Close");
    clearBtn = new JButton("Clear");
    loadBtn = new JButton("Load");
    buttonPanel.add(loadBtn, "");
    buttonPanel.add(clearBtn, "");
    buttonPanel.add(closeBtn);

    return buttonPanel;
  }

  public JTextField getFirstNameTxt() {
    return firstNameTxt;
  }

  public void setFirstNameTxt(JTextField firstNameTxt) {
    this.firstNameTxt = firstNameTxt;
  }

  public JTextField getLastNameTxt() {
    return lastNameTxt;
  }

  public void setLastNameTxt(JTextField lastNameTxt) {
    this.lastNameTxt = lastNameTxt;
  }

  public JTextField getAccountNameTxt() {
    return accountNameTxt;
  }

  public void setAccountNameTxt(JTextField accountNameTxt) {
    this.accountNameTxt = accountNameTxt;
  }

  public JXDatePicker getDatePicker() {
    return datePicker;
  }

  public void setDatePicker(JXDatePicker datePicker) {
    this.datePicker = datePicker;
  }

  public JButton getCloseBtn() {
    return closeBtn;
  }

  public void setCloseBtn(JButton closeBtn) {
    this.closeBtn = closeBtn;
  }

  public JButton getClearBtn() {
    return clearBtn;
  }

  public void setClearBtn(JButton clearBtn) {
    this.clearBtn = clearBtn;
  }

  public JButton getLoadBtn() {
    return loadBtn;
  }

  public void setLoadBtn(JButton loadBtn) {
    this.loadBtn = loadBtn;
  }

  public JTable getDeductionTable() {
    return deductionTable;
  }
}
