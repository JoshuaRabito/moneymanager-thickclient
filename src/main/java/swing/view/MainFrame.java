package swing.view;

import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	public MainFrame() throws HeadlessException {
		this.setTitle("Intial frame");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(500, 500));
	}
	
	

}
