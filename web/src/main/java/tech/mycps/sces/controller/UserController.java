package tech.mycps.sces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tech.mycps.sces.domain.UserInfo;
import tech.mycps.sces.service.UserInfoService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userService;

    @RequestMapping("/findall")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> users = userService.findAll();
        modelAndView.addObject(users);
        for (UserInfo user :
                users) {
            System.out.println(user);
        }
        return modelAndView;
    }
}
