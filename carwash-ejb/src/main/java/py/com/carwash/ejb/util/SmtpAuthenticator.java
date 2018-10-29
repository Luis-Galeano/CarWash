/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.ejb.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author Luis Galeano
 */
public class SmtpAuthenticator  extends Authenticator{
    public SmtpAuthenticator() {
        super();
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
     String username = "luis.galeano@konecta.com.py";
     String password = "Tim3towork";
        if ((username != null) && (username.length() > 0) && (password != null) 
          && (password.length   () > 0)) {

            return new PasswordAuthentication(username, password);
        }

        return null;
    }

}
