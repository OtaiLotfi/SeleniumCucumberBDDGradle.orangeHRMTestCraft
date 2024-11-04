package it.otai.e2e.configurations;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "otai-ui-e2e")
@Slf4j
public class OtaiE2EProperties {
  private Boolean debug;
  private String orangeHRMUrl;
  private String phoneNumber;
  private String emailAddress;
  private String gitHubUrl;
  private String linkedinUrl;

  private E2EUsersProperties users;

  public boolean isDebug() {
    return getDebug() == Boolean.TRUE;
  }
}