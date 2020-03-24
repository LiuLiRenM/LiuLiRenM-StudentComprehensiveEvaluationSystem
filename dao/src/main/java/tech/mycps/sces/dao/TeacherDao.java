package tech.mycps.sces.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tech.mycps.sces.domain.Teacher;

@Repository
public interface TeacherDao {

    @Insert("insert into teacher (userId, name, sex, age, collegeId, email) values (#{userId}, #{name}, #{sex}, #{age}, #{collegeId}, #{email})")
    public void insertTeacherInfo(@Param("userId") String userId, @Param("name") String name, @Param("sex") String sex, @Param("age") int age, @Param("collegeId") int collegeId, @Param("email") String email);

    @Select("select id from teacher where userId = #{userId}")
    public int findIdByUserId(String userId);

    @Select("select * from teacher where userId = #{userId}")
    public Teacher findTeacherByTeacherId(String userId);

    @Update("update teacher set name = #{name}, sex = #{sex}, age = #{age}, email = #{email} where userId = #{userId}")
    public void saveTeacherInfo(@Param("name") String name, @Param("sex") String sex, @Param("age") int age, @Param("email") String email, @Param("userId") String userId);

    @Select("select * from teacher where userId = #{userId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "allclass", column = "id", javaType = java.util.List.class, many = @Many(select = "tech.mycps.sces.dao.ClassDao.findClassesById"))
    })
    public Teacher findByUserId(String userId);
}
