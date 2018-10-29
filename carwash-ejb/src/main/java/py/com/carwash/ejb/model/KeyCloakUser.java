/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.ejb.model;


/**
 *
 * @author Luis Galeano
 */
public class KeyCloakUser {
    
    private String id;
    private String username;
    private boolean enabled;
    private String email;
    private String firstName;
    private String lastName;
    private String[] requiredActions;
    private Credential[] credentials;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String[] getRequiredActions() {
        return requiredActions;
    }

    public void setRequiredActions(String[] requiredActions) {
        this.requiredActions = requiredActions;
    }

    public Credential[] getCredentials() {
        return credentials;
    }

    public void setCredentials(Credential[] credentials) {
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "KeyCloakUser{" + "id=" + id + ", username=" + username + ", enabled=" + enabled + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", requiredActions=" + requiredActions + ", credentials=" + credentials + '}';
    } 
}
