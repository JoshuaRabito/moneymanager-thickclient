package main;

import static javax.swing.UIManager.setLookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import cdi.MyWeldContainer;
import swing.api.LookAndFeel;
import swing.controller.MainFrameController;


public class ClientLauncher {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {

        try {
          setLookAndFeel(LookAndFeel.ALUMINIUM.getLookAndFeel());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
            | UnsupportedLookAndFeelException e) {
          e.printStackTrace();
        }

        MyWeldContainer.INSTANCE.getContainer().select(MainFrameController.class).get()
            .initMainFrame();
      }
    });
  }

}
