package swing.view;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;
import swing.api.AccountType;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.util.Objects;

public class MainView extends JInternalFrame {

    private JComboBox<AccountType> accountTypeCombo;

	public MainView() {
        init();

    }

    private void init() {
        setTitle("Money Manager 1.0");
        setVisible(true);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        //Set this to do nothing on close so we can
        //prompt user for close on X click
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addVetoableChangeListener(this::close);
        buildForm();
    }

    private void close(PropertyChangeEvent propertyChangeEvent) {
        if(JInternalFrame.IS_CLOSED_PROPERTY.equals(propertyChangeEvent.getPropertyName())) {
            JOptionPane.showConfirmDialog(this, "Are you Sure you want to close the window?");

        }

    }

    private void buildForm() {
        JLabel greetinglbl = new JLabel("Lets Manage some money!");
        JLabel accountTypeLbl = new JLabel("Account Type");
        accountTypeCombo = new JComboBox<>();
        
        Panel panel = new Panel();
        MigLayout layout = new MigLayout();
        panel.setLayout(layout);
        panel.add(greetinglbl, "cell 0 0");
        panel.add(accountTypeLbl, "cell 0 1");
        panel.add(accountTypeCombo, "cell 1 1");
        add(panel);
        
    }

	public JComboBox<AccountType> getAccountTypeCombo() {
		return accountTypeCombo;
	}
    
    
}
