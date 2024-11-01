package it.otai.e2e.configurations;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Data
@Configuration
@ConfigurationProperties(prefix = "ebay-ui-e2e.users.credentials")
public class E2EUsersProperties {
    @Autowired
    private Environment env;

    private String password;
    private String locale;
    //private String ebayUsername;
    //private String ebayPassword;

    public String getUsername(OtaiUserCredentials.OtaiUser ebayUser) {
        return env.getProperty(ebayUser.getPropertyKeyUsername());
    }

    public String getPassword(OtaiUserCredentials.OtaiPassword ebayPass) {
        return env.getProperty(ebayPass.getPropertyKeyPassword());
    }
}
