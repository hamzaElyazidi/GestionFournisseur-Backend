package ma.emsi.evaluationFournisseur.services;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.keycloak.OAuth2Constants;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.stereotype.Service;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class KeycloakService {
    public String createUser(String username, String password , String firstName , String lastName , String email) {
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080")
                .realm("master") // Use the master realm to authenticate as the admin
                .clientId("admin-cli")
                .username("admin")
                .password("1234")
                .build();
        // Define user representation
        UserRepresentation user = new UserRepresentation();
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setEnabled(true);
        List<CredentialRepresentation> credentials = new ArrayList<>();
        CredentialRepresentation credential1 = new CredentialRepresentation();
        credential1.setType("password");
        credential1.setValue(password);
        credentials.add(credential1);
        user.setCredentials(credentials);
        keycloak.realm("supplier-realm").users().create(user);
        List<RoleRepresentation> roles = new ArrayList<>();
        RoleRepresentation role1 = new RoleRepresentation();
        role1.setName("USER");
        roles.add(role1);
        String userId = keycloak.realm("supplier-realm").users().search(username).get(0).getId();
     //   System.out.println("USER ID : "+userId);
        // Get the role representation for the role you want to assign
        RoleRepresentation role = keycloak.realm("supplier-realm").roles().get("USER").toRepresentation();
        // Add the role to the user
        keycloak.realm("supplier-realm").users().get(userId).roles().realmLevel().add(Arrays.asList(role));
    return userId ;
    }
}
