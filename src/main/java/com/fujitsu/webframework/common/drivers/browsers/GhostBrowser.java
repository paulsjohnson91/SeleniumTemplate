package com.fujitsu.webframework.common.drivers.browsers;

import com.fujitsu.webframework.common.drivers.MainWebDriver;
import com.fujitsu.webframework.common.drivers.BrowserAbstract;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;

import java.io.File;

public class GhostBrowser extends BrowserAbstract {

  @Override
  public void setOptions() {
    String phantomJSBinaryName;
    String osName = System.getProperty("os.name").toUpperCase();

    if (osName.contains("WINDOWS")) {
      phantomJSBinaryName = "phantomjs.exe";

      File phantomJSBinary =
          new File("." + File.separator + "src" + File.separator + "test" + File.separator
              + "resources" + File.separator + "PhantomJS" + File.separator + phantomJSBinaryName);

      caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
          phantomJSBinary.getAbsolutePath());
    }
  }

  @Override
  public MainWebDriver create() {
    return new MainWebDriver(new PhantomJSDriver(caps), false);
  }

//  @Override
//  public void addExtension(String extensionName) {
//    // No extensions are applied to PhantomJS browser
//  }
}
