package swing;

import javax.swing.*;
import swing.view.MainFrame;

import static javax.swing.UIManager.setLookAndFeel;

public class ClientLauncher {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceMagellanLookAndFeel");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				MainFrame frame = new MainFrame();
				
				
			}
		});
	}

}
