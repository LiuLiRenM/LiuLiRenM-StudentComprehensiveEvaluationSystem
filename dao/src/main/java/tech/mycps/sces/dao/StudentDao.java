package tech.mycps.sces.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao {

    @Insert("insert into student (userId, name, sex, classId, beginYear) values (#{userId}, #{name}, #{sex}, #{classId}, #{beginYear})")
    public void insertStudentInfo(@Param("userId") String userId, @Param("name") String name, @Param("sex") String sex, @Param("classId") int classId, @Param("beginYear") int beginYear);
}
