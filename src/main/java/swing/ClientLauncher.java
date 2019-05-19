package swing;

import static javax.swing.UIManager.setLookAndFeel;

import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

import swing.view.MainFrame;
import swing.view.MainView;

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
