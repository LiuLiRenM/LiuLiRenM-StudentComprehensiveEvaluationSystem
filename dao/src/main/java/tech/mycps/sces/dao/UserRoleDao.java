package tech.mycps.sces.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface UserRoleDao {

    @Insert("insert into user_role (userId, roleId) values (#{userId}, #{roleId})")
    public void insertUserRole(@Param("userId") String userId, @Param("roleId") String roleId);
}
