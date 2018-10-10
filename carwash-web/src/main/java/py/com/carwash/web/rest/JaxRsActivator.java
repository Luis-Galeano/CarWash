/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.web.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Luis Galeano
 */
@javax.ws.rs.ApplicationPath("api")
public class JaxRsActivator extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources) {
         resources.add(py.com.carwash.web.rest.ServiciosResource.class);
    }  
}
