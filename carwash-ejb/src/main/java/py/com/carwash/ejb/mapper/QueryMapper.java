/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.ejb.mapper;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;



/**
 *
 * @author Luis Galeano <luis.galeano@konecta.com.py>
 */
public interface QueryMapper {
    
    @SelectProvider(type=QuerySqlProvider.class, method="getConfigValue")
    public String getConfigValue(@Param("param") String param);
    
    
}
