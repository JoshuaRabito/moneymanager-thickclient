package swing.view;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.util.Objects;

public class MainView extends JInternalFrame {

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
            MainView view = (MainView) propertyChangeEvent.getSource();
            JOptionPane.showConfirmDialog(this, "Are you Sure you want to close the window?");

        }

    }

    private void buildForm() {
        BorderLayout borderLayout = new BorderLayout();
        getContentPane().setLayout(borderLayout);
        JLabel greetinglbl = new JLabel("Lets Manage some money!");
        getContentPane().add(greetinglbl, BorderLayout.PAGE_START);
    }
}
