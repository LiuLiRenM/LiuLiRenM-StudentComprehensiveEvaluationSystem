package tech.mycps.sces.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tech.mycps.sces.domain.Student;

import java.util.List;

@Repository
public interface StudentDao {

    @Insert("insert into student (userId, name, sex, classId, beginYear) values (#{userId}, #{name}, #{sex}, #{classId}, #{beginYear})")
    public void insertStudentInfo(@Param("userId") String userId, @Param("name") String name, @Param("sex") String sex, @Param("classId") int classId, @Param("beginYear") int beginYear);

    @Select("select * from student where userId = #{studentId}")
    public Student findStudentByStudentId(String studentId);

    @Update("update student set name = #{name}, sex = #{sex}, email = #{email} where userId = #{id}")
    public void updateStudentInfo(@Param("id") String id, @Param("name") String name, @Param("sex") String sex, @Param("email") String email);

    @Select("select * from student where classId = #{classId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "className", column = "classId", javaType = String.class, many = @Many(select = "tech.mycps.sces.dao.ClassDao.findClassNameById"))
    })
    public List<Student> findStudentByClassId(int classId);
}
