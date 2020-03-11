package tech.mycps.sces.service;

import org.springframework.stereotype.Service;
import tech.mycps.sces.domain.Role;

import java.util.List;

public interface RoleService {

    //根据user表的id和role表的id查找角色
    public List<Role> findByUserId(String userId);

    //查找所有记录
    public List<Role> findAll();
}
