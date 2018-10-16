/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.ejb;

/**
 *
 * @author Luis Galeano
 */
public class Constantes {

    public static final String MENSAJE_EXITO = "OK";
    public static final Long ESTADO_EXITO = 0l;
    public static final Long ESTADO_ERROR = -1l;
    public static final String MENSAJE_ERROR = "Ha ocurrido un error, intentelo nuevamente";
    
    public static final String KEYCLOAK_REALM = "keyclaok_realm_sigo";
    public static final String KEYCLOAK_ADMIN_URL = "keyclaok_admin_url";
    public static final String KEYCLOAK_TOKEN_URL = "keycloak_token_url";
    public static final String KEYCLOAK_TOKEN_BODY = "keycloak_token_body";
    public static final String KEYCLOAK_URL_LOGOUT = "keycloak_url_logout";
    
    public static final String USER_ID= "sub";
    public static final String USER_NAME= "preferred_username";
    public static final String EMAIL= "email";
    public static final String CLIENTE= "aud";
    
    public static final String  ERROR_EMAIL= "El correo electronico no se encuetra registrado en el sistema";
    public static final String  ERROR_POLICY_PASS= "La contraseña debe contener mínimo 6 caracteres alternando mayúsculas, minúsculas, números y caracteres especiales";
    public static final String  ERROR_PASS= "La contraseña actual no coincide";
    public static final String  ERROR_USUARIO= "No existe el usuario";
    public static final String  EXITO_EMAIL= "Se ha enviado un correo electronico para restablecer su contraseña";
    
    public static final String CI_YA_REGISTRADO_EN_KEYCLOAK= "El usuario ya existe";
    public static final String PASS= "email-password";
    public static final String FROM_ADDRESS= "from-email";
    public static final String TO_ADDRESS= "to-email";
    
    public static final String MAX_RESERVA_MANHANA= "max-reserva-manhana";
    public static final String MAX_RESERVA_TARDE= "max-reserva-tarde";
}
