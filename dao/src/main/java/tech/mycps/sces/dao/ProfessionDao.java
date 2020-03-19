package tech.mycps.sces.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionDao {

    @Insert("insert into profession(name, collegeId) values(#{professionName}, #{collegeId})")
    public void insertProfessionName(@Param("professionName") String professionName, @Param("collegeId") int collegeId);

}
