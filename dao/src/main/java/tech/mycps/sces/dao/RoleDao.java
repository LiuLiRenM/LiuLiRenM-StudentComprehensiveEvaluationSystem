package tech.mycps.sces.dao;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tech.mycps.sces.domain.Role;

import java.util.List;

@Repository
public interface RoleDao {

    //根据user表的id查找角色
    @Select("select * from role where id in (select roleId from user_role where userId = #{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "tech.mycps.sces.dao.PermissionDao.findPermissionByRole"))
    })
    public List<Role> findByUserId(String userId);

    //查找所有记录
    @Select("select * from role")
    public List<Role> findAll();

    @Select("select id from role where roleName = #{roleName}")
    public String findIdByRoleName(String roleName);
}
