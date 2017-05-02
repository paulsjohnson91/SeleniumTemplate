package com.fujitsu.webframework.common.drivers.browsers;

import com.fujitsu.webframework.common.drivers.MainWebDriver;
import com.fujitsu.webframework.common.drivers.BrowserAbstract;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitBrowser extends BrowserAbstract {

  @Override
  public void setOptions() {
    // Here you should put options to set before browser instance creation
  }

  @Override
  public MainWebDriver create() {
    return new MainWebDriver(new HtmlUnitDriver(), false);
  }

//  @Override
//  public void addExtension(String extensionName) {
//    // No extensions are applied to HtmlUnit browser
//  }
}
