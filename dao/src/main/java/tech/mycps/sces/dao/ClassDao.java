package tech.mycps.sces.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tech.mycps.sces.domain.Class;

import java.util.List;

@Repository
public interface ClassDao {

    @Select("select * from class")
    public List<Class> findAll();

    @Select("select * from class where id = #{id}")
    public Class findById(int id);

    @Select("select * from class where id in (select classId from teacher_class where teacherId = #{teacherId})")
    public List<Class> findClassesById(int teacherId);

    @Select("select name from class where id = #{id}")
    public String findClassNameById(int id);
}
