package main;

import static javax.swing.UIManager.setLookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import org.jboss.weld.exceptions.IllegalStateException;
import cdi.MyWeldContainer;
import swing.api.LookAndFeel;
import swing.controller.MainFrameController;


public class ClientLauncher {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      try {
        setLookAndFeel(LookAndFeel.ALUMINIUM.getLookAndFeel());
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
          | UnsupportedLookAndFeelException e) {
        throw new IllegalStateException("Could not launch client.", e);
      }

      MyWeldContainer.INSTANCE.getContainer().instance().select(MainFrameController.class).get()
          .initMainFrame();
    });
  }

}
