package com.fujitsu.webframework.common.drivers.browsers;

//import com.fujitsu.webframework.common.ExtHelper;
import com.fujitsu.webframework.common.drivers.MainWebDriver;
import com.fujitsu.webframework.common.configuration.Configuration;
import com.fujitsu.webframework.common.drivers.BrowserAbstract;
import com.fujitsu.webframework.common.driverprovider.UserAgentsRegistry;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ChromeBrowser extends BrowserAbstract {

  private static final String CHROMEDRIVER_PATH_FORMAT = "build/resources/test/ChromeDriver/chromedriver_%s";
  private static final String CHROMEDRIVER_PATH_MAC =
      String.format(CHROMEDRIVER_PATH_FORMAT, "mac64/chromedriver");
  private static final String CHROMEDRIVER_PATH_LINUX =
      String.format(CHROMEDRIVER_PATH_FORMAT, "linux64/chromedriver");
  private static final String CHROMEDRIVER_PATH_WINDOWS =
      String.format(CHROMEDRIVER_PATH_FORMAT, "win32/chromedriver.exe");
  private ChromeOptions chromeOptions = new ChromeOptions();
  private boolean useMobile = "CHROMEMOBILEMERCURY".equals(Configuration.getBrowser());

  @Override
  public void setOptions() {
    String chromeBinaryPath = "";
    String osName = System.getProperty("os.name").toUpperCase();
    String emulator = Configuration.getEmulator();

    if (osName.contains("WINDOWS")) {
      chromeBinaryPath = CHROMEDRIVER_PATH_WINDOWS;
    } else if (osName.contains("MAC")) {
      chromeBinaryPath = CHROMEDRIVER_PATH_MAC;
    } else if (osName.contains("LINUX")) {
      chromeBinaryPath = CHROMEDRIVER_PATH_LINUX;
    }

    System.out.println(chromeBinaryPath);
    //File chromedriver = new File(ClassLoader.getSystemResource(chromeBinaryPath).getPath());
    File chromedriver = new File(chromeBinaryPath);

    // set application user permissions to 455
    chromedriver.setExecutable(true);

    System.setProperty("webdriver.chrome.driver", chromedriver.getPath());

    chromeOptions.addArguments("start-maximized");
    chromeOptions.addArguments("disable-notifications");
    chromeOptions.addArguments("process-per-site");
    chromeOptions.addArguments("dns-prefetch-disable");

    if ("true".equals(Configuration.getDisableFlash())) {
      chromeOptions.addArguments("disable-bundled-ppapi-flash");
    }

    if (useMobile) {
      chromeOptions.addArguments("--user-agent=" + UserAgentsRegistry.IPHONE.getUserAgent());
    }

    if (!"null".equals(emulator)) {
      Map<String, String> mobileEmulation = new HashMap<>();
      mobileEmulation.put("deviceName", emulator);
      chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
    }
  }

  @Override
  public MainWebDriver create() {
    caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

    return new MainWebDriver(new ChromeDriver(caps), useMobile);
  }

//  @Override
//  public void addExtension(String extensionName) {
//    chromeOptions.addExtensions(ExtHelper.findExtension(extensionName, "crx"));
//  }
}
