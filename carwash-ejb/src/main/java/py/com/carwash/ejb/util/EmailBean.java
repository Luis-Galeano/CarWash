/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.ejb.util;

import java.util.Properties;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static py.com.carwash.ejb.Constantes.ESTADO_ERROR;
import static py.com.carwash.ejb.Constantes.ESTADO_EXITO;
import static py.com.carwash.ejb.Constantes.MENSAJE_ERROR;
import static py.com.carwash.ejb.Constantes.MENSAJE_EXITO;
import static py.com.carwash.ejb.Constantes.PASS;
import py.com.carwash.ejb.dao.QueryDAO;
import py.com.carwash.ejb.dto.GenericResponse;

/**
 *
 * @author Luis Galeano
 */
@Stateless
public class EmailBean {
    
     private  final Logger logger = LogManager.getLogger(this.getClass());
     @EJB
     QueryDAO queryDao;
     
     public  GenericResponse sendEmail(final String fromAddress, String to, String asunto, String mensaje){
        logger.info("IN : {}, {}, {}, {}",fromAddress,to,asunto,mensaje);
        GenericResponse resp = new GenericResponse();
        final String pass = queryDao.getConfigValue(PASS);
        Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromAddress,pass);
				}
			});
         try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAddress));
            Address toAddress = new InternetAddress(to);
            message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setContent(mensaje, "text/html");
            message.setSubject(asunto);

            Transport.send(message);
            
            resp.setEstado(ESTADO_EXITO);
            resp.setMensaje(MENSAJE_EXITO);
         } catch (MessagingException e) {
             logger.info("",e);
             resp.setEstado(ESTADO_ERROR);
             resp.setMensaje(MENSAJE_ERROR);
         }
        
        logger.info("OUT: {}",resp);
        return resp;
     }
}
