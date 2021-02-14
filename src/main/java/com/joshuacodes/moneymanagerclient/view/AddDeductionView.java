package com.joshuacodes.moneymanagerclient.view;

import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import com.joshuacodes.moneymanagerclient.api.MyInternalFrameListener;
import com.joshuacodes.moneymanagerclient.model.DeductionTypes;
import net.miginfocom.swing.MigLayout;

public class AddDeductionView extends JInternalFrame {

	private static final String ALIGN_LABEL = "align label";
    private JButton saveBtn;
	private JButton closeBtn;
	private JTextField nameTxt;
	private JComboBox<DeductionTypes> typeCombo;
	private JFormattedTextField amountTxt;
	private JButton clearBtn;

	public AddDeductionView() {
		init();
	}

	private void init() {
		setTitle("New Deduction");
		setClosable(true);
		setMaximizable(true);
		setResizable(true);
		setSize(600, 500);

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addInternalFrameListener(new MyInternalFrameListener<AddDeductionView>(this));
		buildForm();

	}

	private void buildForm() {
		JLabel greetingLabel = new JLabel("Enter in the information for your deduction.");
		JLabel nameLabel = new JLabel("Name");
		nameTxt = new JTextField(8);
		nameTxt.setEditable(true);
		JLabel typeLabel = new JLabel("Type");
		typeCombo = new JComboBox<>();
		JLabel amountLabel = new JLabel("Amount");
		amountTxt = new JFormattedTextField(new DecimalFormat("#####.##"));
		amountTxt.setColumns(8);
		amountTxt.setEditable(true);

		JPanel formPanel = new JPanel(new MigLayout());
		JPanel buttonPanel = buildButtonPanel();
		
		formPanel.add(greetingLabel, "span, center, gapbottom 15");
		formPanel.add(nameLabel, ALIGN_LABEL);
		formPanel.add(nameTxt, "wrap");
		formPanel.add(typeLabel, ALIGN_LABEL);
		formPanel.add(typeCombo, "wrap");
		formPanel.add(amountLabel, ALIGN_LABEL);
		formPanel.add(amountTxt);
		formPanel.add(buttonPanel, "dock south");
		add(formPanel);

	}

	private JPanel buildButtonPanel() {
		JPanel buttonPanel = new JPanel(new MigLayout("", "[center, grow]"));
		saveBtn = new JButton("Save");
		clearBtn = new JButton("Clear");
		closeBtn = new JButton("Close");
		buttonPanel.add(saveBtn, "");
		buttonPanel.add(clearBtn, "");
		buttonPanel.add(closeBtn, "");
		return buttonPanel;
	}


	public JButton getSaveBtn() {
		return saveBtn;
	}

	public JButton getCloseBtn() {
		return closeBtn;
	}

	public JTextField getNameTxt() {
		return nameTxt;
	}

	public JComboBox<DeductionTypes> getTypeCombo() {
		return typeCombo;
	}

	public JTextField getAmountTxt() {
		return amountTxt;
	}

	public JButton getClearBtn() {
		return clearBtn;
	}
}
