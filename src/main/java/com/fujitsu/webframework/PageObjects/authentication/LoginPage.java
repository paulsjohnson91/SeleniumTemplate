package com.fujitsu.webframework.PageObjects.authentication;

import com.fujitsu.webframework.PageObjects.MainBasePageObject;
//import com.wikia.webdriver.common.core.helpers.User;
import com.fujitsu.webframework.common.logging.PageObjectLogging;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MainBasePageObject {

  @FindBy(css = "#email")
  private WebElement signInElement;

  public LoginPage() {
    super();
  }

    public boolean isSignOnPageOpen(){
    try{
      wait.forElementVisible(signInElement);
    }
    catch (TimeoutException e) {
      PageObjectLogging.logInfo("Sign In box is not displayed");
      return false;
    }
    return true;
    }

  public void login(String username, String password) {
  }


}
