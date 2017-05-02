package com.fujitsu.webframework.common.driverprovider;

import com.fujitsu.webframework.common.drivers.MainWebDriver;
import com.fujitsu.webframework.common.configuration.Configuration;
import com.fujitsu.webframework.common.drivers.Browser;
//import com.wikia.webdriver.common.logging.PageObjectLogging;

import java.util.ArrayList;
import java.util.List;

public class DriverProvider {

  private static final List<MainWebDriver> drivers = new ArrayList<>();
  private static int ACTIVE_BROWSER_INDEX = 0;

  private DriverProvider() {}

  private static void newInstance() {
    drivers.add(Browser.lookup(Configuration.getBrowser()).getInstance());
  }

  private static MainWebDriver getBrowserDriver(int index) {
    for (; drivers.size() <= index;) {
      newInstance();
    }

    return drivers.get(index);
  }

  public static MainWebDriver getActiveDriver() {
    return getBrowserDriver(ACTIVE_BROWSER_INDEX);
  }

  public static MainWebDriver switchActiveWindow(int index) {
    ACTIVE_BROWSER_INDEX = index;
    return getActiveDriver();
  }

  public static void close() {
    for (MainWebDriver webDriver : drivers) {
      if (webDriver != null) {
        try {
          webDriver.quit();
        }catch (UnsatisfiedLinkError | NoClassDefFoundError e){
          e.printStackTrace();
          //TODO!!
          //PageObjectLogging.log("Closing Browser", e, true);
        }
      }
    }
    drivers.clear();
    ACTIVE_BROWSER_INDEX = 0;
  }
}
