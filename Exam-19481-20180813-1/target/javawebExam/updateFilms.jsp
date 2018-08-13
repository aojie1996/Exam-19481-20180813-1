<%--
  Created by IntelliJ IDEA.
  User: aojie
  Date: 2018/8/13
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新电影信息</title>
</head>
<body>
<a href="main.jsp">返回主界面</a>
<center>
    <font size=5>修改电影的信息</font><br>
    <hr width="1000">
    <form action="FilmServlet?flag=update" method="post">
        <table width="1000" height="400">
            <tr>
                <td>序号</td>
                <td><input type="text" name="filmId" readonly="readonly" value="<%=request.getParameter("filmId")%>"/></td>
            </tr>
            <tr>
                <td>标题</td>
                <td><input type="text" name="filmTitle" size="50" value="<%=request.getParameter("filmTitle")%>"/></td>
            </tr>
            <tr>
                <td>内容</td>
                <td><input type="text" name="filmdescription" size="70" value="<%=request.getParameter("filmdescription")%>"/></td>
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
                <td colspan="2" ><input type="submit" value="确定修改"/>&nbsp; <input type="reset" value="重置"/></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
