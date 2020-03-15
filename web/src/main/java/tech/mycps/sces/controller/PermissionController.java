package tech.mycps.sces.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.mycps.sces.dao.PermissionDao;
import tech.mycps.sces.dao.RoleDao;
import tech.mycps.sces.dao.UserInfoDao;
import tech.mycps.sces.domain.Menu;
import tech.mycps.sces.domain.Permission;
import tech.mycps.sces.domain.Role;
import tech.mycps.sces.domain.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private PermissionDao permissionDao;

    private List<Permission> permissions;
    private Map<String, List<Menu>> firstMenus = new HashMap<String, List<Menu>>();
    //下面这种写法会报空指针异常
    //private Map<String, List<Menu>> firstMenus = null;

    private boolean flag = false;


    @RequestMapping("/findMenus.do")
    public @ResponseBody Map<String, List<Menu>> findMenus() throws JsonProcessingException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        //通过用户名找到该用户
        UserInfo userInfo = userInfoDao.findByUsername(username);
        //通过该用户找到该用户具有的角色
        List<Role> roles = userInfo.getRoles();
        //因为可以具有不同的角色，所以使用循环
        //System.out.println(roles.size());
        if (roles.size() == 1) {
            for (Role role :
                    roles) {
                firstMenus = findFirstMenus(role.getId());
            }
        } else if (roles.size() == 2) {
            for (Role role :
                    roles) {
                if ("ADMIN".equals(role.getRoleName())) {
                    firstMenus = findFirstMenus(role.getId());
                    return firstMenus;
                }
            }
        }

        return firstMenus;
    }

    private Map<String, List<Menu>> findFirstMenus(String roleId) {
        permissions = permissionDao.findPermissionByRole(roleId);
        for (Permission permission : permissions) {
            firstMenus.put(permission.getPermissionName(), permission.getMenus());
        }
        return firstMenus;
    }
}

