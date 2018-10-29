/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.ejb;



import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import java.util.Base64;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;
import static py.com.carwash.ejb.Constantes.CLIENTE;
import static py.com.carwash.ejb.Constantes.EMAIL;
import static py.com.carwash.ejb.Constantes.USER_ID;
import static py.com.carwash.ejb.Constantes.USER_NAME;
import py.com.carwash.ejb.util.SSLUtilities;



/**
 *
 * @author Luis Galeano
 */
public class Util {
    
    private static final Logger logger = LogManager.getLogger(Util.class);
    
    public static String restPostCall(String urlMetodo, String json, String header){
        logger.info("IN: {}, {}",urlMetodo,json);
        Client client = null;
        String response = null;
        try {
            client = Client.create();
            WebResource webResource = client.resource(urlMetodo);
            if (header != null){
                ClientResponse postResponse = webResource.type("application/json")
                    .header("Authorization", header)
                    .post(ClientResponse.class,json);
                response = postResponse.getEntity(String.class);
            }
            else{
                ClientResponse postResponse = webResource.type("application/json")
                    .post(ClientResponse.class,json);
                response = postResponse.getEntity(String.class);
            }
            
        } catch (UniformInterfaceException | ClientHandlerException e) {
            logger.error("{}",e.getMessage());
        } finally {
            if (client != null) {
                try {
                    client.destroy();
                } catch (Exception e) {
                    logger.error(e.getMessage(),e);
                }
            }
        }
        logger.info("OUT: {}",response);
        return response;
    }
    
    public static String restGetCall(String urlMetodo, String json, String header){
        logger.info("IN: {}, {}",urlMetodo,json);
        Client client = null;
        String response = null;
        try {
            client = Client.create();
            WebResource webResource = client.resource(urlMetodo);
            
              ClientResponse  getResponse = webResource.type("application/json")
                    .header("Authorization", header)
                    .get(ClientResponse.class);

            response = getResponse.getEntity(String.class);
        } catch (Exception e) {
            logger.error("ERROR "+e.getMessage(),e);
        } finally {
            if (client != null) {
                try {
                    client.destroy();
                } catch (Exception e) {
                    logger.error(e.getMessage(),e);
                }
            }
        }
        logger.info("OUT: {}",response);
        return response;
    }
    
    
    
    public static String restPutCall(String urlMetodo, String json, String header){
        logger.info("IN: {}, {}",urlMetodo,json);
        Client client = null;
        String response = null;
        try {
            client = Client.create();
            WebResource webResource = client.resource(urlMetodo);
            ClientResponse getResponse = webResource.type("application/json")
                    .header("Authorization", header)
                    .put(ClientResponse.class,json);
            response = String.valueOf(getResponse.getStatus());
        } catch (Exception e) {
            logger.error("ERROR "+e.getMessage(),e);
        } finally {
            if (client != null) {
                try {
                    client.destroy();
                } catch (Exception e) {
                    logger.error(e.getMessage(),e);
                }
            }
        }
        logger.info("OUT: {}",response);
        return response;
    }
    
    public static String restDeleteCall(String urlMetodo, String json, String header){
        logger.info("IN: {}, {}",urlMetodo,json);
        Client client = null;
        String response = null;
        try {
            client = Client.create();
            WebResource webResource = client.resource(urlMetodo);
            ClientResponse getResponse = webResource.type("application/json")
                    .header("Authorization", header)
                    .delete(ClientResponse.class,json);
            response = String.valueOf(getResponse.getStatus());
        } catch (Exception e) {
            logger.error("ERROR "+e.getMessage(),e);
        } finally {
            if (client != null) {
                try {
                    client.destroy();
                } catch (Exception e) {
                    logger.error(e.getMessage(),e);
                }
            }
        }
        logger.info("OUT: {}",response);
        return response;
    }
    
    
    
    public static String getHeaderInfo(String key, String header){
        logger.info("IN: {}", key);
        String resp = null;
        String token = null;
        try {
            token = header.split("\\.")[1];
            byte[] tokenDecoded= Base64.getDecoder().decode(token);
            token = new String(tokenDecoded);
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
            Map<String, Object> map = mapper.readValue(token, Map.class);
            switch(key){
                case EMAIL:
                    resp = (String) map.get(EMAIL);
                    break;
                case USER_NAME:
                    resp = (String) map.get(USER_NAME);
                    break;
                case USER_ID:
                    resp = (String) map.get(USER_ID);
                    break;
                case CLIENTE:
                    resp = (String) map.get(CLIENTE);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            logger.error("",e);
        }
        logger.info("OUT: {}", resp);
        return resp;
    }
    public static int verifyPass(String urlMetodo, String form){
         logger.info("IN: {}, {}",urlMetodo,form);
         Client client = null;
         int status = 0;
         try {
             client = Client.create();
             WebResource webResource = client.resource(urlMetodo);
             ClientResponse postResponse = webResource.type(MediaType.APPLICATION_FORM_URLENCODED)
                     .post(ClientResponse.class,form);
            
             status = postResponse.getStatus();
          
         } catch (UniformInterfaceException | ClientHandlerException e) {
             logger.error(e.getMessage(),e);
         } finally {
             if (client != null) {
                 try {
                     client.destroy();
                 } catch (Exception e) {
                     logger.error(e.getMessage(),e);
                 }
             }
         }
         logger.info("OUT: {}",status);
         return status;
    }
    
    public static String getAdminToken(String urlMetodo, String form){
         logger.info("IN: {}, {}",urlMetodo,form);
         Client client = null;
         String response = null;
         try {
             SSLUtilities.trustAllHostnames();
             SSLUtilities.trustAllHttpsCertificates();
             client = Client.create();
             WebResource webResource = client.resource(urlMetodo);
             ClientResponse postResponse = webResource.type(MediaType.APPLICATION_FORM_URLENCODED)
                     .post(ClientResponse.class,form);

             response = postResponse.getEntity(String.class);
             JSONObject resp = new JSONObject(response);
             response = (String) resp.get("access_token");
             response = "Bearer ".concat(response);
         } catch (UniformInterfaceException | ClientHandlerException e) {
             logger.error(e.getMessage(),e);
         } finally {
             if (client != null) {
                 try {
                     client.destroy();
                 } catch (Exception e) {
                     logger.error(e.getMessage(),e);
                 }
             }
         }
         logger.info("OUT: {}",response);
         return response;
     }
    
}
