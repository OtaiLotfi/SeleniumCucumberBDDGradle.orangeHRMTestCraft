package it.otai.e2e.configurations;

import io.cucumber.java.ParameterType;

public class OtaiUserCredentials {
    @SuppressWarnings("unused")
    public enum OtaiUser {
        ORANGEHRM,
        NO_ROLES;

        private static final String PROPERTY_PATTERN = "otai-ui-e2e.users.credentials.%s-username";

        public String getPropertyKeyUsername() {
            return String.format(PROPERTY_PATTERN, this.name().toLowerCase());
        }
    }

    @ParameterType(".*")
    public OtaiUser otaiUser(String name) {
        return OtaiUser.valueOf(name);
    }

    @SuppressWarnings("unused")
    public enum OtaiPassword {
        ORANGEHRM,
        NO_ROLES;

        private static final String PROPERTY_PATTERN = "otai-ui-e2e.users.credentials.%s-password";

        public String getPropertyKeyPassword() {
            return String.format(PROPERTY_PATTERN, this.name().toLowerCase());
        }
    }

    @ParameterType(".*")
    public OtaiPassword otaiPassword(String name) {
        return OtaiPassword.valueOf(name);
    }
}