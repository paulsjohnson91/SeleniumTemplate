package com.fujitsu.webframework.common.configuration;

import lombok.Getter;

public enum EnvType {
  PROD("automationpractice.com", "prod"), STAGING("wikia-staging.com", "staging"), DEV("wikia-dev.com",
      "dev"), SANDBOX("wikia.com", "sandbox");

  @Getter
  private final String websiteDomain;

  @Getter
  private final String key;

  EnvType(String websiteDomain, String key) {
    this.websiteDomain = websiteDomain;
    this.key = key;
  }
}
