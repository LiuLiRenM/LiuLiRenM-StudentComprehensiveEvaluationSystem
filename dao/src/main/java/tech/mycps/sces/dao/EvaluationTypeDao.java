package tech.mycps.sces.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tech.mycps.sces.domain.EvaluationType;

import java.util.List;

@Repository
public interface EvaluationTypeDao {

    @Select("select * from evaluationtype")
    public List<EvaluationType> findAll();

    @Select("select name from evaluationtype where id = #{id}")
    public String findNameById(int id);
}
