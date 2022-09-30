package com.joshuacodes.moneymanagerclient.view;

import com.joshuacodes.moneymanagerclient.api.MyInternalFrameListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import net.miginfocom.swing.MigLayout;

public class SavingsSearchView extends JInternalFrame {
  private static final String ALIGN_LABEL = "align label";

  private JButton searchBtn;
  private JButton clearBtn;
  private JButton closeBtn;

  private JTextField deductionNameTxt;
  private JFormattedTextField amountTxt;

  public SavingsSearchView() {
    init();
  }

  private void init() {
    setTitle("Savings Search");
    setClosable(true);
    setMaximizable(true);
    setResizable(true);
    setSize(520, 500);

    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    addInternalFrameListener(new MyInternalFrameListener<SavingsSearchView>(this));
    buildForm();
  }

  private void buildForm() {
    JLabel greetingLabel = new JLabel("Enter in the deduction you wish to search for.");
    
    JLabel deductionNameLabel = new JLabel("Deduction Name");
    deductionNameTxt = new JTextField(8);
    deductionNameTxt.setEditable(true);
    JLabel amountLabel = new JLabel("Amount (Sum)");
    amountTxt = new JFormattedTextField(new DecimalFormat("#####.##"));
    amountTxt.setColumns(8);
    amountTxt.setEditable(false);

    JPanel formPanel = new JPanel(new MigLayout());
    JPanel buttonPanel = buildButtonPanel();

    formPanel.add(greetingLabel, "span, center, gapbottom 15");
    formPanel.add(deductionNameLabel, ALIGN_LABEL);
    formPanel.add(deductionNameTxt, "wrap");
    formPanel.add(amountLabel, ALIGN_LABEL);
    formPanel.add(amountTxt, "wrap");
    formPanel.add(buttonPanel, "dock south");
    add(formPanel);

  }

  private JPanel buildButtonPanel() {
    JPanel buttonPanel = new JPanel(new MigLayout("", "[center, grow]"));
    searchBtn = new JButton("Search");
    clearBtn = new JButton("Clear");
    closeBtn = new JButton("Close");
    buttonPanel.add(searchBtn, "");
    buttonPanel.add(clearBtn, "");
    buttonPanel.add(closeBtn, "");
    return buttonPanel;
  }

  public static String getAlignLabel() {
    return ALIGN_LABEL;
  }

  public JButton getSearchBtn() {
    return searchBtn;
  }

  public JButton getClearBtn() {
    return clearBtn;
  }

  public JButton getCloseBtn() {
    return closeBtn;
  }

  public JTextField getDeductionNameTxt() {
    return deductionNameTxt;
  }

  public JFormattedTextField getAmountTxt() {
    return amountTxt;
  }

}
