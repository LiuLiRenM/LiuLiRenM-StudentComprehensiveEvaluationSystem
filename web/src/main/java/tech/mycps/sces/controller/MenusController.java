package tech.mycps.sces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import tech.mycps.sces.dao.CollegeDao;
import tech.mycps.sces.dao.ProfessionDao;
import tech.mycps.sces.domain.College;

import java.util.List;

@Controller
@RequestMapping("/menus")
public class MenusController {

    @Autowired
    CollegeDao collegeDao;
    @Autowired
    ProfessionDao professionDao;

    @RequestMapping(value = "/collegeManage.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String collegeManage() {

        String s = "<div class=\"card\">\n" +
                "                        <div class=\"card-header\">\n" +
                "                            <strong>添加系别信息</strong>\n" +
                "                        </div>\n" +
                "                        <div class=\"card-body card-block\">\n" +
                "                            <form action=\"\" method=\"post\" class=\"form-inline\">\n" +
                "                                <div class=\"form-group\">\n" +
                "                                    <label for=\"exampleInputName2\" class=\"pr-1  form-control-label\">系别名称：</label>\n" +
                "                                    <input type=\"text\" id=\"exampleInputName2\" required=\"\" class=\"form-control\" name=\"collegeName\">\n" +
                "                                </div>\n" +
                "                            </form>\n" +
                "                        </div>\n" +
                "                        <div class=\"card-footer\">\n" +
                "                            <button type=\"submit\" class=\"btn btn-primary btn-sm\" id=\"submit\">\n" +
                "                                <i class=\"fa fa-dot-circle-o\"></i> 保存\n" +
                "                            </button>\n" +
                "                        </div>\n" +
                "                    </div>";
        return s;
    }

    @RequestMapping(value = "/saveCollegeName.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String saveCollegeName(@RequestParam("collegeName") String collegeName) {
        try {
            collegeDao.insertCollegeInfo(collegeName);
        } catch (Exception e) {
            e.printStackTrace();
            return "保存失败！";
        }
        return "保存成功";
    }

    @RequestMapping(value = "/professionManage.do",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String professionManage() {
        List<College> colleges = collegeDao.findAll();
        String s = "<div class=\"card\">\n" +
                "                        <div class=\"card-header\">\n" +
                "                            <strong>添加专业信息</strong>\n" +
                "                        </div>\n" +
                "                        <div class=\"card-body card-block\">\n" +
                "                            <form action=\"\" method=\"post\" class=\"form-inline\">\n" +
                "                                <div class=\"form-group\">\n" +
                "                                    <label for=\"exampleInputName\" class=\"pr-1  form-control-label\">专业名称：</label>\n" +
                "                                    <input type=\"text\" id=\"exampleInputName\" required=\"\" class=\"form-control\" name=\"professionName\">\n" +
                "                                </div>\n" +
                "                                <span>&nbsp;&nbsp;&nbsp;</span>\n" +
                "                                <label for=\"exampleInputName1\" class=\"pr-1  form-control-label\">所属系别：</label>\n" +
                "                                <div class=\"rs-select2--dark rs-select2--md m-r-10 rs-select2--border\">\n" +
                "                                    <select class=\"js-select2\" name=\"property\" id=\"exampleInputName1\">\n" +
                "                                        <option selected=\"selected\">请选择系别</option>";
        for (College college :
                colleges) {
            s += "<option id=\""+ college.getId() +"\" value=\"\">"+ college.getName() +"</option>";
        }
        s += "</select>\n" +
                "                                    <div class=\"dropDownSelect2\"></div>\n" +
                "                                </div>\n" +
                "                            </form>\n" +
                "                        </div>\n" +
                "                        <div class=\"card-footer\">\n" +
                "                            <button type=\"submit\" class=\"btn btn-primary btn-sm\" id=\"submitPro\">\n" +
                "                                <i class=\"fa fa-dot-circle-o\"></i> 保存\n" +
                "                            </button>\n" +
                "                        </div>\n" +
                "                    </div>";
        return s;
    }

    @RequestMapping(value = "/saveProfessionName.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String saveProfessionName(String professionName, String id) {
        int collegeId = Integer.parseInt(id);
        try {
            professionDao.insertProfessionName(professionName, collegeId);
        } catch (Exception e) {
            e.printStackTrace();
            return "保存失败!";
        }
        return "保存成功!";
    }
}
