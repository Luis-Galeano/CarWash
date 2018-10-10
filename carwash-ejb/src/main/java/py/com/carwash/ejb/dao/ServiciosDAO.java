package py.com.carwash.ejb.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.mybatis.cdi.Mapper;
import py.com.carwash.ejb.mapper.ServiciosMapper;
import py.com.carwash.ejb.model.Servicios;
import py.com.carwash.ejb.model.ServiciosExample;

@RequestScoped
public class ServiciosDAO extends GenericDAO<Servicios, Integer, ServiciosExample, ServiciosMapper> {
    @Inject
    @Mapper
    private ServiciosMapper mapper;

    @Override
    public ServiciosMapper getMapper() {
        return mapper;
    }
}