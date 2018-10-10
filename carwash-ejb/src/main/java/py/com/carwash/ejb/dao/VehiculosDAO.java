package py.com.carwash.ejb.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.mybatis.cdi.Mapper;
import py.com.carwash.ejb.mapper.VehiculosMapper;
import py.com.carwash.ejb.model.Vehiculos;
import py.com.carwash.ejb.model.VehiculosExample;

@RequestScoped
public class VehiculosDAO extends GenericDAO<Vehiculos, Integer, VehiculosExample, VehiculosMapper> {
    @Inject
    @Mapper
    private VehiculosMapper mapper;

    @Override
    public VehiculosMapper getMapper() {
        return mapper;
    }
}