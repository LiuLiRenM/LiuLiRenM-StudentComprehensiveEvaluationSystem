package tech.mycps.sces.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tech.mycps.sces.domain.EvaluationItem;

import java.util.List;

@Repository
public interface EvaluationItemDao {


    @Select("select * from evaluationitem")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "typeId", column = "typeId"),
            @Result(property = "max", column = "max"),
            @Result(property = "typeName", column = "typeId", many = @Many(select = "tech.mycps.sces.dao.EvaluationTypeDao.findNameById"))
    })
    public List<EvaluationItem> findAll();

    @Insert("insert into evaluationitem(name, typeId, max) values (#{name},#{typeId}, #{max})")
    public void insertItem(@Param("name") String name, @Param("typeId") int typeId, @Param("max") int max);


    @Select("select * from evaluationitem where typeId = #{typeId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "typeId", column = "typeId"),
            @Result(property = "max", column = "max"),
            @Result(property = "typeName", column = "typeId", many = @Many(select = "tech.mycps.sces.dao.EvaluationTypeDao.findNameById"))
    })
    public List<EvaluationItem> findByTypeId(int typeId);
}
