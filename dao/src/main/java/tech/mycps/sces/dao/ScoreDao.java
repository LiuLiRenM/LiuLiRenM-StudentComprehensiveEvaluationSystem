package tech.mycps.sces.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tech.mycps.sces.domain.Score;

import java.util.List;

/**
 * @Author: LiuYaoWen
 * @Date: 2020/4/12 下午4:03
 */
@Repository
public interface ScoreDao {

    @Insert("insert into score (studentId, itemId, score, begin) values (#{studentId}, #{itemId}, #{score}, #{begin})")
    void insertStudentScore(@Param("studentId") String studentId, @Param("itemId") int itemId, @Param("score") int score, @Param("begin") int begin);

    @Select("select count(*) from score where studentId = #{studentId} and begin = #{begin}")
    int countStudent(@Param("studentId") String studentId, @Param("begin") int begin);

    @Select("select * from score where studentId = #{studentId} and begin = #{begin}")
    List<Score> findScore(@Param("studentId") String studentId, @Param("begin") int begin);
}
