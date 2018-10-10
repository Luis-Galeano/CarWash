package py.com.carwash.ejb.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.mybatis.cdi.Mapper;
import py.com.carwash.ejb.mapper.ReservasMapper;
import py.com.carwash.ejb.model.Reservas;
import py.com.carwash.ejb.model.ReservasExample;

@RequestScoped
public class ReservasDAO extends GenericDAO<Reservas, Integer, ReservasExample, ReservasMapper> {
    @Inject
    @Mapper
    private ReservasMapper mapper;

    @Override
    public ReservasMapper getMapper() {
        return mapper;
    }
}