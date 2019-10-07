package swing;

import static javax.swing.UIManager.setLookAndFeel;

import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

import swing.controller.MainFrameController;
import swing.view.MainFrame;
import swing.view.NetIncomeView;

public class ClientLauncher {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
		
				try {
					setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceMagellanLookAndFeel");
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				MainFrameController.INSTANCE.initMainFrame();
			}
		});
	}

}
