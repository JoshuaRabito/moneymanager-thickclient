package swing.api;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

/**
 * {@code MyInternalFrameListener} Class
 * 
 * <br>This class is used to override the InternalFrameClosing method so that 
 * a prompt can be used to ask user if he/she wishes to close the view. </br>
 * 
 * @since 2020-01-05
 * @author Rabito, Joshua
 *
 */
public class MyInternalFrameListener<T extends JInternalFrame> implements InternalFrameListener {

	private T view;

	public MyInternalFrameListener(T view) {
		this.view = view;
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		int selectedOption = JOptionPane.showConfirmDialog(view, "Are you Sure you want to close the window?");
		if (selectedOption == JOptionPane.YES_OPTION) {
			view.dispose();
		}
		
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

}
