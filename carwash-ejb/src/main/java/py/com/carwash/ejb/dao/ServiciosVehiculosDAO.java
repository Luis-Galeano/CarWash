package py.com.carwash.ejb.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.mybatis.cdi.Mapper;
import py.com.carwash.ejb.mapper.ServiciosVehiculosMapper;
import py.com.carwash.ejb.model.ServiciosVehiculos;
import py.com.carwash.ejb.model.ServiciosVehiculosExample;

@RequestScoped
public class ServiciosVehiculosDAO extends GenericDAO<ServiciosVehiculos, Integer, ServiciosVehiculosExample, ServiciosVehiculosMapper> {
    @Inject
    @Mapper
    private ServiciosVehiculosMapper mapper;

    @Override
    public ServiciosVehiculosMapper getMapper() {
        return mapper;
    }
}