package tech.mycps.sces.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tech.mycps.sces.domain.Menu;

import java.util.List;

@Repository
public interface MenuDao {

    @Select("select * from menu where parMenu = #{permissionId}")
    public List<Menu> findMenuByPermissionId(String permissionId);
}
