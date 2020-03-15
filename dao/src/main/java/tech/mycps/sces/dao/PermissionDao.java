package tech.mycps.sces.dao;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tech.mycps.sces.domain.Permission;

import java.util.List;

/**
 * 查询权限
 */
@Repository
public interface PermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{roleId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "permissionName", column = "permissionName"),
            @Result(property = "permissionId", column = "permissionId"),
            @Result(property = "menus", column = "id", javaType = java.util.List.class, many = @Many(select = "tech.mycps.sces.dao.MenuDao.findMenuByPermissionId"))
    })
    public List<Permission> findPermissionByRole(String roleId);
}
