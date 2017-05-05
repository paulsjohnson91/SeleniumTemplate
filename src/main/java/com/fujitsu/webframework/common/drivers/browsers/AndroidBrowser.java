package com.fujitsu.webframework.common.drivers.browsers;

import com.fujitsu.webframework.common.drivers.MainWebDriver;
import com.fujitsu.webframework.common.configuration.Configuration;
import com.fujitsu.webframework.common.drivers.BrowserAbstract;
import com.fujitsu.webframework.common.logging.PageObjectLogging;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
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
    DesiredCapabilities capabilities= DesiredCapabilities.android();
    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
    capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,Configuration.getDeviceName());
    capabilities.setCapability(MobileCapabilityType.VERSION,"5.0.1");
    URL url= null;
    try {
      url = new URL("http://" + Configuration.getAppiumIp() + "/wd/hub");
    } catch (MalformedURLException e) {
      PageObjectLogging.log("getAndroidInstance", e, false);
    }
    mobileDriver = new AndroidDriver(url, capabilities);
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
