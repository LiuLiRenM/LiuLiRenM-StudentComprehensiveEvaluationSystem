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

        <!-- MAIN CONTENT-->
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid" id="content">

                    <div class="card">
                        <div class="card-header">
                            <strong>添加学生信息</strong>
                        </div>
                        <div class="card-body card-block">
                            <form action="${pageContext.request.contextPath}/index.jsp" method="post" class="form-group">
                                <div class="form-group">
                                    <label for="studentName" class="pr-1  form-control-label">学生姓名</label>
                                    <input type="text" id="studentName"  required="required" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="studentEmail" class="px-1  form-control-label">Email</label>
                                    <input type="email" id="studentEmail"  required="required" class="form-control">
                                </div>
                                <button type="submit" class="btn btn-primary btn-sm">
                                    <i class="fa fa-dot-circle-o"></i> Submit
                                </button>
                            </form>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-header">
                            <strong>添加专业信息</strong>
                        </div>
                        <div class="card-body card-block">
                            <form action="/menus/saveProfessionName.do" method="post" class="form-inline">
                                <div class="form-group">
                                    <label for="professionName" class="pr-1  form-control-label">专业名称</label>
                                    <input type="text" id="professionName"  name="professionName" required="required" class="form-control">
                                </div>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                                <label for="collegeName" class="pr-1  form-control-label">所属系别</label>
                                <div class="rs-select2--dark rs-select2--md m-r-10 rs-select2--border">
                                    <select class="js-select2" name="property">
                                        <option selected="selected">请选择系别</option>
                                        <option value="">Products</option>
                                        <option value="">Services</option>
                                    </select>
                                    <div class="dropDownSelect2"></div>
                                </div>
                                <button type="submit" class="btn btn-primary btn-sm">
                                    <i class="fa fa-dot-circle-o"></i> 保存
                                </button>
                            </form>
                        </div>
                    </div>

                    <div class="card">
                        <div class="card-header">
                            <strong>综合测评项管理</strong>
                        </div>
                        <div class="card-body card-block">
                            <form action="${pageContext.request.contextPath}/index.jsp" method="post" class="form-group">
                                <div class="form-inline">
                                    <label for="collegeName" class="pr-1  form-control-label">专业名称</label>
                                    <input type="text" id="collegeName"  required="required" class="form-control">
                                </div>
                                <label for="collegeName" class="pr-1  form-control-label">所属系别:</label>
                                <div class="rs-select2--dark rs-select2--md m-r-10 rs-select2--border">
                                    <select class="js-select2" name="property">
                                        <option selected="selected">请选择系别</option>
                                        <option value="">Products</option>
                                        <option value="">Services</option>
                                    </select>
                                    <div class="dropDownSelect2"></div>
                                </div>
                                <button type="submit" class="btn btn-primary btn-sm">
                                    <i class="fa fa-dot-circle-o"></i> 保存
                                </button>
                            </form>
                        </div>
                    </div>

                    <div class="card">
                        <div class="card-header">
                            <strong>添加系别信息</strong>
                        </div>
                        <div class="card-body card-block">
                            <form action="" method="post" class="form-inline">
                                <div class="form-group">
                                    <label for="exampleInputName2" class="pr-1  form-control-label">系别名称</label>
                                    <input type="text" id="exampleInputName2" placeholder="Jane Doe" required="" class="form-control">
                                </div>
                            </form>
                        </div>
                        <div class="card-footer">
                            <button type="submit" class="btn btn-primary btn-sm">
                                <i class="fa fa-dot-circle-o"></i> 保存
                            </button>

                        </div>
                    </div>
                </div>

                </div>

            </div>

        </div>
        <!-- END MAIN CONTENT-->

            <div class="row">
                <div class="col-md-12">
                    <div class="copyright">

                    </div>
                </div>
            </div>
    </div>
    <!-- END PAGE CONTAINER-->

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
