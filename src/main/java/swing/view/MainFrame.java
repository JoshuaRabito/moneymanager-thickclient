package swing.view;

import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.*;

import swing.controller.MainViewController;

public class MainFrame extends JFrame {

	public MainFrame() throws HeadlessException {
		this.setTitle("Intial frame");
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(700, 700));
		
		JOptionPane.showMessageDialog(this, "Not too bad!");
		init();
	}

	private void init() {
		add(MainViewController.INSTANCE.getView());
	}


}
