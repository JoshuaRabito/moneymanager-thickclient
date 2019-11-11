package swing.view;

import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import net.miginfocom.swing.MigLayout;
import swing.api.Closeable;
import swing.api.DeductionTableModel;

public class DeductionView extends JInternalFrame implements Closeable{

	private JButton addBtn;
	private JButton deleteBtn;
	private JButton closeBtn;
	private JTable deductionsTable;
	private JButton saveBtn;

	public DeductionView() {
		init();
	}

	private void init() {
		setTitle("Deductions");
		setClosable(true);
		setMaximizable(true);
		setResizable(true);
		setSize(520, 500);

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
        buttonPanel.add(addBtn, "");
        buttonPanel.add(deleteBtn, "");
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
	
	

}
