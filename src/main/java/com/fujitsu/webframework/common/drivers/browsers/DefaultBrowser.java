package com.fujitsu.webframework.common.drivers.browsers;

import com.fujitsu.webframework.common.drivers.MainWebDriver;
import com.fujitsu.webframework.common.configuration.Configuration;
import com.fujitsu.webframework.common.drivers.Browser;
import com.fujitsu.webframework.common.drivers.BrowserAbstract;
//import com.fujitsu.webframework.common.logging.PageObjectLogging;

public class DefaultBrowser extends BrowserAbstract {

  private BrowserAbstract browserClass;

  DefaultBrowser() {
    try {
      browserClass = Browser.lookup(Configuration.getBrowser()).getBrowserClass().newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
      //TODO!!
      //PageObjectLogging.logError("Could not initialize the browser", e);
    }
  }

  @Override
  public void setOptions() {
    browserClass.setOptions();
  }

  @Override
  public MainWebDriver create() {
    return browserClass.create();
  }

//  @Override
//  public void addExtension(String extensionName) {
//    browserClass.addExtension(extensionName);
//  }
}
