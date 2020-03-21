package tech.mycps.sces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import tech.mycps.sces.dao.*;
import tech.mycps.sces.domain.*;
import tech.mycps.sces.domain.Class;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/menus")
public class MenusController {

    @Autowired
    CollegeDao collegeDao;
    @Autowired
    ProfessionDao professionDao;
    @Autowired
    EvaluationTypeDao evaluationTypeDao;
    @Autowired
    EvaluationItemDao evaluationItemDao;
    @Autowired
    ClassDao classDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    UserInfoDao userInfoDao;
    @Autowired
    UserRoleDao userRoleDao;

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
            s += "<option value=\""+ college.getId() +"\">"+ college.getName() +"</option>";
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

    @RequestMapping(value = "evaluationManage.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String evaluationManage() {

        return splice();
    }

    @RequestMapping(value = "saveEvaluationItem.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String saveEvaluationItem(String evaluationNamme, String score, String id){
        int score1 = Integer.parseInt(score);
        int id1 = Integer.parseInt(id);
        try {
            evaluationItemDao.insertItem(evaluationNamme, id1, score1);
            return splice();
        } catch (Exception e) {
            e.printStackTrace();
            return "保存失败";
        }
    }

    private String splice() {
        List<EvaluationType> types = evaluationTypeDao.findAll();
        List<EvaluationItem> items = evaluationItemDao.findAll();

        String s = "<div class=\"card\">\n" +
                "                        <div class=\"card-header\">\n" +
                "                            <strong>综合测评项管理</strong>\n" +
                "                        </div>\n" +
                "                        <div class=\"card-body card-block\">\n" +
                "                            <form action=\"\" method=\"post\" class=\"form-group\">\n" +
                "                                <div class=\"form-group\">\n" +
                "                                    <label for=\"exampleInputName\" class=\"pr-1  form-control-label\">测评项名称：</label>\n" +
                "                                    <input type=\"text\" id=\"evaluationName\" required=\"\" class=\"form-control\"\n" +
                "                                           name=\"collegeName\">\n" +
                "                                </div>\n" +
                "                                <span>&nbsp;&nbsp;&nbsp;</span>\n" +
                "\n" +
                "                                <div class=\"form-group\">\n" +
                "                                    <label for=\"exampleInputName1\" class=\"pr-1  form-control-label\">测评项类型：</label>\n" +
                "                                    <div class=\"rs-select2--dark rs-select2--md m-r-10 rs-select2--border\">\n" +
                "                                        <select class=\"js-select2\" name=\"property\" id=\"evaluationType\">\n" +
                "                                            <option selected=\"selected\">请选择类型</option>";
        for (EvaluationType type :
                types) {
            s += "<option value=\""+ type.getId() +"\">"+ type.getName() +"</option>";
        }
        s += "</select>\n" +
                "                                        <div class=\"dropDownSelect2\"></div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "\n" +
                "                                <div class=\"form-group\">\n" +
                "                                    <label for=\"score\" class=\"pr-1  form-control-label\">分值：</label>\n" +
                "                                    <input type=\"text\" id=\"score\" required=\"\" class=\"form-control\" name=\"collegeName\">\n" +
                "\n" +
                "                                </div>\n" +
                "                            </form>\n" +
                "                        </div>\n" +
                "                        <div class=\"card-footer\">\n" +
                "                            <button type=\"submit\" class=\"btn btn-primary btn-sm\" id=\"evaluation\">\n" +
                "                                <i class=\"fa fa-dot-circle-o\"></i> 保存\n" +
                "                            </button>\n" +
                "                        </div>\n" +
                "                    </div>";
        s += "<div class=\"row\">\n" +
                "                        <div class=\"col-md-12\">\n" +
                "                            <h3 class=\"title-5 m-b-35\">综合测评项</h3>\n" +
                "                            <div class=\"table-responsive table-responsive-data2\">\n" +
                "                                <table class=\"table table-data2\">\n" +
                "                                    <thead>\n" +
                "                                    <tr>\n" +
                "                                        <th>测评项名称</th>\n" +
                "                                        <th>分值</th>\n" +
                "                                        <th>类型</th>\n" +
                "                                        <th>操作</th>\n" +
                "                                    </tr>\n" +
                "                                    </thead>\n" +
                "                                    <tbody>";
        for (EvaluationItem item :
                items) {
            s += "<tr class=\"tr-shadow\">\n" +
                    "                                        \n" +
                    "                                        <td>"+ item.getName() +"</td>\n" +
                    "                                        <td>\n" +
                    "                                            <span class=\"block-email\">"+ item.getMax() +"</span>\n" +
                    "                                        </td>\n" +
                    "                                        <td class=\"desc\">"+item.getTypeName()+"</td>\n" +
                    "                                        <td><a id=\"edit\" href=\"javascript:;\">编辑</a><span>&nbsp;&nbsp;&nbsp;</span><a id=\"delete\" href=\"javascript:;\">删除</a></td>\n" +
                    "\n" +
                    "                                    </tr>\n" +
                    "                                    <tr class=\"spacer\"></tr>";
        }
        return s;
    }

    @RequestMapping(value = "/addStudentInfo.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addStudentInfo() {
        String s = "<div class=\"card\">\n" +
                "                        <div class=\"card-header\">\n" +
                "                            <strong>添加学生信息</strong>\n" +
                "                        </div>\n" +
                "                        <div class=\"card-body card-block\">\n" +
                "                            <form action=\"\" method=\"post\" class=\"form-group\">\n" +
                "                                <div class=\"form-group\">\n" +
                "                                    <label for=\"studentName\" class=\"pr-1  form-control-label\">学生姓名</label>\n" +
                "                                    <input type=\"text\" id=\"studentName\"  required=\"required\" class=\"form-control\">\n" +
                "                                </div>\n" +
                "                                <div class=\"form-group\">\n" +
                "                                    <label for=\"studentId\" class=\"px-1  form-control-label\">学生学号</label>\n" +
                "                                    <input type=\"text\" id=\"studentId\"  required=\"required\" class=\"form-control\">\n" +
                "                                </div>\n" +
                "                                <div class=\"form-group\">\n" +
                "                                    <label for=\"studentId\" class=\"px-1  form-control-label\">入学年份(如：2016)</label>\n" +
                "                                    <input type=\"text\" id=\"beginYear\"  required=\"required\" class=\"form-control\">\n" +
                "                                </div>\n" +
                "                                <label for=\"classSelect\" class=\"pr-1  form-control-label\">所属班级</label>\n" +
                "                                <div class=\"rs-select2--dark rs-select2--md m-r-10 rs-select2--border\" >\n" +
                "                                    <select class=\"js-select2\" name=\"property\" id=\"classSelect\">\n" +
                "                                        <option selected=\"selected\">请选择班级</option>";
        List<Class> classes = classDao.findAll();
        for (Class c:
            classes){
            s += "<option value=\""+ c.getId() +"\">"+ c.getName() +"</option>";
        }
        s += "</select>\n" +
                "                                    <div class=\"dropDownSelect2\"></div>\n" +
                "                                </div>\n" +
                "                                <div class=\"row form-group\">\n" +
                "                                    <div class=\"col col-md-3\">\n" +
                "                                        <label class=\" form-control-label\">性别</label>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"col col-md-9\">\n" +
                "                                        <div class=\"form-check-inline form-check\">\n" +
                "                                            <label for=\"inline-radio1\" class=\"form-check-label \">\n" +
                "                                                <input type=\"radio\" id=\"inline-radio1\" name=\"inline-radios\" checked=\"checked\" value=\"男\" class=\"form-check-input\">男\n" +
                "                                            </label>\n" +
                "                                            <label for=\"inline-radio2\" class=\"form-check-label \">\n" +
                "                                                <input type=\"radio\" id=\"inline-radio2\" name=\"inline-radios\" value=\"女\" class=\"form-check-input\">女\n" +
                "                                            </label>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                            </form>\n" +
                "                        </div>\n" +
                "                        <div class=\"card-footer\">\n" +
                "                            <button type=\"submit\" class=\"btn btn-primary btn-sm\" id=\"studentSumbit\">\n" +
                "                                <i class=\"fa fa-dot-circle-o\"></i> 保存\n" +
                "                            </button>\n" +
                "                        </div>\n" +
                "                    </div>";
        return s;
    }

    @RequestMapping(value = "/saveStudentInfo.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String saveStudentInfo(String studentName, String studentId, String beginYear, String id, String sex) {
        String password = studentId.substring(4);
        try {
            studentDao.insertStudentInfo(studentId, studentName, sex, Integer.parseInt(id), Integer.parseInt(beginYear));
            userInfoDao.insertUserInfo(studentId, password, 1);
            String userId = userInfoDao.findIdByUsername(studentId);
            String roleId = roleDao.findIdByRoleName("STUDENT");
            userRoleDao.insertUserRole(userId, roleId);
        } catch (Exception e) {
            e.printStackTrace();
            return "保存失败!";
        }
        return "保存成功!";
    }

    @RequestMapping(value = "/checkStudentInfo.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String checkStudentInfo(String studentId) {
        String s = "<div class=\"card\">\n" +
                "                        <div class=\"card-header\">\n" +
                "                            <strong>查看学生信息</strong>\n" +
                "                        </div>\n" +
                "                        <div class=\"card-body card-block\">\n" +
                "                            <form action=\"\" method=\"post\" class=\"form-inline\">\n" +
                "                                <div class=\"form-group\">\n" +
                "                                    <label for=\"checkStudentInfo1\" class=\"pr-1  form-control-label\">请输入要查询的学生的学号：</label>\n" +
                "                                    <input type=\"text\" id=\"checkStudentInfo1\" required=\"\" class=\"form-control\" name=\"checkStudentInfo1\">\n" +
                "                                </div>\n" +
                "                            </form>\n" +
                "                        </div>\n" +
                "                        <div class=\"card-footer\">\n" +
                "                            <button type=\"submit\" class=\"btn btn-primary btn-sm\" id=\"checkStudent\">\n" +
                "                                <i class=\"fa fa-dot-circle-o\"></i> 查询\n" +
                "                            </button>\n" +
                "                        </div>\n" +
                "                    </div>";
        return s;
    }

    @RequestMapping(value = "/checkStudentInfos.do")
    @ResponseBody
    public  Map<String, String> checkStudentInfos(String studentId) {
        Map<String, String> map = new HashMap<String, String>();
        Student student = studentDao.findStudentByStudentId(studentId);
        if (student != null) {
            String studentName = student.getName();
            String email = student.getEmail();
            String sex = student.getSex();
            int classId = student.getClassId();
            int beginYear = student.getBeginYear();
            Class c = classDao.findById(classId);
            College college = collegeDao.findById(c.getCollegeId());
            Profession profession = professionDao.findById(c.getProfessionId());
            map.put("studentId", studentId);
            map.put("studnetName", studentName);
            map.put("email", email);
            map.put("sex", sex);
            map.put("beginYear", String.valueOf(beginYear));
            map.put("className", c.getName());
            map.put("collegName", college.getName());
            map.put("professionName", profession.getName());
            map.put("error", "");
            return map;
        } else {
            map.put("error", "查询失败，没有此学号的学生");
            return map;
        }

    }
}
