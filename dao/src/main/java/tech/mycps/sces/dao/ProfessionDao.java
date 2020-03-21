package tech.mycps.sces.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tech.mycps.sces.domain.Profession;

@Repository
public interface ProfessionDao {

    @Insert("insert into profession(name, collegeId) values(#{professionName}, #{collegeId})")
    public void insertProfessionName(@Param("professionName") String professionName, @Param("collegeId") int collegeId);

    @Select("select * from profession where id = #{id}")
    public Profession findById(int id);
}
