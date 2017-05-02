package com.fujitsu.webframework.PageObjects.authentication;

import com.fujitsu.webframework.PageObjects.MainBasePageObject;
//import com.wikia.webdriver.common.core.helpers.User;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MainBasePageObject {

  @FindBy(css = "#email")
  private WebElement signInAuthModal;


  //private final String mainWindowHandle;

  public LoginPage() {
    super();
    //waitForNewWindow();
    //this.mainWindowHandle = driver.getWindowHandle();
  }


//  private void switchToAuthModalHandle() {
//    for (String winHandle : driver.getWindowHandles()) {
//      driver.switchTo().window(winHandle);
//    }
//  }
//
//  private void switchToMainWindowHandle() {
//    driver.switchTo().window(this.mainWindowHandle);
//  }

//  public boolean isOpened() {
//    switchToAuthModalHandle();
//    try {
//      wait.forElementVisible(registerAuthModal);
//    } catch (TimeoutException e) {
//      PageObjectLogging.logInfo("Register Auth Modal is not displayed");
//      return false;
//    }
//    switchToMainWindowHandle();
//    return true;
//  }
//
//  public boolean isSignInOpened() {
//    switchToAuthModalHandle();
//    try {
//      wait.forElementVisible(signInAuthModal);
//    } catch (TimeoutException e) {
//      PageObjectLogging.logInfo("Sign In Auth Modal is not displayed");
//      return false;
//    }
//    switchToMainWindowHandle();
//    return true;
//  }

    public boolean isSignOnPageOpen(){
    try{
      wait.forElementVisible(signInAuthModal);
    }
    catch (TimeoutException e) {
      e.printStackTrace();
      //TODO!!
//      PageObjectLogging.logInfo("Sign In Auth Modal is not displayed");
//      return false;
    }
    return true;
    }
//
//  public boolean isConnetctWithFacebookButtonVisible() {
//    switchToAuthModalHandle();
//    boolean isConnetctWithFacebookButtonVisible = registerAuthModal.isDisplayed();
//    switchToMainWindowHandle();
//
//    return isConnetctWithFacebookButtonVisible;
//  }

  public void login(String username, String password) {
//    switchToAuthModalHandle();
//    usernameField.sendKeys(username);
//    passwordField.sendKeys(password);
//    signInButton.click();
//    switchToMainWindowHandle();
  }

//  public void login(User user) {
//    login(user.getUserName(), user.getPassword());
//  }

//  public void clickForgotPasswordLink() {
//    switchToAuthModalHandle();
//    forgottenPasswordLink.click();
//    switchToMainWindowHandle();
//  }
//
//  public void clickToSignInForm(){
//    switchToAuthModalHandle();
//    wait.forElementClickable(linkToSignInForm);
//    linkToSignInForm.click();
//  }

}
