package com.joshuacodes.moneymanagerclient.api;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourcesBundleReader {
  private static final String BUNDLE_NAME = "resources"; //$NON-NLS-1$

  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

  private ResourcesBundleReader() {}

  public static String getString(String key) {
    try {
      return RESOURCE_BUNDLE.getString(key);
    } catch (MissingResourceException e) {
      return '!' + key + '!';
    }
  }
}
