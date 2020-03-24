package tech.mycps.sces.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassItemDao {

    @Insert("insert into class_item (classId, evaluationitemId, beginYear, endYear, evaluationtypeId) values (#{classId}, #{evaluationitemId}, #{beginYear}, #{endYear}, #{evaluationtypeId})")
    public void insertItem(@Param("classId") int classId, @Param("evaluationitemId") int evaluationitemId, @Param("beginYear") int beginYear, @Param("endYear") int endYear, @Param("evaluationtypeId") int evaluationtypeId);

}
