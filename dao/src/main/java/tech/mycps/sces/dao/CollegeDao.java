package tech.mycps.sces.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tech.mycps.sces.domain.College;

import java.util.List;

@Repository
public interface CollegeDao {

    @Insert("insert into college(name) value (#{collegeName})")
    public void insertCollegeInfo(String collegeName);

    @Select("select * from college")
    public List<College> findAll();

    @Select("select * from college where id = #{id}")
    public College findById(int id);
}
