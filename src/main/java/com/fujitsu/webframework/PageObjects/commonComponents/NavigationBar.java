package com.fujitsu.webframework.PageObjects.commonComponents;

import com.fujitsu.webframework.PageObjects.MainBasePageObject;
import com.fujitsu.webframework.PageObjects.authentication.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NavigationBar extends MainBasePageObject {


  @FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
  private WebElement signInLink;

  private By contactUs = By.id("contact-link");


  public NavigationBar(WebDriver driver) {
    super(By.id("contact-link"));
  }


  public LoginPage clickOnSignIn(){
      signInLink.click();
    return new LoginPage();
  }
}
