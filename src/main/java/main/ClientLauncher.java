package main;

import static javax.swing.UIManager.setLookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import swing.controller.MainFrameController;


public class ClientLauncher {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
		
				try {
					setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
//					setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
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
