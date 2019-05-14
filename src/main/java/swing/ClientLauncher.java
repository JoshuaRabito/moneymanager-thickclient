package swing;

import javax.swing.SwingUtilities;

import swing.view.FormPanel;
import swing.view.MainFrame;

public class ClientLauncher {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				MainFrame frame = new MainFrame();
				frame.add(new FormPanel());
				
				
			}
		});
	}

}
