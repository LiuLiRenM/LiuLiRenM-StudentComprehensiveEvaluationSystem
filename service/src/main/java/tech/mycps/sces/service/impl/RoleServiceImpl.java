package tech.mycps.sces.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.mycps.sces.dao.RoleDao;
import tech.mycps.sces.domain.Role;
import tech.mycps.sces.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    //根据user表的id和role表的id查找角色
    public List<Role> findByUserId(String userId) {
        return roleDao.findByUserId(userId);
    }

    //查找所有记录
    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
