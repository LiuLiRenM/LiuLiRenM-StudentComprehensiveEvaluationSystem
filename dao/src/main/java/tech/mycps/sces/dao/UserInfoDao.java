package tech.mycps.sces.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tech.mycps.sces.domain.UserInfo;

import java.util.List;

@Repository
public interface UserInfoDao {

    //通过用户名查找用户
    @Select("select * from user where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "tech.mycps.sces.dao.RoleDao.findByUserId"))
    })
    public UserInfo findByUsername(String username);

    //查询所有记录
    @Select("select * from user")
    public List<UserInfo> findAll();

    @Insert("insert into user (id, username, password, status) values (uuid(), #{username}, #{password}, #{status})")
    public void insertUserInfo(@Param("username") String username, @Param("password") String password, @Param("status") int status);

    @Select("select id from user where username = #{username}")
    public String findIdByUsername(String username);

}
