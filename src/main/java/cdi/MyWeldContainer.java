package cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public enum MyWeldContainer {
  INSTANCE;
  
  private WeldContainer container;
  private Weld weld;
  
  
  
  MyWeldContainer() {
    init();
  }

  private void init() {
    weld = new Weld();
    container = weld.initialize();
    CDIInjector cdiInjector = container.select(CDIInjector.class).get();
    cdiInjector.init();
  }

  public WeldContainer getContainer() {
    return container;
  }
  
  public void shutdown() {
    weld.shutdown();
  }

}
