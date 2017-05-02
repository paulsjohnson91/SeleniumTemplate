package com.fujitsu.webframework.common.templates;

//import com.wikia.webdriver.common.contentpatterns.URLsContent;
import com.fujitsu.webframework.common.url.UrlBuilder;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class NewTestTemplate extends CoreTestTemplate {

  protected UrlBuilder urlBuilder;
  protected String websiteURL;
//  protected String wikiCorporateURL;
//  protected String wikiCorpSetupURL;

  @BeforeMethod(alwaysRun = true)
  public void start(Method method, Object[] data) {
  }

  protected void loadFirstPage(){
    driver.get(websiteURL);

  }

  protected void prepareURLs() {
    urlBuilder = new UrlBuilder();
    websiteURL = urlBuilder.getUrlForWebsite();
//    wikiCorporateURL = urlBuilder.getUrlForWiki("wikia");
//    wikiCorpSetupURL = urlBuilder.getUrlForWiki("corp");
  }
}
