package tech.mycps.sces.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import tech.mycps.sces.domain.UserInfo;

import java.util.List;

public interface UserInfoService extends UserDetailsService {

    //查询所有记录
    public List<UserInfo> findAll();
}
