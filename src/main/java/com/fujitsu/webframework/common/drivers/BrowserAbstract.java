package com.fujitsu.webframework.common.drivers;

import com.fujitsu.webframework.common.drivers.MainWebDriver;
import com.fujitsu.webframework.common.configuration.Configuration;
//import com.fujitsu.webframework.common.logging.PageObjectLogging;
//import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public abstract class BrowserAbstract {

  protected DesiredCapabilities caps = new DesiredCapabilities();

  /**
   * Get a ready to work instance for chosen browser
   * 
   * @return
   */
  public MainWebDriver getInstance() {
    setOptions();
    //setExtensions();
    setBrowserLogging(Level.SEVERE);
    MainWebDriver webdriver = create();
    setTimeputs(webdriver);
    //setListeners(webdriver);

    return webdriver;
  }

  /**
   * Set Browser specific options, before creating a working instance
   */
  public abstract void setOptions();

  /**
   * Create a working instance of a Browser
   * 
   * @return
   */
  public abstract MainWebDriver create();

  protected void setBrowserLogging(Level logLevel) {
    LoggingPreferences loggingprefs = new LoggingPreferences();
    loggingprefs.enable(LogType.BROWSER, logLevel);
    caps.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
  }

  protected void setTimeputs(WebDriver webDriver) {
    webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }

//  protected void setListeners(MainWebDriver webDriver) {
//    webDriver.register(new PageObjectLogging());
//  }

  /**
   * Add browser extensions
   * 
   * @param extensionName
   */
//  public abstract void addExtension(String extensionName);

//  protected void setExtensions() {
//    for (String name : Configuration.getExtensions()) {
//      addExtension(name);
//    }
//  }

}
