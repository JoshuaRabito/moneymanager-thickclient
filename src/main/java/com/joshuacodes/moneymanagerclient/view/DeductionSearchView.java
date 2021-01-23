package com.joshuacodes.moneymanagerclient.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.joshuacodes.moneymanagerclient.api.MyInternalFrameListener;
import com.joshuacodes.moneymanagerclient.model.DeductionTypes;
import net.miginfocom.swing.MigLayout;

public class DeductionSearchView extends JInternalFrame {
	private static final String ALIGN_LABEL = "align label";

	private JButton searchBtn;
	private JButton clearBtn;
	private JButton closeBtn;

	private JTextField nameTxt;
    private JComboBox<DeductionTypes> typeCombo;

	public DeductionSearchView() {
		init();
	}

	private void init() {
		setTitle("Deductions");
		setClosable(true);
		setMaximizable(true);
		setResizable(true);
		setSize(520, 500);

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addInternalFrameListener(new MyInternalFrameListener<DeductionSearchView>(this));
		buildForm();
	}

	private void buildForm() {
		JLabel greetingLabel = new JLabel("Enter in the deduction you wish to search for.");
		JLabel nameLabel = new JLabel("Name");
		nameTxt = new JTextField(8);
		nameTxt.setEditable(true);
		JLabel typeLabel = new JLabel("Type");
		typeCombo = new JComboBox<>();

		JPanel formPanel = new JPanel(new MigLayout());
		JPanel buttonPanel = buildButtonPanel();

		formPanel.add(greetingLabel, "span, center, gapbottom 15");
		formPanel.add(nameLabel, ALIGN_LABEL);
		formPanel.add(nameTxt, "wrap");
		formPanel.add(typeLabel, ALIGN_LABEL);
		formPanel.add(typeCombo, "wrap");
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

	public JButton getSearchBtn() {
		return searchBtn;
	}

	public JButton getClearBtn() {
		return clearBtn;
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
}
