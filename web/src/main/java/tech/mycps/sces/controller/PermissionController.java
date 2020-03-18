package tech.mycps.sces.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
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

/**
 * 获取权限数据，然后返回到前端
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private PermissionDao permissionDao;

    private List<Permission> permissions;
    //private Map<String, List<Menu>> firstMenus = new HashMap<String, List<Menu>>();
    //下面这种写法会报空指针异常
    //private Map<String, List<Menu>> firstMenus = null;

    //创建Jackson的核心对象 ObjectMapper
    ObjectMapper mapper = new ObjectMapper();
    //使用redis作为缓存
    Jedis jedis = new Jedis("localhost", 6379);

    @RequestMapping("/findMenus.do")
    public @ResponseBody Map<String, List<Menu>> findMenus() throws JsonProcessingException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String username = userDetails.getUsername();

        Map<String, List<Menu>> firstMenus;

        //使用redis作为缓存
        //首先判断username是否存在在redis中
        if (jedis.get("username") != null) {
            //如果存在则判断是否和当前用户的用户名相同，如果相同则直接取redis中的menus的值
            if (jedis.get("username").equals(username)) {
                String json = jedis.get("menus");
                firstMenus = (Map<String, List<Menu>>) mapper.readValue(json, Map.class);
                return firstMenus;
            } else {
                //如果不相同则从数据库中取数据并存入redis的menus中
                firstMenus = findFirstMenu(username);
                String menus = mapper.writeValueAsString(firstMenus);
                //System.out.println(menus);
                jedis.set("username", username);
                jedis.del("menus");
                jedis.set("menus", menus);
                return firstMenus;
            }
        } else {
            //如果username不存在在redis中，则从数据库取数据并将用户名存在redis的username中，数据存在redis的menus中
            firstMenus = findFirstMenu(username);
            String menus = mapper.writeValueAsString(firstMenus);
            jedis.set("username", username);
            jedis.set("menus", menus);
            return firstMenus;
        }
    }

    private Map<String, List<Menu>> findFirstMenu(String username) {
        Map<String, List<Menu>> firstMenus = new HashMap<String, List<Menu>>();
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
        Map<String, List<Menu>> firstMenus = new HashMap<String, List<Menu>>();
        permissions = permissionDao.findPermissionByRole(roleId);
        for (Permission permission : permissions) {
            firstMenus.put(permission.getPermissionName(), permission.getMenus());
        }
        return firstMenus;
    }
}

