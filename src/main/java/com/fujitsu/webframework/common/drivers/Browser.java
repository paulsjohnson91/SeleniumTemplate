package com.fujitsu.webframework.common.drivers;

import com.fujitsu.webframework.common.drivers.MainWebDriver;
import com.fujitsu.webframework.common.drivers.browsers.*;
//import com.wikia.webdriver.common.logging.PageObjectLogging;

public enum Browser {
  CHROME(ChromeBrowser.class, "CHROME"), FIREFOX(FirefoxBrowser.class, "FF"), CHROME_MOBILE(
      ChromeBrowser.class, "CHROMEMOBILEMERCURY"), HTMLUNIT(HtmlUnitBrowser.class,
          "HTMLUNIT"), GHOST(GhostBrowser.class, "GHOST"), CHROME_ANDROID(AndroidBrowser.class,
              "ANDROID"), DEFAULT(DefaultBrowser.class, "");

  private Class<? extends BrowserAbstract> browserClass;
  private String name;

  Browser(Class<? extends BrowserAbstract> browserClass, String name) {
    this.name = name;
    this.browserClass = browserClass;
  }

  public static Browser lookup(String browserName) {
    for (Browser name : Browser.values()) {
      if (name.getName().equalsIgnoreCase(browserName)) {
        return name;
      }
    }
    return null;
  }

  public String getName() {
    return name;
  }

  public MainWebDriver getInstance() {
    try {
      return browserClass.newInstance().getInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
      //TODO!!
      //PageObjectLogging.logError("Could not initialize the browser", e);
    }
    return null;
  }

  public Class<? extends BrowserAbstract> getBrowserClass() {
    return browserClass;
  }
}
