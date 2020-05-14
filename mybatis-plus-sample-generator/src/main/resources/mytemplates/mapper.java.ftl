package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};

import com.guahao.convention.data.domain.PageQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * ${table.comment!} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
public interface ${table.mapperName} {

 ${entity} get(@param("po") ${entity} po);

 List<${entity}> list(@param("po") ${entity} po);

 List<${entity}> pageList(@param("po") ${entity} po , @Param("pageQuery") PageQuery pageQuery);

 Long count(@param("po") ${entity} po);

 int insert(${entity} po);

 int updateByPrimaryKey(${entity} po);

 int deleteByPrimaryKey(Long id);

}

