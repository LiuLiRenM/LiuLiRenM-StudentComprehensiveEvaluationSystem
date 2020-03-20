package tech.mycps.sces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import tech.mycps.sces.dao.CollegeDao;
import tech.mycps.sces.dao.EvaluationItemDao;
import tech.mycps.sces.dao.EvaluationTypeDao;
import tech.mycps.sces.dao.ProfessionDao;
import tech.mycps.sces.domain.College;
import tech.mycps.sces.domain.EvaluationItem;
import tech.mycps.sces.domain.EvaluationType;

import java.util.List;

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
}
