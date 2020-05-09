package tech.mycps.sces.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import tech.mycps.sces.dao.*;
import tech.mycps.sces.domain.*;
import tech.mycps.sces.domain.Class;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/menus")
public class MenusController {

    @Autowired
    private CollegeDao collegeDao;
    @Autowired
    private ProfessionDao professionDao;
    @Autowired
    private EvaluationTypeDao evaluationTypeDao;
    @Autowired
    private EvaluationItemDao evaluationItemDao;
    @Autowired
    private ClassDao classDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private TeacherClassDao teacherClassDao;
    @Autowired
    private ClassItemDao classItemDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ScoreDao scoreDao;

    Jedis jedis = new Jedis("localhost", 6379);

    @RequestMapping(value = "/collegeManage.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String collegeManage() {

        return "<div class=\"card\">\n" +
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
        StringBuilder s = new StringBuilder("<div class=\"card\">\n" +
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
                "                                        <option selected=\"selected\">请选择系别</option>");
        for (College college :
                colleges) {
            s.append("<option value=\"").append(college.getId()).append("\">").append(college.getName()).append("</option>");
        }
        s.append("</select>\n" + "                                    <div class=\"dropDownSelect2\"></div>\n" + "                                </div>\n" + "                            </form>\n" + "                        </div>\n" + "                        <div class=\"card-footer\">\n" + "                            <button type=\"submit\" class=\"btn btn-primary btn-sm\" id=\"submitPro\">\n" + "                                <i class=\"fa fa-dot-circle-o\"></i> 保存\n" + "                            </button>\n" + "                        </div>\n" + "                    </div>");
        return s.toString();
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

        StringBuilder s = new StringBuilder("<div class=\"card\">\n" +
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
                "                                            <option selected=\"selected\">请选择类型</option>");
        for (EvaluationType type :
                types) {
            s.append("<option value=\"").append(type.getId()).append("\">").append(type.getName()).append("</option>");
        }
        s.append("</select>\n" + "                                        <div class=\"dropDownSelect2\"></div>\n" + "                                    </div>\n" + "                                </div>\n" + "\n" + "                                <div class=\"form-group\">\n" + "                                    <label for=\"score\" class=\"pr-1  form-control-label\">分值：</label>\n" + "                                    <input type=\"text\" id=\"score\" required=\"\" class=\"form-control\" name=\"collegeName\">\n" + "\n" + "                                </div>\n" + "                            </form>\n" + "                        </div>\n" + "                        <div class=\"card-footer\">\n" + "                            <button type=\"submit\" class=\"btn btn-primary btn-sm\" id=\"evaluation\">\n" + "                                <i class=\"fa fa-dot-circle-o\"></i> 保存\n" + "                            </button>\n" + "                        </div>\n" + "                    </div>");
        s.append("<div class=\"row\">\n" + "                        <div class=\"col-md-12\">\n" + "                            <h3 class=\"title-5 m-b-35\">综合测评项</h3>\n" + "                            <div class=\"table-responsive table-responsive-data2\">\n" + "                                <table class=\"table table-data2\">\n" + "                                    <thead>\n" + "                                    <tr>\n" + "                                        <th>测评项名称</th>\n" + "                                        <th>分值</th>\n" + "                                        <th>类型</th>\n" + "                                        <th>操作</th>\n" + "                                    </tr>\n" + "                                    </thead>\n" + "                                    <tbody>");
        for (EvaluationItem item :
                items) {
            s.append("<tr class=\"tr-shadow\">\n" + "                                        \n" + "                                        <td>").append(item.getName()).append("</td>\n").append("                                        <td>\n").append("                                            <span class=\"block-email\">").append(item.getMax()).append("</span>\n").append("                                        </td>\n").append("                                        <td class=\"desc\">").append(item.getTypeName()).append("</td>\n").append("                                        <td><a id=\"edit\" href=\"javascript:;\">编辑</a><span>&nbsp;&nbsp;&nbsp;</span><a id=\"delete\" href=\"javascript:;\">删除</a></td>\n").append("\n").append("                                    </tr>\n").append("                                    <tr class=\"spacer\"></tr>");
        }
        return s.toString();
    }

    @RequestMapping(value = "/addStudentInfo.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addStudentInfo() {
        StringBuilder s = new StringBuilder("<div class=\"card\">\n" +
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
                "                                        <option selected=\"selected\">请选择班级</option>");
        List<Class> classes = classDao.findAll();
        for (Class c:
            classes){
            s.append("<option value=\"").append(c.getId()).append("\">").append(c.getName()).append("</option>");
        }
        s.append("</select>\n" + "                                    <div class=\"dropDownSelect2\"></div>\n" + "                                </div>\n" + "                                <div class=\"row form-group\">\n" + "                                    <div class=\"col col-md-3\">\n" + "                                        <label class=\" form-control-label\">性别</label>\n" + "                                    </div>\n" + "                                    <div class=\"col col-md-9\">\n" + "                                        <div class=\"form-check-inline form-check\">\n" + "                                            <label for=\"inline-radio1\" class=\"form-check-label \">\n" + "                                                <input type=\"radio\" id=\"inline-radio1\" name=\"inline-radios\" checked=\"checked\" value=\"男\" class=\"form-check-input\">男\n" + "                                            </label>\n" + "                                            <label for=\"inline-radio2\" class=\"form-check-label \">\n" + "                                                <input type=\"radio\" id=\"inline-radio2\" name=\"inline-radios\" value=\"女\" class=\"form-check-input\">女\n" + "                                            </label>\n" + "                                        </div>\n" + "                                    </div>\n" + "                                </div>\n" + "                            </form>\n" + "                        </div>\n" + "                        <div class=\"card-footer\">\n" + "                            <button type=\"submit\" class=\"btn btn-primary btn-sm\" id=\"studentSumbit\">\n" + "                                <i class=\"fa fa-dot-circle-o\"></i> 保存\n" + "                            </button>\n" + "                        </div>\n" + "                    </div>");
        return s.toString();
    }

    @RequestMapping(value = "/saveStudentInfo.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String saveStudentInfo(String studentName, String studentId, String beginYear, String id, String sex) {
        String password = studentId.substring(4);
        try {
            studentDao.insertStudentInfo(studentId, studentName, sex, Integer.parseInt(id), Integer.parseInt(beginYear));
            userInfoDao.insertUserInfo(studentId, bCryptPasswordEncoder.encode(password), 1);
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
    public String checkStudentInfo() {
        return "<div class=\"card\">\n" +
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
    }

    @RequestMapping(value = "/checkStudentInfos.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public  String checkStudentInfos(String studentId) {
        Map<String, String> map = findStudentInfo(studentId);
        if (map.get("error") != null && map.get("error").length() != 0 ) {
            return map.get("error");
        } else {
            return "<div class=\"col-lg-6\">\n" +
                    "                            <div class=\"card\">\n" +
                    "                                <div class=\"card-header\">\n" +
                    "                                    <strong>学生信息</strong>\n" +
                    "                                </div>\n" +
                    "                                <div class=\"card-body card-block\">\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"studentInfo_name\" class=\" form-control-label\">姓名</label>\n" +
                    "                                        <input type=\"text\" id=\"studentInfo_name\" value=\""+ map.get("studnetName") +"\" class=\"form-control\" readonly=\"readonly\">\n" +
                    "                                    </div>\n" +
                    "\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"studentInfo_id\" class=\" form-control-label\">学号</label>\n" +
                    "                                        <input type=\"text\" id=\"studentInfo_id\" value=\""+ map.get("studentId") +"\" class=\"form-control\" readonly=\"readonly\">\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"row form-group\">\n" +
                    "                                        <div class=\"col-8\">\n" +
                    "                                            <div class=\"form-group\">\n" +
                    "                                                <label for=\"studentInfo_sex\" class=\" form-control-label\">性别</label>\n" +
                    "                                                <input type=\"text\" id=\"studentInfo_sex\" value=\""+ map.get("sex") +"\" class=\"form-control\" readonly=\"readonly\">\n" +
                    "                                            </div>\n" +
                    "                                        </div>\n" +
                    "                                        <div class=\"col-8\">\n" +
                    "                                            <div class=\"form-group\">\n" +
                    "                                                <label for=\"studentInfo_beginYear\" class=\" form-control-label\">入学年份</label>\n" +
                    "                                                <input type=\"text\" id=\"studentInfo_beginYear\" value=\""+ map.get("beginYear") +"\" class=\"form-control\" readonly=\"readonly\">\n" +
                    "                                            </div>\n" +
                    "                                        </div>\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"studentInfo_class\" class=\" form-control-label\">班级</label>\n" +
                    "                                        <input type=\"text\" id=\"studentInfo_class\" value=\""+ map.get("className") +"\" class=\"form-control\" readonly=\"readonly\">\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"studentInfo_profession\" class=\" form-control-label\">专业</label>\n" +
                    "                                        <input type=\"text\" id=\"studentInfo_profession\" value=\""+ map.get("professionName") +"\" class=\"form-control\" readonly=\"readonly\">\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"studentInfo_college\" class=\" form-control-label\">学院</label>\n" +
                    "                                        <input type=\"text\" id=\"studentInfo_college\" value=\""+ map.get("collegName") +"\" class=\"form-control\" readonly=\"readonly\">\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"studentInfo_email\" class=\" form-control-label\">Email</label>\n" +
                    "                                        <input type=\"text\" id=\"studentInfo_email\" value=\""+ map.get("email") +"\" class=\"form-control\" readonly=\"readonly\">\n" +
                    "                                    </div>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                        </div>";
        }

    }

    private Map<String, String> findStudentInfo(String studentId) {
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

    private Map<String, String> findTeacherInfo(String teacherId) {
        Map<String, String> map = new HashMap<String, String>();
        Teacher teacher = teacherDao.findTeacherByTeacherId(teacherId);
        if (teacher != null) {
            String teacherName = teacher.getName();
            String email = teacher.getEmail();
            String sex = teacher.getSex();
            int collegeId = teacher.getCollegeId();
            int age = teacher.getAge();
            College college = collegeDao.findById(collegeId);
            map.put("teacherId", teacherId);
            map.put("teacherName", teacherName);
            map.put("email", email);
            map.put("sex", sex);
            map.put("age", String.valueOf(age));
            map.put("collegName", college.getName());
            map.put("error", "");
            return map;
        } else {
            map.put("error", "查询失败，没有此职工号的班主任");
            return map;
        }
    }

    @RequestMapping(value = "/updateStudentInfo.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateStudentInfo() {
        return "<div class=\"card\">\n" +
                "                        <div class=\"card-header\">\n" +
                "                            <strong>修改学生信息</strong>\n" +
                "                        </div>\n" +
                "                        <div class=\"card-body card-block\">\n" +
                "                            <form action=\"\" method=\"post\" class=\"form-inline\">\n" +
                "                                <div class=\"form-group\">\n" +
                "                                    <label for=\"updateStudentInfo1\" class=\"pr-1  form-control-label\">请输入要修改学生信息的学生学号：</label>\n" +
                "                                    <input type=\"text\" id=\"updateStudentInfo1\" required=\"\" class=\"form-control\" name=\"updateStudentInfo1\">\n" +
                "                                </div>\n" +
                "                            </form>\n" +
                "                        </div>\n" +
                "                        <div class=\"card-footer\">\n" +
                "                            <button type=\"submit\" class=\"btn btn-primary btn-sm\" id=\"updateStudent\">\n" +
                "                                <i class=\"fa fa-dot-circle-o\"></i> 查询\n" +
                "                            </button>\n" +
                "                        </div>\n" +
                "                    </div>";
    }

    @RequestMapping(value = "/updateStudentInfos.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateStudentInfos(String studentId) {
        Map<String, String> map = findStudentInfo(studentId);
        if (map.get("error") != null && map.get("error").length() != 0) {
            return map.get("error");
        } else {
            return "<div class=\"col-lg-6\">\n" +
                    "                            <div class=\"card\">\n" +
                    "                                <div class=\"card-header\">\n" +
                    "                                    <strong>学生信息</strong>\n" +
                    "                                </div>\n" +
                    "                                <div class=\"card-body card-block\">\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"updatestudentInfo_name\" class=\" form-control-label\">姓名</label>\n" +
                    "                                        <input type=\"text\" id=\"updatestudentInfo_name\" value=\""+ map.get("studnetName") +"\" class=\"form-control\" >\n" +
                    "                                    </div>\n" +
                    "\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"updatestudentInfo_id\" class=\" form-control-label\">学号</label>\n" +
                    "                                        <input type=\"text\" id=\"updatestudentInfo_id\" value=\""+ map.get("studentId") +"\" class=\"form-control\" readonly=\"readonly\">\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"row form-group\">\n" +
                    "                                        <div class=\"col-8\">\n" +
                    "                                            <div class=\"form-group\">\n" +
                    "                                                <label for=\"updatestudentInfo_sex\" class=\" form-control-label\">性别</label>\n" +
                    "                                                <input type=\"text\" id=\"updatestudentInfo_sex\" value=\""+ map.get("sex") +"\" class=\"form-control\" >\n" +
                    "                                            </div>\n" +
                    "                                        </div>\n" +
                    "                                        <div class=\"col-8\">\n" +
                    "                                            <div class=\"form-group\">\n" +
                    "                                                <label for=\"updatestudentInfo_beginYear\" class=\" form-control-label\">入学年份</label>\n" +
                    "                                                <input type=\"text\" id=\"updatestudentInfo_beginYear\" value=\""+ map.get("beginYear") +"\" class=\"form-control\" readonly=\"readonly\">\n" +
                    "                                            </div>\n" +
                    "                                        </div>\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"updatestudentInfo_class\" class=\" form-control-label\">班级</label>\n" +
                    "                                        <input type=\"text\" id=\"updatestudentInfo_class\" value=\""+ map.get("className") +"\" class=\"form-control\" readonly=\"readonly\">\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"updatestudentInfo_profession\" class=\" form-control-label\">专业</label>\n" +
                    "                                        <input type=\"text\" id=\"updatestudentInfo_profession\" value=\""+ map.get("professionName") +"\" class=\"form-control\" readonly=\"readonly\">\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"updatestudentInfo_college\" class=\" form-control-label\">学院</label>\n" +
                    "                                        <input type=\"text\" id=\"updatestudentInfo_college\" value=\""+ map.get("collegName") +"\" class=\"form-control\" readonly=\"readonly\">\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"updatestudentInfo_email\" class=\" form-control-label\">Email</label>\n" +
                    "                                        <input type=\"text\" id=\"updatestudentInfo_email\" value=\""+ map.get("email") +"\" class=\"form-control\" >\n" +
                    "                                    </div>\n" +
                    "                                </div>\n" +
                    "                                <div class=\"card-footer\">\n" +
                    "                                    <button type=\"submit\" class=\"btn btn-primary btn-sm\" id=\"updateStudentInfo\">\n" +
                    "                                        <i class=\"fa fa-dot-circle-o\"></i> 提交修改\n" +
                    "                                    </button>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                        </div>";
        }
    }

    @RequestMapping(value = "/updateInfo.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateInfo(String name, String sex, String email, String id) {
        try {
            studentDao.updateStudentInfo(id, name, sex, email);
        } catch (Exception e) {
            e.printStackTrace();
            return "保存失败!";
        }
        return "保存成功!";
    }

    @RequestMapping(value = "/addTeacherInfo.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addTeacherInfo() {
        StringBuilder s = new StringBuilder("<div class=\"card\">\n" +
                "                            <div class=\"card-header\">\n" +
                "                                <strong>添加班主任信息</strong>\n" +
                "                            </div>\n" +
                "                            <div class=\"card-body card-block\">\n" +
                "                                <form action=\"\" method=\"post\" class=\"form-group\">\n" +
                "                                    <div class=\"form-group\">\n" +
                "                                        <label for=\"teacherName\" class=\"pr-1  form-control-label\">班主任姓名：</label>\n" +
                "                                        <input type=\"text\" id=\"teacherName\" required=\"\" class=\"form-control\" name=\"teacherName\">\n" +
                "                                    </div>\n" +
                "                                    <div class=\"form-group\">\n" +
                "                                        <label for=\"teacherId\" class=\"pr-1  form-control-label\">职工号：</label>\n" +
                "                                        <input type=\"text\" id=\"teacherId\" required=\"\" class=\"form-control\" name=\"teacherId\">\n" +
                "                                    </div>\n" +
                "                                    <div class=\"form-group\">\n" +
                "                                        <label for=\"teacherAge\" class=\"pr-1  form-control-label\">年龄：</label>\n" +
                "                                        <input type=\"text\" id=\"teacherAge\" required=\"\" class=\"form-control\" name=\"teacherAge\">\n" +
                "                                    </div>\n" +
                "                                    <div class=\"form-group\">\n" +
                "                                        <div class=\"rs-select2--dark rs-select2--md m-r-10 rs-select2--border\">\n" +
                "                                            <label for=\"teacher_college\" class=\"pr-1  form-control-label\">所属学院：</label>\n" +
                "                                            <select class=\"js-select2\" name=\"property\" id=\"teacher_college\" >\n" +
                "                                                <option value=\"\" selected>请选择学院：</option>");
        List<College> colleges = collegeDao.findAll();
        for (College college :
                colleges) {
            s.append("<option value=\"").append(college.getId()).append("\">").append(college.getName()).append("</option>");
        }
        s.append("</select>\n" + "                                            <div class=\"dropDownSelect2\"></div>\n" + "                                        </div>\n" + "                                    </div>\n" + "                                    <div class=\"form-group\">\n" + "                                        <div class=\"rs-select2--dark rs-select2--md m-r-10 rs-select2--border\">\n" + "                                            <label for=\"teacher_class\" class=\"pr-1  form-control-label\">所带班级：</label>\n" + "                                            <select class=\"js-select2\" name=\"property\" id=\"teacher_class\" multiple>");
        List<Class> classes = classDao.findAll();
        for (Class c:
             classes) {
            s.append("<option id=\"\" value=\"").append(c.getId()).append("\">").append(c.getName()).append("</option>");
        }
        s.append("</select>\n" + "                                            <div class=\"dropDownSelect2\"></div>\n" + "                                        </div>\n" + "                                    </div>\n" + "                                    <div class=\"row form-group\">\n" + "                                        <div class=\"col col-md-3\">\n" + "                                            <label class=\" form-control-label\">性别</label>\n" + "                                        </div>\n" + "                                        <div class=\"col col-md-9\">\n" + "                                            <div class=\"form-check-inline form-check\">\n" + "                                                <label for=\"inline-radio1\" class=\"form-check-label \">\n" + "                                                    <input type=\"radio\" id=\"inline-radio1\" name=\"inline-radios\" value=\"男\" class=\"form-check-input\" checked>男\n" + "                                                </label>\n" + "                                                <label for=\"inline-radio2\" class=\"form-check-label \">\n" + "                                                    <input type=\"radio\" id=\"inline-radio2\" name=\"inline-radios\" value=\"女\" class=\"form-check-input\">女\n" + "                                                </label>\n" + "\n" + "                                            </div>\n" + "                                        </div>\n" + "                                    </div>\n" + "                                </form>\n" + "                            </div>\n" + "                            <div class=\"card-footer\">\n" + "                                <button type=\"submit\" class=\"btn btn-primary btn-sm\" id=\"addTeacher\">\n" + "                                    <i class=\"fa fa-dot-circle-o\"></i> 保存\n" + "                                </button>\n" + "                            </div>\n" + "                        </div>");
        return s.toString();
    }

    @RequestMapping(value = "/saveTeacherInfo.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String saveTeacherInfo(String teacher) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Teacher teacher1 = objectMapper.readValue(teacher, Teacher.class);
        String username = teacher1.getUserId();
        String password = username.substring(4);
        try {
            userInfoDao.insertUserInfo(username, bCryptPasswordEncoder.encode(password), 1);
            String userId = userInfoDao.findIdByUsername(username);
            String roleId = roleDao.findIdByRoleName("TEACHER");
            userRoleDao.insertUserRole(userId, roleId);
            teacherDao.insertTeacherInfo(username, teacher1.getName(), teacher1.getSex(), teacher1.getAge(), teacher1.getCollegeId(), teacher1.getEmail());
            int id = teacherDao.findIdByUserId(username);
            List<String> classes = teacher1.getClasses();
            for (String s :
                    classes) {
                teacherClassDao.insertIntoTeacherClass(id, Integer.parseInt(s));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "保存失败!";
        }
        return "保存成功!";
    }

    @RequestMapping(value = "/checkTeacherInfo.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String checkTeacherInfo() {

        return "<div class=\"card\">\n" +
                "                            <div class=\"card-header\">\n" +
                "                                <strong>查看班主任信息</strong>\n" +
                "                            </div>\n" +
                "                            <div class=\"card-body card-block\">\n" +
                "                                <form action=\"\" method=\"post\" class=\"form-inline\">\n" +
                "                                    <div class=\"form-group\">\n" +
                "                                        <label for=\"checkTeacherInfo\" class=\"pr-1  form-control-label\">请输入要查询的班主任的职工号：</label>\n" +
                "                                        <input type=\"text\" id=\"checkTeacherInfo\" required=\"\" class=\"form-control\" name=\"checkTeacherInfo\">\n" +
                "                                    </div>\n" +
                "                                </form>\n" +
                "                            </div>\n" +
                "                            <div class=\"card-footer\">\n" +
                "                                <button type=\"submit\" class=\"btn btn-primary btn-sm\" id=\"checkTeacher\">\n" +
                "                                    <i class=\"fa fa-dot-circle-o\"></i> 查询\n" +
                "                                </button>\n" +
                "                            </div>\n" +
                "                        </div>";
    }

    @RequestMapping(value = "/checkTeacherInfos.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String checkTeacherInfos(String teacherId) {
        Map<String, String> map = findTeacherInfo(teacherId);
        if (map.get("error") != null && map.get("error").length() != 0 ) {
            return map.get("error");
        } else {
            return "<div class=\"col-lg-6\">\n" +
                    "                            <div class=\"card\">\n" +
                    "                                <div class=\"card-header\">\n" +
                    "                                    <strong>班主任信息</strong>\n" +
                    "                                </div>\n" +
                    "                                <div class=\"card-body card-block\">\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"teacherName\" class=\" form-control-label\">姓名</label>\n" +
                    "                                        <input type=\"text\" id=\"teacherName\" value=\""+ map.get("teacherName") +"\" class=\"form-control\" readonly>\n" +
                    "                                    </div>\n" +
                    "\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"teacherId\" class=\" form-control-label\">职工号</label>\n" +
                    "                                        <input type=\"text\" id=\"teacherId\" value=\""+ map.get("teacherId") +"\" class=\"form-control\" readonly>\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"row form-group\">\n" +
                    "                                        <div class=\"col-8\">\n" +
                    "                                            <div class=\"form-group\">\n" +
                    "                                                <label for=\"teacherSex\" class=\" form-control-label\">性别</label>\n" +
                    "                                                <input type=\"text\" id=\"teacherSex\" value=\""+ map.get("sex") +"\" class=\"form-control\" readonly>\n" +
                    "                                            </div>\n" +
                    "                                        </div>\n" +
                    "                                        <div class=\"col-8\">\n" +
                    "                                            <div class=\"form-group\">\n" +
                    "                                                <label for=\"teacherAge\" class=\" form-control-label\">年龄</label>\n" +
                    "                                                <input type=\"text\" id=\"teacherAge\" value=\""+ map.get("age") +"\" class=\"form-control\" readonly>\n" +
                    "                                            </div>\n" +
                    "                                        </div>\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"teacherCollege\" class=\" form-control-label\">学院</label>\n" +
                    "                                        <input type=\"text\" id=\"teacherCollege\" value=\""+ map.get("collegName") +"\" class=\"form-control\" readonly>\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"teacherEmail\" class=\" form-control-label\">Email</label>\n" +
                    "                                        <input type=\"text\" id=\"teacherEmail\" value=\""+ map.get("email") +"\" class=\"form-control\" readonly>\n" +
                    "                                    </div>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                        </div>";
        }
    }

    @RequestMapping(value = "/updateTeacherInfo.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateTeacherInfo() {
        return "<div class=\"card\">\n" +
                "                            <div class=\"card-header\">\n" +
                "                                <strong>修改班主任信息</strong>\n" +
                "                            </div>\n" +
                "                            <div class=\"card-body card-block\">\n" +
                "                                <form action=\"\" method=\"post\" class=\"form-inline\">\n" +
                "                                    <div class=\"form-group\">\n" +
                "                                        <label for=\"updateTeacherInfos\" class=\"pr-1  form-control-label\">请输入要修改信息的班主任的职工号：</label>\n" +
                "                                        <input type=\"text\" id=\"updateTeacherInfos\" required=\"\" class=\"form-control\" name=\"updateTeacherInfos\">\n" +
                "                                    </div>\n" +
                "                                </form>\n" +
                "                            </div>\n" +
                "                            <div class=\"card-footer\">\n" +
                "                                <button type=\"submit\" class=\"btn btn-primary btn-sm\" id=\"updateTeacher\">\n" +
                "                                    <i class=\"fa fa-dot-circle-o\"></i> 查询\n" +
                "                                </button>\n" +
                "                            </div>\n" +
                "                        </div>";
    }

    @RequestMapping(value = "/updateTeacherInfos.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateTeacherInfos(String teacherId) {
        Map<String, String> map = findTeacherInfo(teacherId);
        if (map.get("error") != null && map.get("error").length() != 0) {
            return map.get("error");
        } else {
            return "<div class=\"col-lg-6\">\n" +
                    "                            <div class=\"card\">\n" +
                    "                                <div class=\"card-header\">\n" +
                    "                                    <strong>班主任信息</strong>\n" +
                    "                                </div>\n" +
                    "                                <div class=\"card-body card-block\">\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"teacherName\" class=\" form-control-label\">姓名</label>\n" +
                    "                                        <input type=\"text\" id=\"teacherName\" value=\""+ map.get("teacherName") +"\" class=\"form-control\">\n" +
                    "                                    </div>\n" +
                    "\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"teacherId\" class=\" form-control-label\">职工号</label>\n" +
                    "                                        <input type=\"text\" id=\"teacherId\" value=\""+ map.get("teacherId") +"\" class=\"form-control\" readonly>\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"row form-group\">\n" +
                    "                                        <div class=\"col-8\">\n" +
                    "                                            <div class=\"form-group\">\n" +
                    "                                                <label for=\"teacherSex\" class=\" form-control-label\">性别</label>\n" +
                    "                                                <input type=\"text\" id=\"teacherSex\" value=\""+ map.get("sex") +"\" class=\"form-control\">\n" +
                    "                                            </div>\n" +
                    "                                        </div>\n" +
                    "                                        <div class=\"col-8\">\n" +
                    "                                            <div class=\"form-group\">\n" +
                    "                                                <label for=\"teacherAge\" class=\" form-control-label\">年龄</label>\n" +
                    "                                                <input type=\"text\" id=\"teacherAge\" value=\""+ map.get("age") +"\" class=\"form-control\" >\n" +
                    "                                            </div>\n" +
                    "                                        </div>\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"updatestudentInfo_college\" class=\" form-control-label\">学院</label>\n" +
                    "                                        <input type=\"text\" id=\"updatestudentInfo_college\" value=\""+ map.get("collegName") +"\" class=\"form-control\" readonly>\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"form-group\">\n" +
                    "                                        <label for=\"updatestudentInfo_email\" class=\" form-control-label\">Email</label>\n" +
                    "                                        <input type=\"email\" id=\"updateTeacherInfo_email\" value=\""+ map.get("email") +"\" class=\"form-control\" >\n" +
                    "                                    </div>\n" +
                    "                                </div>\n" +
                    "                                <div class=\"card-footer\">\n" +
                    "                                    <button type=\"submit\" class=\"btn btn-primary btn-sm\" id=\"updateTeacherInfo1\">\n" +
                    "                                        <i class=\"fa fa-dot-circle-o\"></i> 提交修改\n" +
                    "                                    </button>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                        </div>";
        }

    }

    @RequestMapping(value = "/save_teachetInfo.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save_teacherInfo(String name, String sex, int age, String email, String userId) {
        try {
            teacherDao.saveTeacherInfo(name, sex, age, email, userId);
        } catch (Exception e) {
            e.printStackTrace();
            return "保存失败!";
        }
        return "保存成功!";
    }

    @RequestMapping(value = "/setEvaluationItem.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String setEvaluationItem(String username) {
        Teacher teacher = teacherDao.findByUserId(username);
        try {
            List<Class> classes = teacher.getAllclass();
            List<EvaluationType> types = evaluationTypeDao.findAll();
            StringBuilder s = new StringBuilder("<div class=\"card\">\n" +
                    "                        <div class=\"card-header\">\n" +
                    "                            <strong>设置测评项</strong>\n" +
                    "                        </div>\n" +
                    "                        <div class=\"card-body card-block\">\n" +
                    "                            <form class=\"form-inline\" action=\"\" method=\"post\">\n" +
                    "                                <div class=\"row form-inline col-lg-4\">\n" +
                    "                                    <label class=\"form-control-label\" for=\"begin\">综合测评学年：</label>\n" +
                    "                                    <input type=\"text\" id=\"begin\" class=\"form-control col-lg-2\">\n" +
                    "                                    <span>-</span>\n" +
                    "                                    <input type=\"text\" id=\"end\" class=\"form-control col-lg-2\">\n" +
                    "                                </div>\n" +
                    "                                <div class=\"row form-inline\">\n" +
                    "                                    <label class=\"form-control-label\" for=\"type\">测评项类型：</label>\n" +
                    "                                    <select class=\"js-select2\" name=\"property\" id=\"type\" >\n" +
                    "                                        <option value=\"\" selected>请选择测评项：</option>");
            for (EvaluationType evaluationType
                    :types
            ) {
                s.append("<option value=\"").append(evaluationType.getId()).append("\">").append(evaluationType.getName()).append("</option>");
            }
            s.append("</select>\n" + "                                    <div class=\"dropDownSelect2\"></div>\n" + "                                </div>\n" + "                                <div class=\"row form-inline\">\n" + "                                    <label class=\"form-control-label\" for=\"class\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选择班级：</label>\n" + "                                    <select class=\"js-select2\" name=\"property\" id=\"class\" >\n" + "                                        <option value=\"\" selected>请选择班级：</option>");
            for (Class c :
                    classes) {
                s.append("<option value=\"").append(c.getId()).append("\">").append(c.getName()).append("</option>");
            }
            s.append("</select>\n" + "                                    <div class=\"dropDownSelect2\"></div>\n" + "                                </div>\n" + "                            </form>\n" + "                        </div>\n" + "                        <div class=\"card-footer\">\n" + "                            <button type=\"submit\" class=\"btn btn-primary btn-sm\" id=\"checkItem\">\n" + "                                <i class=\"fa fa-dot-circle-o\"></i> 查看测评项\n" + "                            </button>\n" + "                        </div>\n" + "                    </div>");
            return s.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "<h2>你还没有带班</h2>";
        }

    }

    @RequestMapping(value = "/checkItem.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String checkItem(String begin, String end, String typeId, String classId) {
        jedis.set("begin", begin);
        jedis.set("end", end);
        jedis.set("typeId", typeId);
        jedis.set("classId", classId);
        List<EvaluationItem> evaluationItems = evaluationItemDao.findByTypeId(Integer.parseInt(typeId));
        StringBuilder s = new StringBuilder("<div class=\"col-lg-6\">\n" +
                "                        <div class=\"user-data m-b-30\">\n" +
                "                            <h3 class=\"title-3 m-b-30\">\n" +
                "                                <i class=\"zmdi zmdi-account-calendar\"></i>综合测评项</h3>\n" +
                "                            <div class=\"table-responsive table-data\">\n" +
                "                                <table class=\"table\">\n" +
                "                                    <thead>\n" +
                "                                    <tr>\n" +
                "                                        <td>状态</td>\n" +
                "                                        <td>测评项名称</td>\n" +
                "                                        <td>分值</td>\n" +
                "                                        <td>类型</td>\n" +
                "                                    </tr>\n" +
                "                                    </thead>\n" +
                "                                    <tbody>");
        for (EvaluationItem evaluationItem: evaluationItems) {
            s.append("<tr>\n" + "                                        <td>\n" + "                                            <label class=\"au-checkbox\">\n" + "                                                <input type=\"checkbox\" value=\"").append(evaluationItem.getId()).append("\" >\n").append("                                                <span class=\"au-checkmark\"></span>\n").append("                                            </label>\n").append("                                        </td>\n").append("                                        <td>\n").append("                                            <div class=\"table-data__info\">\n").append("                                                <h6>").append(evaluationItem.getName()).append("</h6>\n").append("                                            </div>\n").append("                                        </td>\n").append("                                        <td>\n").append("                                            <div class=\"table-data__info\">\n").append("                                                <h6>").append(evaluationItem.getMax()).append("</h6>\n").append("                                            </div>\n").append("                                        </td>\n").append("                                        <td>\n").append("                                            <div class=\"table-data__info\">\n").append("                                                <h6>").append(evaluationItem.getTypeName()).append("</h6>\n").append("                                            </div>\n").append("                                        </td>\n").append("                                    </tr>");
        }
        s.append("</tbody>\n" + "                                </table>\n" + "                            </div>\n" + "                            <div class=\"user-data__footer\">\n" + "                                <button class=\"au-btn au-btn-load\" id=\"sure\">确定</button>\n" + "                            </div>\n" + "                        </div>\n" + "                    </div>");
        return s.toString();
    }

    @RequestMapping(value = "/checkItems.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String checkItems(@RequestParam(value = "checkId[]") Integer[] checkId) {
        String begin = jedis.get("begin");
        String end = jedis.get("end");
        String typeId = jedis.get("typeId");
        String classId = jedis.get("classId");
        try {
            for (Integer in :
                    checkId) {
                classItemDao.insertItem(Integer.parseInt(classId), in, Integer.parseInt(begin), Integer.parseInt(end), Integer.parseInt(typeId));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "保存失败";
        }
        return "保存成功";
    }

    @RequestMapping(value = "/manageEvaluationResult.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String manageEvaluationResult(String username) {
        Teacher teacher = teacherDao.findByUserId(username);
        StringBuilder s = new StringBuilder("<div class=\"card\">\n" +
                "                            <div class=\"card-header\">\n" +
                "                                <strong>学生测评成绩管理</strong>\n" +
                "                            </div>\n" +
                "                            <div class=\"card-body card-block\">\n" +
                "                                <form class=\"form-inline\" action=\"\" method=\"post\">\n" +
                "                                    <div class=\"row form-inline col-lg-4\">\n" +
                "                                        <label class=\"form-control-label\" for=\"begin\">测评学年：</label>\n" +
                "                                        <input type=\"text\" id=\"begin\" class=\"form-control col-lg-2\">\n" +
                "                                        <span>-</span>\n" +
                "                                        <input type=\"text\" id=\"end\" class=\"form-control col-lg-2\">\n" +
                "                                    </div>\n" +
                "                                    <div class=\"row form-inline\">\n" +
                "                                        <label class=\"form-control-label\" for=\"classType\">选择所要测评的班级：</label>\n" +
                "                                        <select class=\"js-select2\" name=\"property\" id=\"classType\" >\n" +
                "                                            <option value=\"\" selected>请选择班级：</option>");
        List<Class> classes = teacher.getAllclass();
        for (Class c:
             classes) {
            s.append("<option value=\"").append(c.getId()).append("\">").append(c.getName()).append("</option>");
        }
        s.append("</select>\n" + "                                        <div class=\"dropDownSelect2\"></div>\n" + "                                    </div>\n" + "\n" + "                                </form>\n" + "                            </div>\n" + "                            <div class=\"card-footer\">\n" + "                                <button type=\"submit\" class=\"btn btn-primary btn-sm\" id=\"enterScore\">\n" + "                                    <i class=\"fa fa-dot-circle-o\"></i> 录入操行成绩\n" + "                                </button>\n" + "                            </div>\n" + "                        </div>");
        return s.toString();
    }

    @RequestMapping(value = "/manageEvaluationResults.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String manageEvaluationResults(String begin, String classId) {
        int i = 1;
        int classIdI = Integer.parseInt(classId);
        int beginYear = Integer.parseInt(begin);
        jedis.set("begin", begin);
        jedis.set("classId", classId);
        int count = classItemDao.countByBeginYearAndClassId(beginYear, classIdI);
        if (count == 0) {
            return "error";
        } else {
            List<Student> students = studentDao.findStudentByClassId(classIdI);
            StringBuilder s = new StringBuilder("<div class=\"row m-t-30\">\n" +
                    "                            <div class=\"col-lg-12\">\n" +
                    "                                <div class=\"table-responsive m-b-40\">\n" +
                    "                                    <table class=\"table table-borderless table-data3\">\n" +
                    "                                        <thead>\n" +
                    "                                        <tr>\n" +
                    "                                            <th>序号</th>\n" +
                    "                                            <th>学号</th>\n" +
                    "                                            <th>姓名</th>\n" +
                    "                                            <th>班级</th>\n" +
                    "                                            <th>操作</th>\n" +
                    "                                        </tr>\n" +
                    "                                        </thead>\n" +
                    "                                        <tbody>");
            for (Student student :
                    students) {
                s.append("<tr>\n" + "                                            <td>").append(i).append("</td>\n").append("                                            <td id=\"").append(i).append("\">").append(student.getUserId()).append("</td>\n").append("                                            <td>").append(student.getName()).append("</td>\n").append("                                            <td class=\"process\">").append(student.getClassName()).append("</td>\n").append("                                            <td><i class=\"fas fa-edit\"></i><a data-id=\"").append(i).append("\" class=\"js_a\" href=\"javascript:;\">编辑操行评定成绩</a></td>\n").append("                                        </tr>");
                i++;
            }
            s.append("</tbody>\n" + "                                    </table>\n" + "                                </div>\n" + "                            </div>\n" + "                        </div>");
            return s.toString();
        }
    }

    @RequestMapping(value = "/editEvaluationScore.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String editEvaluationScore(String studentId) {
        int begin = Integer.parseInt(jedis.get("begin"));
        int classId = Integer.parseInt(jedis.get("classId"));
        int count = scoreDao.countStudent(studentId, begin);
        if (count > 0) {
            return "该学生已经评测过了";
        } else {
            List<EvaluationItem> evaluationItemsOne = evaluationItemDao.findEvaluationItem(classId, begin, 1);
            List<EvaluationItem> evaluationItemsTwo = evaluationItemDao.findEvaluationItem(classId, begin, 2);
            List<EvaluationItem> evaluationItemsThree = evaluationItemDao.findEvaluationItem(classId, begin, 3);
            List<EvaluationItem> evaluationItemsFour = evaluationItemDao.findEvaluationItem(classId, begin, 4);
            StringBuilder s = new StringBuilder("<div class=\"card\">");
            if (evaluationItemsOne.size() != 0) {
                s.append("<div class=\"card\">\n" + "                            <div class=\"card-header\">\n" + "                                <strong>思想与道德素质</strong>\n" + "                            </div>\n" + "                            <div class=\"card-body card-block\">\n" + "                                <form action=\"\" method=\"post\" class=\"form-horizontal\">");
                for (EvaluationItem evaluationItem:
                        evaluationItemsOne) {
                    s.append("<div class=\"row form-group\">\n" + "                                        <div class=\"col col-md-3\">\n" + "                                            <label for=\"").append(evaluationItem.getId()).append("\" class=\" form-control-label\" >").append(evaluationItem.getName()).append("  [参考分").append(evaluationItem.getMax()).append("]</label>\n").append("                                        </div>\n").append("                                        <div class=\"col-12 col-md-9\">\n").append("                                            <input name=\"").append(evaluationItem.getId()).append("\" class=\"form-control score\" id=\"").append(evaluationItem.getId()).append("\" oninput=\"if (value > ").append(evaluationItem.getMax()).append(") alert('值过大')\">\n").append("                                        </div>\n").append("                                    </div>");
                }
                s.append("</form>\n" + "                            </div>\n" + "                        </div>");
            }
            if (evaluationItemsTwo.size() != 0) {
                s.append("<div class=\"card\">\n" + "                            <div class=\"card-header\">\n" + "                                <strong>专业与文化素质</strong>\n" + "                            </div>\n" + "                            <div class=\"card-body card-block\">\n" + "                                <form action=\"\" method=\"post\" class=\"form-horizontal\">");
                for (EvaluationItem evaluationItem :
                        evaluationItemsTwo) {
                    s.append("<div class=\"row form-group\">\n" + "                                        <div class=\"col col-md-3\">\n" + "                                            <label for=\"").append(evaluationItem.getId()).append("\" class=\" form-control-label\" >").append(evaluationItem.getName()).append("  [参考分").append(evaluationItem.getMax()).append("]</label>\n").append("                                        </div>\n").append("                                        <div class=\"col-12 col-md-9\">\n").append("                                            <input name=\"").append(evaluationItem.getId()).append("\" class=\"form-control score\" id=\"").append(evaluationItem.getId()).append("\" oninput=\"if (value > ").append(evaluationItem.getMax()).append(") alert('值过大')\">\n").append("                                        </div>\n").append("                                    </div>");
                }
                s.append("</form>\n" + "                            </div>\n" + "                        </div>");
            }
            if (evaluationItemsThree.size() != 0) {
                s.append("<div class=\"card\">\n" + "                            <div class=\"card-header\">\n" + "                                <strong>创新与实践素质</strong>\n" + "                            </div>\n" + "                            <div class=\"card-body card-block\">\n" + "                                <form action=\"\" method=\"post\" class=\"form-horizontal\">");
                for (EvaluationItem evaluationItem :
                        evaluationItemsThree) {
                    s.append("<div class=\"row form-group\">\n" + "                                        <div class=\"col col-md-3\">\n" + "                                            <label for=\"").append(evaluationItem.getId()).append("\" class=\" form-control-label\" >").append(evaluationItem.getName()).append("  [参考分").append(evaluationItem.getMax()).append("]</label>\n").append("                                        </div>\n").append("                                        <div class=\"col-12 col-md-9\">\n").append("                                            <input name=\"").append(evaluationItem.getId()).append("\" class=\"form-control score\" id=\"").append(evaluationItem.getId()).append("\" oninput=\"if (value > ").append(evaluationItem.getMax()).append(") alert('值过大')\">\n").append("                                        </div>\n").append("                                    </div>");
                }
                s.append("</form>\n" + "                            </div>\n" + "                        </div>");
            }
            if (evaluationItemsFour.size() != 0) {
                s.append("<div class=\"card\">\n" + "                            <div class=\"card-header\">\n" + "                                <strong>文体与身心素质</strong>\n" + "                            </div>\n" + "                            <div class=\"card-body card-block\">\n" + "                                <form action=\"\" method=\"post\" class=\"form-horizontal\">");
                for (EvaluationItem evaluationItem :
                        evaluationItemsFour) {
                    s.append("<div class=\"row form-group\">\n" + "                                        <div class=\"col col-md-3\">\n" + "                                            <label for=\"").append(evaluationItem.getId()).append("\" class=\" form-control-label\" >").append(evaluationItem.getName()).append("  [参考分").append(evaluationItem.getMax()).append("]</label>\n").append("                                        </div>\n").append("                                        <div class=\"col-12 col-md-9\">\n").append("                                            <input name=\"").append(evaluationItem.getId()).append("\" class=\"form-control score\" id=\"").append(evaluationItem.getId()).append("\" oninput=\"if (value > ").append(evaluationItem.getMax()).append(") alert('值过大')\">\n").append("                                        </div>\n").append("                                    </div>");
                }
                s.append("</form>\n" + "                            </div>\n" + "                        </div>");
            }
            s.append("<div class=\"card-footer\">\n" + "                            <button type=\"submit\" class=\"btn btn-primary btn-sm\" id=\"scoreSubmit\" begin=\"").append(begin).append("\" studentId=\"").append(studentId).append("\">\n").append("                                <i class=\"fa fa-dot-circle-o \"></i> 确定\n").append("                            </button>\n").append("                        </div>\n").append("                    </div>");
            return s.toString();
        }

    }

    @RequestMapping(value = "/saveStudentScore.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String saveStudentScore(String scores, String studentId, String begin) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Score> scoreList = objectMapper.readValue(scores, new TypeReference<List<Score>>() {});
        try {
            for (Score score :
                    scoreList) {
                scoreDao.insertStudentScore(studentId, score.getItemId(), score.getScore(), Integer.parseInt(begin));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "保存失败！";
        }

        return "保存成功！";
    }

    @RequestMapping(value = "/checkEvaluationScore.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String checkEvaluationScore(String username) {
        return "<div class=\"card\">\n" +
                "                            <div class=\"card-header\">\n" +
                "                                <strong>请选择要查询的学年</strong>\n" +
                "                            </div>\n" +
                "                            <div class=\"card-body card-block\">\n" +
                "                                <form class=\"form-inline\" action=\"\" method=\"post\">\n" +
                "                                    <div class=\"row form-inline col-lg-6\">\n" +
                "                                        <label class=\"form-control-label\" for=\"begin\">综合测评学年：</label>\n" +
                "                                        <input type=\"text\" id=\"begin\" class=\"form-control col-lg-3\">\n" +
                "                                        <span>-</span>\n" +
                "                                        <input type=\"text\" id=\"end\" class=\"form-control col-lg-3\">\n" +
                "                                    </div>\n" +
                "                                </form>\n" +
                "                            </div>\n" +
                "                            <div class=\"card-footer\">\n" +
                "                                <button type=\"submit\" class=\"btn btn-primary btn-sm\" id=\"checkEvaluationScoreButton\" username=\""+ username +"\" >\n" +
                "                                    <i class=\"fa fa-dot-circle-o\"></i> 查看综合测评成绩\n" +
                "                                </button>\n" +
                "                            </div>\n" +
                "                        </div>";
    }

    @RequestMapping(value = "/saveEvaluationScoreButton.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String checkEvaluationScoreButton(int begin, String username) {

        List<Score> scoreList = scoreDao.findScore(username, begin);
        if (scoreList.size() == 0) {
            return "你所选择的学年目前还没有测评结果！";
        }

        return begin + username;
    }
}
