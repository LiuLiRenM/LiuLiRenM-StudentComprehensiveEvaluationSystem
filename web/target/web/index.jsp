<%--
  Created by IntelliJ IDEA.
  User: yufei
  Date: 2020/3/12
  Time: 下午6:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>主页</title>

    <!-- Fontfaces CSS-->
    <link href="css/font-face.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">
    <link href="css/style.css" rel="stylesheet" media="all">

    <title>首页</title>



</head>
<body>

<div class="page-wrapper">
    <!-- MENU SIDEBAR-->
    <aside class="menu-sidebar d-none d-lg-block">
        <div class="logo">
            <a href="#">
                <img src="images/icons/logo.png" alt="学生综合测评系统" />
            </a>
        </div>
        <div class="menu-sidebar__content js-scrollbar1">
            <nav class="navbar-sidebar">
                <ul class="list-unstyled navbar__list" id="sidebar">

                </ul>
            </nav>
        </div>
    </aside>
    <!-- END MENU SIDEBAR-->

    <!-- PAGE CONTAINER-->
    <div class="page-container">


        <%--HEADER--%>
        <jsp:include page="header.jsp"/>

        <%--MAIN CONTENT--%>
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid" id="content">

                    <%--主体界面--%>
                    <div class="clock">
                            <div class="flip">
                                <div class="digital front" data-number="0"></div>
                                <div class="digital back" data-number="1"></div>
                            </div>
                            <div class="flip">
                                <div class="digital front" data-number="0"></div>
                                <div class="digital back" data-number="1"></div>
                            </div>
                            <em class="divider">:</em>
                            <div class="flip">
                                <div class="digital front" data-number="0"></div>
                                <div class="digital back" data-number="1"></div>
                            </div>
                            <div class="flip">
                                <div class="digital front" data-number="0"></div>
                                <div class="digital back" data-number="1"></div>
                            </div>
                            <em class="divider">:</em>
                            <div class="flip">
                                <div class="digital front" data-number="0"></div>
                                <div class="digital back" data-number="1"></div>
                            </div>
                            <div class="flip">
                                <div class="digital front" data-number="0"></div>
                                <div class="digital back" data-number="1"></div>
                            </div>
                        </div>

                        <%--<div class="card">
                            <div class="card-header">
                                <strong>添加班主任信息</strong>
                            </div>
                            <div class="card-body card-block">
                                <form action="" method="post" class="form-group">
                                    <div class="form-group">
                                        <label for="teacherName" class="pr-1  form-control-label">班主任姓名：</label>
                                        <input type="text" id="teacherName" required="" class="form-control" name="teacherName">
                                    </div>
                                    <div class="form-group">
                                        <label for="teacherId" class="pr-1  form-control-label">职工号：</label>
                                        <input type="text" id="teacherId" required="" class="form-control" name="teacherId">
                                    </div>
                                    <div class="form-group">
                                        <label for="teacherAge" class="pr-1  form-control-label">年龄：</label>
                                        <input type="text" id="teacherAge" required="" class="form-control" name="teacherAge">
                                    </div>
                                    <div class="form-group">
                                        <div class="rs-select2--dark rs-select2--md m-r-10 rs-select2--border">
                                            <label for="teacher_college" class="pr-1  form-control-label">所属学院：</label>
                                            <select class="js-select2" name="property" id="teacher_college" >
                                                <option value="" selected>请选择学院：</option>
                                                <option id="" value="">Products</option>
                                                <option value="">Services</option>
                                            </select>
                                            <div class="dropDownSelect2"></div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="rs-select2--dark rs-select2--md m-r-10 rs-select2--border">
                                            <label for="teacher_class" class="pr-1  form-control-label">所带班级：</label>
                                            <select class="js-select2" name="property" id="teacher_class" multiple>
                                                <option value="">Products</option>
                                                <option value="">Services</option>
                                            </select>
                                            <div class="dropDownSelect2"></div>
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label class=" form-control-label">性别</label>
                                        </div>
                                        <div class="col col-md-9">
                                            <div class="form-check-inline form-check">
                                                <label for="inline-radio1" class="form-check-label ">
                                                    <input type="radio" id="inline-radio1" name="inline-radios" value="男" class="form-check-input" checked>男
                                                </label>
                                                <label for="inline-radio2" class="form-check-label ">
                                                    <input type="radio" id="inline-radio2" name="inline-radios" value="女" class="form-check-input">女
                                                </label>

                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="card-footer">
                                <button type="submit" class="btn btn-primary btn-sm" id="addTeacher">
                                    <i class="fa fa-dot-circle-o"></i> 保存
                                </button>
                            </div>
                        </div>

                        <div class="card">
                            <div class="card-header">
                                <strong>修改班主任信息</strong>
                            </div>
                            <div class="card-body card-block">
                                <form action="" method="post" class="form-inline">
                                    <div class="form-group">
                                        <label for="checkTeacherInfo1" class="pr-1  form-control-label">请输入要修改信息的班主任的职工号：</label>
                                        <input type="text" id="checkTeacherInfo1" required="" class="form-control" name="checkTeacherInfo1">
                                    </div>
                                </form>
                            </div>
                            <div class="card-footer">
                                <button type="submit" class="btn btn-primary btn-sm" id="checkTeacher1">
                                    <i class="fa fa-dot-circle-o"></i> 查询
                                </button>
                            </div>
                        </div>

                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header">
                                    <strong>班主任信息</strong>
                                </div>
                                <div class="card-body card-block">
                                    <div class="form-group">
                                        <label for="teacherName" class=" form-control-label">姓名</label>
                                        <input type="text" id="teacherName" value="" class="form-control" readonly>
                                    </div>

                                    <div class="form-group">
                                        <label for="teacherId" class=" form-control-label">职工号</label>
                                        <input type="text" id="teacherId" value="" class="form-control" readonly>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col-8">
                                            <div class="form-group">
                                                <label for="teacherSex" class=" form-control-label">性别</label>
                                                <input type="text" id="teacherSex" value="" class="form-control" readonly>
                                            </div>
                                        </div>
                                        <div class="col-8">
                                            <div class="form-group">
                                                <label for="teacherAge" class=" form-control-label">年龄</label>
                                                <input type="text" id="teacherAge" value="" class="form-control" readonly>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="teacherCollege" class=" form-control-label">学院</label>
                                        <input type="text" id="teacherCollege" value="" class="form-control" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label for="teacherEmail" class=" form-control-label">Email</label>
                                        <input type="text" id="teacherEmail" value="" class="form-control" readonly>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-header">
                                    <strong>班主任信息</strong>
                                </div>
                                <div class="card-body card-block">
                                    <div class="form-group">
                                        <label for="teacherName" class=" form-control-label">姓名</label>
                                        <input type="text" id="teacherName" value="" class="form-control">
                                    </div>

                                    <div class="form-group">
                                        <label for="teacherId" class=" form-control-label">职工号</label>
                                        <input type="text" id="teacherId" value="" class="form-control" readonly>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col-8">
                                            <div class="form-group">
                                                <label for="teacherSex" class=" form-control-label">性别</label>
                                                <input type="text" id="teacherSex" value="" class="form-control">
                                            </div>
                                        </div>
                                        <div class="col-8">
                                            <div class="form-group">
                                                <label for="teacherAge" class=" form-control-label">年龄</label>
                                                <input type="text" id="teacherAge" value="" class="form-control" >
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="updatestudentInfo_college" class=" form-control-label">学院</label>
                                        <input type="text" id="updatestudentInfo_college" value="" class="form-control" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label for="updatestudentInfo_email" class=" form-control-label">Email</label>
                                        <input type="email" id="updatestudentInfo_email" value="" class="form-control" >
                                    </div>
                                </div>
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary btn-sm" id="updateStudentInfo1">
                                        <i class="fa fa-dot-circle-o"></i> 提交修改
                                    </button>
                                </div>
                            </div>
                        </div>

                    <div class="card">
                        <div class="card-header">
                            <strong>设置测评项</strong>
                        </div>
                        <div class="card-body card-block">
                            <form class="form-inline" action="" method="post">
                                <div class="row form-inline col-lg-4">
                                    <label class="form-control-label" for="begin">综合测评学年：</label>
                                    <input type="text" id="begin" class="form-control col-lg-2">
                                    <span>-</span>
                                    <input type="text" id="end" class="form-control col-lg-2">
                                </div>
                                <div class="row form-inline">
                                    <label class="form-control-label" for="type">测评项类型：</label>
                                    <select class="js-select2" name="property" id="type" >
                                        <option value="" selected>请选择测评项：</option>
                                        <option value="">Products</option>
                                        <option value="">Services</option>
                                    </select>
                                    <div class="dropDownSelect2"></div>
                                </div>
                                <div class="row form-inline">
                                    <label class="form-control-label" for="class">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选择班级：</label>
                                    <select class="js-select2" name="property" id="class" >
                                        <option value="" selected>请选择班级：</option>
                                        <option value="">Products</option>
                                        <option value="">Services</option>
                                    </select>
                                    <div class="dropDownSelect2"></div>
                                </div>
                            </form>
                        </div>
                        <div class="card-footer">
                            <button type="submit" class="btn btn-primary btn-sm" id="checkItem">
                                <i class="fa fa-dot-circle-o"></i> 查看测评项
                            </button>
                        </div>
                    </div>--%>

                    <%--<div class="col-lg-6">
                        <div class="user-data m-b-30">
                            <h3 class="title-3 m-b-30">
                                <i class="zmdi zmdi-account-calendar"></i>综合测评项</h3>
                            <div class="table-responsive table-data">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <td>状态</td>
                                        <td>测评项名称</td>
                                        <td>分值</td>
                                        <td>类型</td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>
                                            <label class="au-checkbox">
                                                <input type="checkbox">
                                                <span class="au-checkmark"></span>
                                            </label>
                                        </td>
                                        <td>
                                            <div class="table-data__info">
                                                <h6>知行合一百佳</h6>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="table-data__info">
                                                <h6>2</h6>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="table-data__info">
                                                <h6>德育素质</h6>
                                            </div>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="user-data__footer">
                                <button class="au-btn au-btn-load" id="sure">确定</button>
                            </div>
                        </div>
                    </div>--%>

                        <%--<div class="card">
                            <div class="card-header">
                                <strong>学生测评成绩管理</strong>
                            </div>
                            <div class="card-body card-block">
                                <form class="form-inline" action="" method="post">
                                    <div class="row form-inline col-lg-4">
                                        <label class="form-control-label" for="begin">测评学年：</label>
                                        <input type="text" id="begin" class="form-control col-lg-2">
                                        <span>-</span>
                                        <input type="text" id="end" class="form-control col-lg-2">
                                    </div>
                                    <div class="row form-inline">
                                        <label class="form-control-label" for="classType">选择所要测评的班级：</label>
                                        <select class="js-select2" name="property" id="classType" >
                                            <option value="" selected>请选择班级：</option>
                                            <option value="">Products</option>
                                            <option value="">Services</option>
                                        </select>
                                        <div class="dropDownSelect2"></div>
                                    </div>

                                </form>
                            </div>
                            <div class="card-footer">
                                <button type="submit" class="btn btn-primary btn-sm" id="enterScore">
                                    <i class="fa fa-dot-circle-o"></i> 录入操行成绩
                                </button>
                            </div>
                        </div>--%>

                        <%--<div class="row m-t-30">
                            <div class="col-lg-12">
                                <div class="table-responsive m-b-40">
                                    <table class="table table-borderless table-data3">
                                        <thead>
                                        <tr>
                                            <th>序号</th>
                                            <th>学号</th>
                                            <th>姓名</th>
                                            <th>班级</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>2016101825</td>
                                            <td>刘耀文</td>
                                            <td class="process">16计算机科学与技术01班</td>
                                            <td><i class="fas fa-edit"></i><a href="">编辑操行评定成绩</a></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>--%>

                        <%--<di>
                            <h2 class="title-1 m-b-25">德育素质</h2>
                            <div class="table-responsive table--no-card m-b-40">
                                <table class="table table-borderless table-striped table-earning">
                                    <tbody>
                                    <tr>
                                        <td>知行合一百佳[参考分2]：</td>
                                        <td><input type="text" style="border: 1px solid" oninput="if (value > 2) alert('值过大')"></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </di>

                    <input>--%>

                    <%--<div class="card">
                        <div class="card">
                            <div class="card-header">
                                <strong>德育素质</strong>
                            </div>
                            <div class="card-body card-block">
                                <form action="" method="post" class="form-horizontal">
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="1" class=" form-control-label score" >知行合一百佳[参考分2]</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input name="1" class="form-control" id="1" oninput="if (value > 2) alert('值过大')">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="2" class=" form-control-label score">十佳大学生[参考分3]</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input name="2" class="form-control" id="2">
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="card-footer">
                            <button type="submit" class="btn btn-primary btn-sm" id="scoreSubmit" studentId="1">
                                <i class="fa fa-dot-circle-o "></i> 确定
                            </button>
                        </div>
                    </div>--%>

                        <%--<div class="card">
                            <div class="card-header">
                                <strong>2016-2017学年你的综合测评各项得分如下</strong>
                            </div>
                            <div class="card-body card-block">
                                <form class="form-group" action="" method="post">
                                    <div class="row form-inline col-lg-6">
                                        <label class="form-control-label" for="1">思想与道德素质（15%）：</label>
                                        <input type="text" id="1" class="form-control col-lg-3" readonly="readonly" value="100分">
                                    </div>
                                    <div class="row form-inline col-lg-6">
                                        <label class="form-control-label" for="2">专业与文化素质（70%）：</label>
                                        <input type="text" id="2" class="form-control col-lg-3" readonly="readonly" value="100分">
                                    </div>
                                    <div class="row form-inline col-lg-6">
                                        <label class="form-control-label" for="3">文体与身心素质（5%）：</label>
                                        <input type="text" id="3" class="form-control col-lg-3" readonly="readonly" value="100分">
                                    </div>
                                    <div class="row form-inline col-lg-6">
                                        <label class="form-control-label" for="4">创新与实践素质（10%）：</label>
                                        <input type="text" id="4" class="form-control col-lg-3" readonly="readonly" value="100分">
                                    </div>
                                    <div class="row form-inline col-lg-6">
                                        <label class="form-control-label" for="5">综合测评总分：</label>
                                        <input type="text" id="5" class="form-control col-lg-3" readonly="readonly" value="100分">
                                    </div>
                                </form>
                            </div>
                            <div class="card-footer">
                            </div>
                        </div>--%>

                </div>
            </div>
        </div>
        <%--END MAIN CONTENT--%>

        <div class="row">
            <div class="col-md-12">
                <div class="copyright">

                </div>
            </div>
        </div>
    </div>

</div>


<!-- Jquery JS-->
<script src="vendor/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JS-->
<script src="vendor/bootstrap-4.1/popper.min.js"></script>
<script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
<!-- Vendor JS       -->
<script src="vendor/slick/slick.min.js">
</script>
<script src="vendor/wow/wow.min.js"></script>
<script src="vendor/animsition/animsition.min.js"></script>
<script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
</script>
<script src="vendor/counter-up/jquery.waypoints.min.js"></script>
<script src="vendor/counter-up/jquery.counterup.min.js">
</script>
<script src="vendor/circle-progress/circle-progress.min.js"></script>
<script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="vendor/chartjs/Chart.bundle.min.js"></script>
<script src="vendor/select2/select2.min.js">
</script>

<!-- Main JS-->
<script src="js/main.js"></script>
<script src="js/script.js"></script>

<script type="text/javascript">
    $(function () {
        //load();
        //alert("test");
        $.post("/permission/findMenus.do", function (data) {
            //alert("test");
            //alert(data);
            let list = "";
            for (let key in data) {
                //alert(key + ":" + data[key]);
                let firstmMenu = data[key];
                list += '<li class="has-sub">' +
                    '<a class="js-arrow" href="#">' +
                    '<i class="fas '+ firstmMenu[0]["logo"] +'"></i>'+ key +'</a>' +
                    '<ul class="list-unstyled navbar__sub-list js-sub-list">';
                for (let i = 0; i < firstmMenu.length; i++) {
                    let secondMenu = firstmMenu[i];
                    list += '<li> <a class="js_test" href="javascript:;" id="'+ secondMenu["menu_id"] +'">'+ secondMenu["menuName"] +'</a></li>'
                }
                list += '</ul> </li>';
                //alert(list);
            }
            //alert(list);
            $("#sidebar").html(list);
        });

    });

</script>


</body>
</html>
