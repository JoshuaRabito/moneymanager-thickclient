package com.joshuacodes.moneymanagerclient.cdi;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class LoggerFactory {
  
  
  @Produces
  public Logger produceLogger(InjectionPoint injectionPoint) {
    return Logger.getLogger(injectionPoint.getBean().getBeanClass().getName());
  }

}
