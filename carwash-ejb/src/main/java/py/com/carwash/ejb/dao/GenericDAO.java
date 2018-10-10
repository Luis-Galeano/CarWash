package py.com.carwash.ejb.dao;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class GenericDAO<P, ID extends Serializable, E, M> {
    private final Class<P> pojoClass;

    private final Class<E> exampleClass;

    public GenericDAO() {
        Type genericSuperClass = getClass().getGenericSuperclass();
        ParameterizedType parametrizedType = null;
         while (parametrizedType == null) {
            if ((genericSuperClass instanceof ParameterizedType)) {
                    parametrizedType = (ParameterizedType) genericSuperClass;
            } else {
                    genericSuperClass = ((Class<?>) genericSuperClass).getGenericSuperclass();
            }
        }
        this.pojoClass = (Class<P>) parametrizedType.getActualTypeArguments()[0];
        this.exampleClass = (Class<E>) parametrizedType.getActualTypeArguments()[2];
    }

    public abstract M getMapper();

    public int countByExample(E example) throws Exception {
        M mapper = getMapper();
        Method m = mapper.getClass().getMethod("countByExample", exampleClass);
        int result = Integer.valueOf(String.valueOf(m.invoke(mapper, example)));
        return result;
    }

    public int deleteByExample(E example) throws Exception {
        M mapper = getMapper();
        Method m = mapper.getClass().getMethod("deleteByExample", exampleClass);
        int result = (Integer) m.invoke(mapper, example);
        return result;
    }

    public List<P> selectByExample(E example) throws Exception {
        M mapper = getMapper();
        Method m = mapper.getClass().getMethod("selectByExample", exampleClass);
        List<P> result = (List<P>) m.invoke(mapper, example);
        return result;
    }

    public P selectOneByExample(E example) throws Exception {
        M mapper = getMapper();
        Method m = mapper.getClass().getMethod("selectByExample", exampleClass);
        List<P> result = (List<P>) m.invoke(mapper, example);
        if (result == null || result.isEmpty()) {
            return null;
        } else if (result.size() == 1) {
            return result.get(0);
        } else {
            throw new Exception("La consulta retorno mas de un resultado");
        }
    }

    public int updateByExample(P record, E example) throws Exception {
        M mapper = getMapper();
        Method m = mapper.getClass().getMethod("updateByExample", pojoClass, exampleClass);
        int result = (Integer) m.invoke(mapper, record, example);
        return result;
    }

    public int updateByExampleSelective(P record, E example) throws Exception {
        M mapper = getMapper();
        Method m = mapper.getClass().getMethod("updateByExampleSelective", pojoClass, exampleClass);
        int result = (Integer) m.invoke(mapper, record, example);
        return result;
    }

    public P selectByPrimaryKey(ID id) throws Exception {
        M mapper = getMapper();
        Method m = mapper.getClass().getMethod("selectByPrimaryKey", id.getClass());
        P result = (P) m.invoke(mapper, id);
        return result;
    }

    public int updateByPrimaryKeySelective(P record) throws Exception {
        M mapper = getMapper();
        Method m = mapper.getClass().getMethod("updateByPrimaryKeySelective", pojoClass);
        int result = (Integer) m.invoke(mapper, record);
        return result;
    }

    public int updateByPrimaryKey(P record) throws Exception {
        M mapper = getMapper();
        Method m = mapper.getClass().getMethod("updateByPrimaryKey", pojoClass);
        int result = (Integer) m.invoke(mapper, record);
        return result;
    }

    public int deleteByPrimaryKey(ID id) throws Exception {
        M mapper = getMapper();
        Method m = mapper.getClass().getMethod("deleteByPrimaryKey", pojoClass);
        int result = (Integer) m.invoke(mapper, id);
        return result;
    }

    public int insert(P record) throws Exception {
        M mapper = getMapper();
        Method m = mapper.getClass().getMethod("insert", pojoClass);
        int result = (Integer) m.invoke(mapper, record);
        return result;
    }

    public int insertSelective(P record) throws Exception {
        M mapper = getMapper();
        Method m = mapper.getClass().getMethod("insertSelective", pojoClass);
        int result = (Integer) m.invoke(mapper, record);
        return result;
    }
}