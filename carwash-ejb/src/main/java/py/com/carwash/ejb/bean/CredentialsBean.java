/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.ejb.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import static py.com.carwash.ejb.Constantes.CLIENTE;
import static py.com.carwash.ejb.Constantes.ERROR_EMAIL;
import static py.com.carwash.ejb.Constantes.ERROR_PASS;
import static py.com.carwash.ejb.Constantes.ERROR_POLICY_PASS;
import static py.com.carwash.ejb.Constantes.ERROR_USUARIO;
import static py.com.carwash.ejb.Constantes.ESTADO_ERROR;
import static py.com.carwash.ejb.Constantes.EXITO_EMAIL;
import static py.com.carwash.ejb.Constantes.KEYCLOAK_ADMIN_URL;
import static py.com.carwash.ejb.Constantes.KEYCLOAK_REALM;
import static py.com.carwash.ejb.Constantes.KEYCLOAK_TOKEN_BODY;
import static py.com.carwash.ejb.Constantes.KEYCLOAK_TOKEN_URL;
import static py.com.carwash.ejb.Constantes.MENSAJE_ERROR;
import static py.com.carwash.ejb.Constantes.MENSAJE_EXITO;
import static py.com.carwash.ejb.Constantes.USER_ID;
import static py.com.carwash.ejb.Constantes.USER_NAME;
import py.com.carwash.ejb.Util;
import py.com.carwash.ejb.dao.QueryDAO;
import py.com.carwash.ejb.dto.GenericResponse;
import py.com.carwash.ejb.model.Credential;
import py.com.carwash.ejb.model.KeyCloakUser;

/**
 *
 * @author Luis Galeano
 */
@Stateless
public class CredentialsBean {
    private final Logger logger = LogManager.getLogger(this.getClass());
    
    @EJB
    private QueryDAO configFacade;
   
    
    public GenericResponse restoreCredentials(String email){
        logger.info("IN {}", email);
        GenericResponse resp = new GenericResponse();
        try {
                String realm = configFacade.getConfigValue(KEYCLOAK_REALM);
                String body= configFacade.getConfigValue(KEYCLOAK_TOKEN_BODY);
                String tokenUrl = configFacade.getConfigValue(KEYCLOAK_TOKEN_URL);
                tokenUrl = tokenUrl.replaceAll("<realm>", realm);
                String header = Util.getAdminToken(tokenUrl, body);
                
                String urlAllUsers = configFacade.getConfigValue(KEYCLOAK_ADMIN_URL);
                urlAllUsers = urlAllUsers.replaceAll("<realm>", realm);
                urlAllUsers = urlAllUsers.substring(0, urlAllUsers.length()-1);
                urlAllUsers = urlAllUsers.concat("?email=<email>");
                urlAllUsers = urlAllUsers.replaceAll("<email>", email);
                Type listType = new TypeToken<ArrayList<KeyCloakUser>>(){}.getType();
                String usersStringUpdate = Util.restGetCall(urlAllUsers,"{}", header); // lista de usuarios actualizados
                List<KeyCloakUser> usersKeyclaok =  new Gson().fromJson(usersStringUpdate,listType);
                String userId = null;
                for (KeyCloakUser user : usersKeyclaok){
                    if (user.getEmail() != null){
                        if (user.getEmail().equals(email) ){
                            userId = user.getId();
                            break;
                        }  
                    }      
                }
                if (userId == null){
                    logger.info("[Email no valido]");
                    resp.setEstado(ESTADO_ERROR);
                    resp.setMensaje(ERROR_EMAIL);
                    return resp;
                }

                String url = configFacade.getConfigValue(KEYCLOAK_ADMIN_URL);
                url = url.replaceAll("<realm>", realm);
                url = url.concat(userId).concat("/execute-actions-email");
                String status = Util.restPutCall(url, "[\"UPDATE_PASSWORD\"]", header);
                resp.setEstado(Long.valueOf(status));
                if (resp.getEstado() == 200){
                    resp.setMensaje(EXITO_EMAIL);
                }
                else{
                    resp.setMensaje(MENSAJE_ERROR);
                }
            
        } catch (Exception e) {
            resp.setEstado(ESTADO_ERROR);
            resp.setMensaje(MENSAJE_ERROR);
            logger.error("",e);
        }
        logger.info("OUT: {}", resp);
        return resp;
    }
    
    public GenericResponse updateCredentials (Credential credential,String actualPass, String header){
        logger.info("IN: {}, {}", credential, header);
        GenericResponse resp = new GenericResponse();
        try {
            // verificar password actual
            String bodyReq = "username=<user>&password=<pass>&client_id=<clientId>&grant_type=password";
            String userName = Util.getHeaderInfo(USER_NAME, header);
            String clientId = Util.getHeaderInfo(CLIENTE, header);
            String userId = Util.getHeaderInfo(USER_ID, header);
            bodyReq = bodyReq.replaceAll("<user>", userName);
            bodyReq = bodyReq.replaceAll("<pass>", actualPass);
            bodyReq = bodyReq.replaceAll("<clientId>", clientId);
           
            String tokenUrl = configFacade.getConfigValue(KEYCLOAK_TOKEN_URL);
            String realm = configFacade.getConfigValue(KEYCLOAK_REALM);
            
            tokenUrl = tokenUrl.replaceAll("<realm>", realm);
            int passStatus = Util.verifyPass(tokenUrl, bodyReq);
            if (Integer.compare(200, passStatus) == 0){
                String url = configFacade.getConfigValue(KEYCLOAK_ADMIN_URL);
                url = url.replaceAll("<realm>", realm);
                url = url.concat(userId).concat("/reset-password");
                String jsonString = new JSONObject(credential).toString();
                String status = Util.restPutCall(url, jsonString, header);
                if (status.equals("400")){ // no se pudo actualizar la contrasenha
                    resp.setEstado(ESTADO_ERROR);
                    resp.setMensaje(ERROR_POLICY_PASS);
                }
                else if(status.equals("403")){
                    resp.setEstado(ESTADO_ERROR);
                    resp.setMensaje(MENSAJE_ERROR);
                }
                else{
                    resp.setEstado(Long.valueOf(status));
                    resp.setMensaje(MENSAJE_EXITO);
                }    
            }
            else{
                resp.setEstado(ESTADO_ERROR);
                resp.setMensaje(ERROR_PASS);
            }
            
        } catch (Exception e) {
            resp.setEstado(ESTADO_ERROR);
            resp.setMensaje(ERROR_USUARIO);
            logger.error("",e);
        }
        logger.info("OUT: {}", resp);
        return resp;
    }
    
}
