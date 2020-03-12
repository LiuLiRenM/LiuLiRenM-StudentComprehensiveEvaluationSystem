package tech.mycps.sces.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.mycps.sces.dao.UserInfoDao;
import tech.mycps.sces.domain.Role;
import tech.mycps.sces.domain.UserInfo;
import tech.mycps.sces.service.UserInfoService;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userDao;

    //查询所有记录
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    /**
     * 通过username判断该username是否具有登录权限
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将自己写的user对象封装成UserDetails（SpringSecurity提供的一个类）
        return new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(),
                userInfo.getStatus() == 0 ? false : true,true,
                true, true, getAuthority(userInfo.getRoles()));
    }

    //返回一个List集合，集合中装入的是角色集合
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role :
                roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }


}
