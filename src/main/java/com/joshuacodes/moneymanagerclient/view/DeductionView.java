package com.joshuacodes.moneymanagerclient.view;

import com.joshuacodes.moneymanagerclient.api.DeductionTableModel;
import com.joshuacodes.moneymanagerclient.api.MyInternalFrameListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import net.miginfocom.swing.MigLayout;

public class DeductionView extends JInternalFrame {

	private JButton addBtn;
	private JButton deleteBtn;
	private JButton closeBtn;
	private JTable deductionsTable;
	private JButton saveBtn;
	private JButton clearBtn;

	public DeductionView() {
		init();
	}

	private void init() {
		setTitle("Deductions");
		setClosable(true);
		setMaximizable(true);
		setResizable(true);
		setSize(520, 500);

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addInternalFrameListener(new MyInternalFrameListener<DeductionView>(this));
		buildForm();
	}

	private void buildForm() {
        JPanel formPanel = new JPanel(new MigLayout());   
        
        deductionsTable = new JTable(new DeductionTableModel());
        JScrollPane jScrollPane = new JScrollPane(deductionsTable);
        formPanel.add(jScrollPane, "span");
        JPanel buttonPanel = buildButtonPanel();
        formPanel.add(buttonPanel,  "dock south");
        add(formPanel);     
       
	}

	private JPanel buildButtonPanel() {
		JPanel buttonPanel = new JPanel(new MigLayout("", "[center, grow]"));
        addBtn = new JButton("Add");
        deleteBtn = new JButton("Delete");
        closeBtn = new JButton("Close");
        clearBtn = new JButton("Clear");
        buttonPanel.add(addBtn, "");
        buttonPanel.add(deleteBtn, "");
        buttonPanel.add(clearBtn, "");
        buttonPanel.add(closeBtn, "");    
		return buttonPanel;
	}

	public JButton getAddBtn() {
		return addBtn;
	}

	public JButton getDeleteBtn() {
		return deleteBtn;
	}

	public JButton getCloseBtn() {
		return closeBtn;
	}

	public JTable getDeductionsTable() {
		return deductionsTable;
	}

	public JButton getSaveBtn() {
		return saveBtn;
	}

	public JButton getClearBtn() {
		return clearBtn;
	}
	
}
