package com.fujitsu.webframework.PageObjects.commonComponents;

//import com.wikia.webdriver.common.core.Assertion;
//import com.wikia.webdriver.common.core.interactions.Typing;
//import com.wikia.webdriver.common.logging.PageObjectLogging;
//import com.wikia.webdriver.elements.mercury.components.signup.RegisterArea;
//import com.wikia.webdriver.pageobjectsfactory.componentobject.AuthModal;
import com.fujitsu.webframework.PageObjects.MainBasePageObject;
//import com.wikia.webdriver.pageobjectsfactory.pageobject.article.ArticlePageObject;
//import com.wikia.webdriver.pageobjectsfactory.pageobject.search.intrawikisearch.IntraWikiSearchPageObject;
import com.fujitsu.webframework.PageObjects.authentication.LoginPage;
import com.fujitsu.webframework.common.logging.PageObjectLogging;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class NavigationBar extends MainBasePageObject {

  final private String suggestionCss = ".autocomplete div";

  @FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
  private WebElement signInLink;


//  @FindBy(css = suggestionCss)
//  private List<WebElement> suggestionsList;


  public NavigationBar(WebDriver driver) {
    super();
  }

//  public void typeQuery(String query) {
//    wait.forElementVisible(searchInput);
//    searchInput.clear();
//    searchInput.sendKeys(query);
//    PageObjectLogging.log("typeQuery", "typed query: " + query, true);
//  }
//
//  public IntraWikiSearchPageObject searchFor(String query) {
//    PageObjectLogging.log("searchFor", "searching for query: " + query, true, driver);
//    typeQuery(query);
//    return clickSearchButton();
//  }
//
//  public IntraWikiSearchPageObject clickSearchButton() {
//    wait.forElementClickable(searchSubmit);
//    searchSubmit.click();
//    PageObjectLogging.log("clickSearchButton", "clicked on search button", true);
//    return new IntraWikiSearchPageObject(driver);
//  }
//
//  /**
//   * Returns article page object if invoked by user with goSearch preference turned on
//   */
//  public ArticlePageObject goSearchFor(String query) {
//    searchInput.sendKeys(query);
//    searchSubmit.click();
//    PageObjectLogging.log("searchFor", "searching for query: " + query, true, driver);
//    return new ArticlePageObject();
//  }
//
//  public AuthModal clickOnSignIn(){
//    myAccount.click();
//    signInLink.click();
//    return new AuthModal();
//  }
//
//  public RegisterArea clickOnRegister(){
//    myAccount.click();
//    registerLink.click();
//    return new RegisterArea(true);
//  }

  public LoginPage clickOnSignIn(){
      signInLink.click();
    return new LoginPage();
  }
}
