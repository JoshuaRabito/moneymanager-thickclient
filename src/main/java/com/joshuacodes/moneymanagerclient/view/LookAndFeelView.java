package com.joshuacodes.moneymanagerclient.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import com.joshuacodes.moneymanagerclient.api.LookAndFeel;
import com.joshuacodes.moneymanagerclient.api.MyInternalFrameListener;
import net.miginfocom.swing.MigLayout;

public class LookAndFeelView extends JInternalFrame {
	
	private JComboBox<LookAndFeel> layoutCombo;
	private JButton saveBtn;
	private JButton clearBtn;
	private JButton closeBtn;

	public LookAndFeelView() {
		init();
	}

	private void init() {
		setTitle("Change Look and Feel");
		setClosable(true);
		setMaximizable(true);
		setResizable(true);
		setSize(600, 500);

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addInternalFrameListener(new MyInternalFrameListener<LookAndFeelView>(this));
		buildForm();

	}

	private void buildForm() {
		JLabel greetingLabel = new JLabel("Please select the look and feel for your application.");
	
		JLabel layoutLabel = new JLabel("Layout");
		layoutCombo = new JComboBox<>();
	

		JPanel formPanel = new JPanel(new MigLayout());
		JPanel buttonPanel = buildButtonPanel();
		
		formPanel.add(greetingLabel, "span, center, gapbottom 15");
		formPanel.add(layoutLabel, "align label");
		formPanel.add(layoutCombo, "wrap");
	
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

	public JComboBox<LookAndFeel> getLayoutCombo() {
		return layoutCombo;
	}

	public JButton getSaveBtn() {
		return saveBtn;
	}

	public JButton getClearBtn() {
		return clearBtn;
	}

	public JButton getCloseBtn() {
		return closeBtn;
	}

}
