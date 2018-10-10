package py.com.carwash.ejb.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;
import py.com.carwash.ejb.model.ServiciosVehiculos;
import py.com.carwash.ejb.model.ServiciosVehiculosExample;

public interface ServiciosVehiculosMapper {
    @SelectProvider(type=ServiciosVehiculosSqlProvider.class, method="countByExample")
    long countByExample(ServiciosVehiculosExample example);

    @DeleteProvider(type=ServiciosVehiculosSqlProvider.class, method="deleteByExample")
    int deleteByExample(ServiciosVehiculosExample example);

    @Delete({
        "delete from servicios_vehiculos",
        "where id_servicio_vehiculo = #{idServicioVehiculo,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer idServicioVehiculo);

    @Insert({
        "insert into servicios_vehiculos (id_servicio, id_vehiculo, ",
        "precio)",
        "values (#{idServicio,jdbcType=BIGINT}, #{idVehiculo,jdbcType=BIGINT}, ",
        "#{precio,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="idServicioVehiculo")
    int insert(ServiciosVehiculos record);

    @InsertProvider(type=ServiciosVehiculosSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="idServicioVehiculo")
    int insertSelective(ServiciosVehiculos record);

    @SelectProvider(type=ServiciosVehiculosSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id_servicio_vehiculo", property="idServicioVehiculo", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_servicio", property="idServicio", jdbcType=JdbcType.BIGINT),
        @Result(column="id_vehiculo", property="idVehiculo", jdbcType=JdbcType.BIGINT),
        @Result(column="precio", property="precio", jdbcType=JdbcType.INTEGER)
    })
    List<ServiciosVehiculos> selectByExampleWithRowbounds(ServiciosVehiculosExample example, RowBounds rowBounds);

    @SelectProvider(type=ServiciosVehiculosSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id_servicio_vehiculo", property="idServicioVehiculo", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_servicio", property="idServicio", jdbcType=JdbcType.BIGINT),
        @Result(column="id_vehiculo", property="idVehiculo", jdbcType=JdbcType.BIGINT),
        @Result(column="precio", property="precio", jdbcType=JdbcType.INTEGER)
    })
    List<ServiciosVehiculos> selectByExample(ServiciosVehiculosExample example);

    @Select({
        "select",
        "id_servicio_vehiculo, id_servicio, id_vehiculo, precio",
        "from servicios_vehiculos",
        "where id_servicio_vehiculo = #{idServicioVehiculo,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id_servicio_vehiculo", property="idServicioVehiculo", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_servicio", property="idServicio", jdbcType=JdbcType.BIGINT),
        @Result(column="id_vehiculo", property="idVehiculo", jdbcType=JdbcType.BIGINT),
        @Result(column="precio", property="precio", jdbcType=JdbcType.INTEGER)
    })
    ServiciosVehiculos selectByPrimaryKey(Integer idServicioVehiculo);

    @UpdateProvider(type=ServiciosVehiculosSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ServiciosVehiculos record, @Param("example") ServiciosVehiculosExample example);

    @UpdateProvider(type=ServiciosVehiculosSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ServiciosVehiculos record, @Param("example") ServiciosVehiculosExample example);

    @UpdateProvider(type=ServiciosVehiculosSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ServiciosVehiculos record);

    @Update({
        "update servicios_vehiculos",
        "set id_servicio = #{idServicio,jdbcType=BIGINT},",
          "id_vehiculo = #{idVehiculo,jdbcType=BIGINT},",
          "precio = #{precio,jdbcType=INTEGER}",
        "where id_servicio_vehiculo = #{idServicioVehiculo,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ServiciosVehiculos record);
}