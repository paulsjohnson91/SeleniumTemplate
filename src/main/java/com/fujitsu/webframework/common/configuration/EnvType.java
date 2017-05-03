package com.fujitsu.webframework.common.configuration;

import lombok.Getter;

public enum EnvType {
  PROD("automationpractice.com", "prod"), STAGING("website-staging.com", "staging"), DEV("website-dev.com",
      "dev"), SANDBOX("website.com", "sandbox");

  @Getter
  private final String websiteDomain;

  @Getter
  private final String key;

  EnvType(String websiteDomain, String key) {
    this.websiteDomain = websiteDomain;
    this.key = key;
  }
}
