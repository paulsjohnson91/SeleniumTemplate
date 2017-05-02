package com.fujitsu.webframework.common.core.helper;

import com.fujitsu.webframework.common.properties.Credentials;
import com.fujitsu.webframework.common.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

import java.io.File;

public enum User {
  //USER("users.user1.username", "users.user1.password", "ci.user.regular.user_id", "ci.user.regular.access_token");
  ANONYMOUS("anonymous", "anonymous"),
  USER("users.user1.username", "users.user1.password");

  private final String userName;

  private final String password;
  private final String filePath = Configuration.getCredentialsFilePath();
  private String userId;
  private String accessToken;

  User(String userNameKey, String passwordKey) {
    this.userName = getValue(new File(filePath), userNameKey);
    this.password = getValue(new File(filePath), passwordKey);
    this.userId = "";
    this.accessToken = "";
  }
//
//  User(String userNameKey, String passwordKey, String userId) {
//    this.userName = XMLReader.getValue(new File(filePath), userNameKey);
//    this.password = XMLReader.getValue(new File(filePath), passwordKey);
//    this.userId = XMLReader.getValue(new File(filePath), userId);
//    this.accessToken = "";
//  }
//
//  User(String userNameKey, String passwordKey, String userId, String accessToken) {
//    this.userName = XMLReader.getValue(new File(filePath), userNameKey);
//    this.password = XMLReader.getValue(new File(filePath), passwordKey);
//    this.userId = XMLReader.getValue(new File(filePath), userId);
//    this.accessToken = XMLReader.getValue(new File(filePath), accessToken);
//  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public String getUserId() {
    return userId;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public static String getValue(File file, String key) {

    try {
      XMLConfiguration xml = new XMLConfiguration(file);
      return xml.getString(key);
    } catch (ConfigurationException e) {
      //TODO!!
      //PageObjectLogging.log("Error while reading XML config", e, false);
      e.printStackTrace();
      return e.getMessage();
    }
  }

//  public static String getValue(String key) {
//    return getValue(defaultConfigFile, key);
//  }
}