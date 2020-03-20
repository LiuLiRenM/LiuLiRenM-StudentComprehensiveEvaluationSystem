package tech.mycps.sces.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tech.mycps.sces.domain.Class;

import java.util.List;

@Repository
public interface ClassDao {

    @Select("select * from class")
    public List<Class> findAll();
}
