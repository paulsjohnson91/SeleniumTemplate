package com.fujitsu.webframework.common.properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

import java.io.File;

import com.fujitsu.webframework.common.configuration.Configuration;

import java.io.File;

public class Credentials {

  private static final File defaultConfigFile = new File(Configuration.getCredentialsFilePath());


  public final String userName;
  public final String password;


  public Credentials() {
    File file = new File(Configuration.getCredentialsFilePath());
    userName = getValue(file, "users.user1.username");
    password = getValue(file, "users.user1.password");

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

  public static String getValue(String key) {
    return getValue(defaultConfigFile, key);
  }
}
