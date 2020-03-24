package tech.mycps.sces.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherClassDao {

    @Insert("insert into teacher_class (teacherId, classId) values (#{teacherId}, #{classId})")
    public void insertIntoTeacherClass(@Param("teacherId") int teacherId, @Param("classId") int classId);
}
