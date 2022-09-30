package com.joshuacodes.moneymanagerclient.main;

import static javax.swing.UIManager.setLookAndFeel;

import com.joshuacodes.moneymanagerclient.api.LookAndFeel;
import com.joshuacodes.moneymanagerclient.cdi.CDIInjector;
import com.joshuacodes.moneymanagerclient.controller.MainFrameController;
import java.util.Objects;
import javax.swing.SwingUtilities;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.exceptions.IllegalStateException;


public class ClientLauncher {


  private static WeldContainer weldContainer;

  public static void main(String[] args) {
    Weld weld = new Weld();
    weldContainer = weld.initialize();
    weldContainer.select(CDIInjector.class).get().init();
    weldContainer.select(MainFrameController.class).get().initMainFrame();

    Thread shutdown = new Thread(ClientLauncher::closeWeldContainer);
    Runtime.getRuntime().addShutdownHook(shutdown);

    SwingUtilities.invokeLater(() -> {
      try {
        setLookAndFeel(LookAndFeel.ALUMINIUM.getLookAndFeel());

      } catch (Exception e) {
        throw new IllegalStateException("Could not launch client.", e);
      }

    });


  }

  public static void closeWeldContainer() {
    if(Objects.nonNull(weldContainer) && weldContainer.isRunning()){
      System.out.println("Closing weld container");

      weldContainer.close();

    }
  }

}
