package com.fujitsu.webframework.common.core;

import com.fujitsu.webframework.common.configuration.Configuration;
import com.fujitsu.webframework.common.logging.PageObjectLogging;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandler {

  private AlertHandler() {
  }

  public static boolean isAlertPresent(WebDriver driver) {
    try {
      if ("GHOST".equals(Configuration.getBrowser())) {
        return false;
      }
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      PageObjectLogging.log("NO ALERT PRESENT", "", true);
      return false;
    }
  }

  public static void acceptPopupWindow(WebDriver driver) {
    driver.switchTo().alert().accept();
  }

  public static void acceptPopupWindow(WebDriver driver, int timeout) {
    new WebDriverWait(driver, timeout).until(new ExpectedCondition<Boolean>() {
      //@Override
      public Boolean apply(WebDriver webDriver) {
        if (isAlertPresent(webDriver)) {
          webDriver.switchTo().alert().accept();
          return true;
        } else {
          return false;
        }
      }
    });
  }

  public static void dismissPopupWindow(WebDriver driver) {
    driver.switchTo().alert().dismiss();
  }
}
