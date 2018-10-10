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
import py.com.carwash.ejb.model.Reservas;
import py.com.carwash.ejb.model.ReservasExample;

public interface ReservasMapper {
    @SelectProvider(type=ReservasSqlProvider.class, method="countByExample")
    long countByExample(ReservasExample example);

    @DeleteProvider(type=ReservasSqlProvider.class, method="deleteByExample")
    int deleteByExample(ReservasExample example);

    @Delete({
        "delete from reservas",
        "where id_reserva = #{idReserva,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer idReserva);

    @Insert({
        "insert into reservas (id_servicio_vehiculo, fecha_hora, ",
        "ubicacion, nombre_solicitante, ",
        "telefono_solicitante, email_solicitante, ",
        "estado_reserva)",
        "values (#{idServicioVehiculo,jdbcType=BIGINT}, #{fechaHora,jdbcType=TIMESTAMP}, ",
        "#{ubicacion,jdbcType=VARCHAR}, #{nombreSolicitante,jdbcType=VARCHAR}, ",
        "#{telefonoSolicitante,jdbcType=VARCHAR}, #{emailSolicitante,jdbcType=VARCHAR}, ",
        "#{estadoReserva,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="idReserva")
    int insert(Reservas record);

    @InsertProvider(type=ReservasSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="idReserva")
    int insertSelective(Reservas record);

    @SelectProvider(type=ReservasSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id_reserva", property="idReserva", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_servicio_vehiculo", property="idServicioVehiculo", jdbcType=JdbcType.BIGINT),
        @Result(column="fecha_hora", property="fechaHora", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ubicacion", property="ubicacion", jdbcType=JdbcType.VARCHAR),
        @Result(column="nombre_solicitante", property="nombreSolicitante", jdbcType=JdbcType.VARCHAR),
        @Result(column="telefono_solicitante", property="telefonoSolicitante", jdbcType=JdbcType.VARCHAR),
        @Result(column="email_solicitante", property="emailSolicitante", jdbcType=JdbcType.VARCHAR),
        @Result(column="estado_reserva", property="estadoReserva", jdbcType=JdbcType.INTEGER)
    })
    List<Reservas> selectByExampleWithRowbounds(ReservasExample example, RowBounds rowBounds);

    @SelectProvider(type=ReservasSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id_reserva", property="idReserva", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_servicio_vehiculo", property="idServicioVehiculo", jdbcType=JdbcType.BIGINT),
        @Result(column="fecha_hora", property="fechaHora", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ubicacion", property="ubicacion", jdbcType=JdbcType.VARCHAR),
        @Result(column="nombre_solicitante", property="nombreSolicitante", jdbcType=JdbcType.VARCHAR),
        @Result(column="telefono_solicitante", property="telefonoSolicitante", jdbcType=JdbcType.VARCHAR),
        @Result(column="email_solicitante", property="emailSolicitante", jdbcType=JdbcType.VARCHAR),
        @Result(column="estado_reserva", property="estadoReserva", jdbcType=JdbcType.INTEGER)
    })
    List<Reservas> selectByExample(ReservasExample example);

    @Select({
        "select",
        "id_reserva, id_servicio_vehiculo, fecha_hora, ubicacion, nombre_solicitante, ",
        "telefono_solicitante, email_solicitante, estado_reserva",
        "from reservas",
        "where id_reserva = #{idReserva,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id_reserva", property="idReserva", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_servicio_vehiculo", property="idServicioVehiculo", jdbcType=JdbcType.BIGINT),
        @Result(column="fecha_hora", property="fechaHora", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ubicacion", property="ubicacion", jdbcType=JdbcType.VARCHAR),
        @Result(column="nombre_solicitante", property="nombreSolicitante", jdbcType=JdbcType.VARCHAR),
        @Result(column="telefono_solicitante", property="telefonoSolicitante", jdbcType=JdbcType.VARCHAR),
        @Result(column="email_solicitante", property="emailSolicitante", jdbcType=JdbcType.VARCHAR),
        @Result(column="estado_reserva", property="estadoReserva", jdbcType=JdbcType.INTEGER)
    })
    Reservas selectByPrimaryKey(Integer idReserva);

    @UpdateProvider(type=ReservasSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Reservas record, @Param("example") ReservasExample example);

    @UpdateProvider(type=ReservasSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Reservas record, @Param("example") ReservasExample example);

    @UpdateProvider(type=ReservasSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Reservas record);

    @Update({
        "update reservas",
        "set id_servicio_vehiculo = #{idServicioVehiculo,jdbcType=BIGINT},",
          "fecha_hora = #{fechaHora,jdbcType=TIMESTAMP},",
          "ubicacion = #{ubicacion,jdbcType=VARCHAR},",
          "nombre_solicitante = #{nombreSolicitante,jdbcType=VARCHAR},",
          "telefono_solicitante = #{telefonoSolicitante,jdbcType=VARCHAR},",
          "email_solicitante = #{emailSolicitante,jdbcType=VARCHAR},",
          "estado_reserva = #{estadoReserva,jdbcType=INTEGER}",
        "where id_reserva = #{idReserva,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Reservas record);
}