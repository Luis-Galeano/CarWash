package py.com.carwash.ejb.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.mybatis.cdi.Mapper;
import py.com.carwash.ejb.mapper.ReservasDetallesMapper;
import py.com.carwash.ejb.model.ReservasDetalles;
import py.com.carwash.ejb.model.ReservasDetallesExample;

@RequestScoped
public class ReservasDetallesDAO extends GenericDAO<ReservasDetalles, Integer, ReservasDetallesExample, ReservasDetallesMapper> {
    @Inject
    @Mapper
    private ReservasDetallesMapper mapper;

    @Override
    public ReservasDetallesMapper getMapper() {
        return mapper;
    }
}