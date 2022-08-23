package com.fluytcloud.auth.datasources.keycloak;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;

public class KeycloakConnection {

    private final RealmResource realmResource;

    public KeycloakConnection() {
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl("https://auth.fluytcloud.com")
                .realm("restaurante")
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .clientId("app-backend")
                .clientSecret("PmqhRiH6UVcsGp1P67OgO23PWRKasfJu")
                .build();
        realmResource = keycloak.realm("restaurante");
    }

    public RealmResource getRealmResource() {
        return realmResource;
    }

}
