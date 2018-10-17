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
import py.com.carwash.ejb.model.ReservasDetalles;
import py.com.carwash.ejb.model.ReservasDetallesExample;

public interface ReservasDetallesMapper {
    @SelectProvider(type=ReservasDetallesSqlProvider.class, method="countByExample")
    long countByExample(ReservasDetallesExample example);

    @DeleteProvider(type=ReservasDetallesSqlProvider.class, method="deleteByExample")
    int deleteByExample(ReservasDetallesExample example);

    @Delete({
        "delete from reservas_detalles",
        "where id_reserva_detalle = #{idReservaDetalle,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer idReservaDetalle);

    @Insert({
        "insert into reservas_detalles (id_servicio_vehiculo, cantidad, ",
        "preccio, id_reserva)",
        "values (#{idServicioVehiculo,jdbcType=BIGINT}, #{cantidad,jdbcType=INTEGER}, ",
        "#{preccio,jdbcType=INTEGER}, #{idReserva,jdbcType=BIGINT})"
    })
    @Options(useGeneratedKeys=true,keyProperty="idReservaDetalle")
    int insert(ReservasDetalles record);

    @InsertProvider(type=ReservasDetallesSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="idReservaDetalle")
    int insertSelective(ReservasDetalles record);

    @SelectProvider(type=ReservasDetallesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id_reserva_detalle", property="idReservaDetalle", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_servicio_vehiculo", property="idServicioVehiculo", jdbcType=JdbcType.BIGINT),
        @Result(column="cantidad", property="cantidad", jdbcType=JdbcType.INTEGER),
        @Result(column="preccio", property="preccio", jdbcType=JdbcType.INTEGER),
        @Result(column="id_reserva", property="idReserva", jdbcType=JdbcType.BIGINT)
    })
    List<ReservasDetalles> selectByExampleWithRowbounds(ReservasDetallesExample example, RowBounds rowBounds);

    @SelectProvider(type=ReservasDetallesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id_reserva_detalle", property="idReservaDetalle", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_servicio_vehiculo", property="idServicioVehiculo", jdbcType=JdbcType.BIGINT),
        @Result(column="cantidad", property="cantidad", jdbcType=JdbcType.INTEGER),
        @Result(column="preccio", property="preccio", jdbcType=JdbcType.INTEGER),
        @Result(column="id_reserva", property="idReserva", jdbcType=JdbcType.BIGINT)
    })
    List<ReservasDetalles> selectByExample(ReservasDetallesExample example);

    @Select({
        "select",
        "id_reserva_detalle, id_servicio_vehiculo, cantidad, preccio, id_reserva",
        "from reservas_detalles",
        "where id_reserva_detalle = #{idReservaDetalle,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id_reserva_detalle", property="idReservaDetalle", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_servicio_vehiculo", property="idServicioVehiculo", jdbcType=JdbcType.BIGINT),
        @Result(column="cantidad", property="cantidad", jdbcType=JdbcType.INTEGER),
        @Result(column="preccio", property="preccio", jdbcType=JdbcType.INTEGER),
        @Result(column="id_reserva", property="idReserva", jdbcType=JdbcType.BIGINT)
    })
    ReservasDetalles selectByPrimaryKey(Integer idReservaDetalle);

    @UpdateProvider(type=ReservasDetallesSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ReservasDetalles record, @Param("example") ReservasDetallesExample example);

    @UpdateProvider(type=ReservasDetallesSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ReservasDetalles record, @Param("example") ReservasDetallesExample example);

    @UpdateProvider(type=ReservasDetallesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ReservasDetalles record);

    @Update({
        "update reservas_detalles",
        "set id_servicio_vehiculo = #{idServicioVehiculo,jdbcType=BIGINT},",
          "cantidad = #{cantidad,jdbcType=INTEGER},",
          "preccio = #{preccio,jdbcType=INTEGER},",
          "id_reserva = #{idReserva,jdbcType=BIGINT}",
        "where id_reserva_detalle = #{idReservaDetalle,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ReservasDetalles record);
}