<%--
  Created by IntelliJ IDEA.
  User: aojie
  Date: 2018/8/13
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<html>
<head>
    <title>添加电影</title>
</head>
<body>
<a href="main.jsp">返回主界面</a>
<center>
    <font size=5>新增电影信息</font><br>
    <hr width="600">
    <form action="FilmServlet?flag=add" method="post">
        <table width="600" height="300">
            <tr>
                <td>电影id</td>
                <td><input type="text" name="filmId"/></td>
            </tr>
            <tr>
                <td>电影标题</td>
                <td><input type="text" size="50" name="filmTitle"/></td>
            </tr>
            <tr>
                <td>电影描述</td>
                <td><input type="text" size="70" name="filmdescription"/></td>
            </tr>
            <tr>
                <td>电影语言</td>
                <td>
                    <select name="filmLanguageId">
                        <option value="1">English</option>
                        <option value="2">Italian</option>
                        <option value="3">Japanese</option>
                        <option value="4">Mandarin</option>
                        <option value="5">French</option>
                        <option value="6">German</option>
                    </select>
                </td>
            </tr>
            <tr align="center" >
                <td colspan="2" ><input type="submit" value="确定"/>&nbsp; <input type="reset" value="重置"/></td>
            </tr>
        </table>
    </form>
</center>

</body>
</html>
