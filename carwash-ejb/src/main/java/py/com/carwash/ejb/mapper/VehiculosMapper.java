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
import py.com.carwash.ejb.model.Vehiculos;
import py.com.carwash.ejb.model.VehiculosExample;

public interface VehiculosMapper {
    @SelectProvider(type=VehiculosSqlProvider.class, method="countByExample")
    long countByExample(VehiculosExample example);

    @DeleteProvider(type=VehiculosSqlProvider.class, method="deleteByExample")
    int deleteByExample(VehiculosExample example);

    @Delete({
        "delete from vehiculos",
        "where id_vehiculo = #{idVehiculo,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer idVehiculo);

    @Insert({
        "insert into vehiculos (nombre)",
        "values (#{nombre,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="idVehiculo")
    int insert(Vehiculos record);

    @InsertProvider(type=VehiculosSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="idVehiculo")
    int insertSelective(Vehiculos record);

    @SelectProvider(type=VehiculosSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id_vehiculo", property="idVehiculo", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nombre", property="nombre", jdbcType=JdbcType.VARCHAR)
    })
    List<Vehiculos> selectByExampleWithRowbounds(VehiculosExample example, RowBounds rowBounds);

    @SelectProvider(type=VehiculosSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id_vehiculo", property="idVehiculo", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nombre", property="nombre", jdbcType=JdbcType.VARCHAR)
    })
    List<Vehiculos> selectByExample(VehiculosExample example);

    @Select({
        "select",
        "id_vehiculo, nombre",
        "from vehiculos",
        "where id_vehiculo = #{idVehiculo,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id_vehiculo", property="idVehiculo", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nombre", property="nombre", jdbcType=JdbcType.VARCHAR)
    })
    Vehiculos selectByPrimaryKey(Integer idVehiculo);

    @UpdateProvider(type=VehiculosSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Vehiculos record, @Param("example") VehiculosExample example);

    @UpdateProvider(type=VehiculosSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Vehiculos record, @Param("example") VehiculosExample example);

    @UpdateProvider(type=VehiculosSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Vehiculos record);

    @Update({
        "update vehiculos",
        "set nombre = #{nombre,jdbcType=VARCHAR}",
        "where id_vehiculo = #{idVehiculo,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Vehiculos record);
}