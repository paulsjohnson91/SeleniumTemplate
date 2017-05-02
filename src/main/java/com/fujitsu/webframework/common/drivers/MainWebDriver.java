package com.fujitsu.webframework.common.drivers;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class MainWebDriver extends EventFiringWebDriver {

  private WebDriver webDriver;
  private boolean isMobile;

  public MainWebDriver(WebDriver webdriver, boolean isMobile) {
    super(webdriver);

    this.webDriver = webdriver;
    this.isMobile = isMobile;
  }


  public boolean isChrome() {
    return webDriver instanceof ChromeDriver && !isMobile;
  }

  public boolean isChromeMobile() {
    return webDriver instanceof ChromeDriver && isMobile;
  }

  public boolean htmlUnit() {
    return webDriver instanceof HtmlUnitDriver;
  }

  public boolean isAndroid() {
    return webDriver instanceof AndroidDriver;
  }

  public boolean isFirefox() {
    return webDriver instanceof FirefoxDriver;
  }

  @Override
  public void quit() {
    super.quit();
  }
}
