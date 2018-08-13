<%--
  Created by IntelliJ IDEA.
  User: aojie
  Date: 2018/8/13
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>
<body bgcolor="#CED3FE">
<center>
    <h1>电影租赁系统</h1>
    <hr>
    <form action="FilmServlet?flag=login" method="post"><br>
        用户名：<input type="text" name="username"/><br>
        <p></p>
        <input type="submit" value="登录" style="padding: 10px 20px 10px 20px">
    </form>
</center>
</body>
</html>
