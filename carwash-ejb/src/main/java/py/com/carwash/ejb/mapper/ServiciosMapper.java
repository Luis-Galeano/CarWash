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
import py.com.carwash.ejb.model.Servicios;
import py.com.carwash.ejb.model.ServiciosExample;

public interface ServiciosMapper {
    @SelectProvider(type=ServiciosSqlProvider.class, method="countByExample")
    long countByExample(ServiciosExample example);

    @DeleteProvider(type=ServiciosSqlProvider.class, method="deleteByExample")
    int deleteByExample(ServiciosExample example);

    @Delete({
        "delete from servicios",
        "where id_servicio = #{idServicio,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer idServicio);

    @Insert({
        "insert into servicios (nombre, descripcion)",
        "values (#{nombre,jdbcType=VARCHAR}, #{descripcion,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="idServicio")
    int insert(Servicios record);

    @InsertProvider(type=ServiciosSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="idServicio")
    int insertSelective(Servicios record);

    @SelectProvider(type=ServiciosSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id_servicio", property="idServicio", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nombre", property="nombre", jdbcType=JdbcType.VARCHAR),
        @Result(column="descripcion", property="descripcion", jdbcType=JdbcType.VARCHAR)
    })
    List<Servicios> selectByExampleWithRowbounds(ServiciosExample example, RowBounds rowBounds);

    @SelectProvider(type=ServiciosSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id_servicio", property="idServicio", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nombre", property="nombre", jdbcType=JdbcType.VARCHAR),
        @Result(column="descripcion", property="descripcion", jdbcType=JdbcType.VARCHAR)
    })
    List<Servicios> selectByExample(ServiciosExample example);

    @Select({
        "select",
        "id_servicio, nombre, descripcion",
        "from servicios",
        "where id_servicio = #{idServicio,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id_servicio", property="idServicio", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nombre", property="nombre", jdbcType=JdbcType.VARCHAR),
        @Result(column="descripcion", property="descripcion", jdbcType=JdbcType.VARCHAR)
    })
    Servicios selectByPrimaryKey(Integer idServicio);

    @UpdateProvider(type=ServiciosSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Servicios record, @Param("example") ServiciosExample example);

    @UpdateProvider(type=ServiciosSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Servicios record, @Param("example") ServiciosExample example);

    @UpdateProvider(type=ServiciosSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Servicios record);

    @Update({
        "update servicios",
        "set nombre = #{nombre,jdbcType=VARCHAR},",
          "descripcion = #{descripcion,jdbcType=VARCHAR}",
        "where id_servicio = #{idServicio,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Servicios record);
}