package com.fujitsu.webframework.common.drivers.browsers;

import com.fujitsu.webframework.common.drivers.MainWebDriver;
import com.fujitsu.webframework.common.configuration.Configuration;
import com.fujitsu.webframework.common.drivers.BrowserAbstract;
//import com.fujitsu.webframework.common.logging.PageObjectLogging;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidBrowser extends BrowserAbstract {

  private static AndroidDriver mobileDriver;

  public static AndroidDriver getMobileDriver() {
    return mobileDriver;
  }

  @Override
  public void setOptions() {
    DesiredCapabilities destCaps = new DesiredCapabilities();
    destCaps.setCapability("deviceName", Configuration.getDeviceName());
    URL url = null;
    try {
      url = new URL("http://" + Configuration.getAppiumIp() + "/wd/hub");
    } catch (MalformedURLException e) {
      e.printStackTrace();
      //TODO!!
      //PageObjectLogging.log("getAndroindInstance", e, false);
    }
    mobileDriver = new AndroidDriver(url, destCaps);

  }

  @Override
  public MainWebDriver create() {
    return new MainWebDriver(mobileDriver, true);
  }

//  @Override
//  public void addExtension(String extensionName) {
//    // No extensions are applied to android
//  }
}
