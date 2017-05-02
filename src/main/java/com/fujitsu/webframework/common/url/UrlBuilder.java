package com.fujitsu.webframework.common.url;

import com.fujitsu.webframework.common.configuration.Configuration;
import com.fujitsu.webframework.common.configuration.EnvType;

import org.apache.commons.lang.StringUtils;

public class UrlBuilder {

  private static final String PROD_URL_FORMAT = "http://%s%s.%s";
  private static final String SANDBOX_URL_FORMAT = "http://%s.%s%s.%s";
  private static final String DEV_URL_FORMAT = "http://%s%s.%s.%s";
  private static final String PROD_URL_FORMAT_NOPRE = "http://%s.%s";
  private static final String SANDBOX_URL_FORMAT_NOPRE = "http://%s.%s.%s";
  private static final String DEV_URL_FORMAT_NOPRE = "http://%s.%s.%s";

  private String env;

  public UrlBuilder() {
    this.env = Configuration.getEnv();
  }

  public UrlBuilder(String env) {
    this.env = env;
  }

  public String normalizePageName(String pageName) {
    return pageName.replace(" ", "_");
  }

  public String getUrlForPageWithWWW(String pageName) {
    return getUrlForWebsite(true) + pageName;
  }

  public String getUrlForPage(String pageName) {
    return getUrlForWebsite() + pageName;
  }

  public String getUrlForPage(String wikiName, String pageName) {
    return getUrlForWebsite(wikiName) + pageName;
  }

//  public String getUrlForPage(Page page) {
//    if (page.getWikiPath() == null) {
//      return getUrlForWebsite(page.getWikiName(), false);
//    }
//    return getUrlForPath(page.getWikiName(), page.getWikiPath());
//  }

  public String getUrlForPath(String wikiName, String wikiPath) {
    String url = "";
    if (!wikiPath.startsWith("/")) {
      url = String.format("%s/%s", getUrlForWebsite(wikiName), wikiPath);
    } else {
      url = String.format("%s%s", getUrlForWebsite(wikiName), wikiPath);
    }

    String qs = Configuration.getQS();
    if (StringUtils.isNotBlank(qs)) {
      url = appendQueryStringToURL(url, qs);
    }

    return url;
  }

  public String getUrlForPath(String wikiPath) {
    return getUrlForPath(Configuration.getWebsiteName(), wikiPath);
  }

  public String getUrlForWebsite() {
    return getUrlForWebsite(Configuration.getWebsiteName(), true, false);
  }

  public String getUrlForWebsite(String wikiName) {
    return getUrlForWebsite(wikiName, false);
  }

  public String getUrlForWebsite(boolean addWWW) {
    return getUrlForWebsite(Configuration.getWebsiteName(), addWWW);
  }

  public String getUrlForWebsite(String wikiName, boolean addWWW){
    return getUrlForWebsite(wikiName,addWWW,false);
  }

  public String getUrlForWebsite(String wikiName, boolean addWWW, boolean addWikiName) {
    EnvType envType = Configuration.getEnvType(this.env);
    final String wikiaName = getWikiaGlobalName(wikiName);

    String www = "";
    if (addWWW) {
      www = "www";
    }
    if(addWikiName) {
      switch (envType) {
        case DEV: {
          String devBoxOwner = this.env.split("-")[1];
          return String.format(DEV_URL_FORMAT, www, wikiaName, devBoxOwner, envType.getWebsiteDomain());
        }
        case PROD: {
          return String.format(PROD_URL_FORMAT, www, wikiaName, envType.getWebsiteDomain());
        }
        case STAGING: {
          return String.format(PROD_URL_FORMAT, www, wikiaName, envType.getWebsiteDomain());
        }
        case SANDBOX: {
          return String.format(SANDBOX_URL_FORMAT, this.env, www, wikiaName, envType.getWebsiteDomain());
        }
        default:
          return "";
      }
    }
    else{
      wikiName = "";
      switch (envType) {
        case DEV: {
          String devBoxOwner = this.env.split("-")[1];
          return String.format(DEV_URL_FORMAT_NOPRE, www, devBoxOwner, envType.getWebsiteDomain());
        }
        case PROD: {
          return String.format(PROD_URL_FORMAT_NOPRE, www, envType.getWebsiteDomain());
        }
        case STAGING: {
          return String.format(PROD_URL_FORMAT_NOPRE, www, envType.getWebsiteDomain());
        }
        case SANDBOX: {
          return String.format(SANDBOX_URL_FORMAT_NOPRE, this.env, www, envType.getWebsiteDomain());
        }
        default:
          return "";
      }
    }
  }

  public String getWikiGlobalURL(){
    EnvType env = Configuration.getEnvType(this.env);

    switch (env) {
      case DEV: {
        String devBoxOwner = this.env.split("-")[1];
        return String.format("http://%s.www.%s", devBoxOwner, env.getWebsiteDomain());
      }
      case SANDBOX: {
        return String.format("http://%s.www.%s", this.env, env.getWebsiteDomain());
      }
      default:
        return String.format("http://www.%s", env.getWebsiteDomain());
    }
  }

  private String getWikiaGlobalName(String wikiName) {
    if (wikiName.endsWith(".wikia")) {
      if (Configuration.getEnvType(this.env) == EnvType.DEV) {
        return "wikiaglobal";
      } else {
        return wikiName.replace(".wikia", "");
      }
    } else {
      return wikiName;
    }
  }

  public String appendQueryStringToURL(String url, String qs) {
    String separator = url.contains("?") ? "&" : "?";

    String[] filteredUrl = url.split("#");
    if (filteredUrl.length > 1) {
      return filteredUrl[0] + separator + qs + "#" + filteredUrl[1];
    } else {
      return url + separator + qs;
    }
  }
}
