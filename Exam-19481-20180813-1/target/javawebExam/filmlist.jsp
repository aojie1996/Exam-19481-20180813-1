<%--
  Created by IntelliJ IDEA.
  User: aojie
  Date: 2018/8/13
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,dao.beanCl"  pageEncoding="UTF-8"%>
<%@ page import="model.Film" %>
<html>
<head>
    <title>电影列表页面</title>
    <script>
        function confirms() {
            return window.confirm("确定要删除吗")
        }
    </script>
</head>
<body>
欢迎您，<p style="color: red"><%=(String)session.getAttribute("userName")%><p/><br>
<a href="index.jsp">返回主界面</a>
<br>
<%
   beanCl bl = new beanCl();
    ArrayList<Object> alist=bl.getFilms();
%>
<center>
    <font size=5>电影列表</font><br>
    <table width="1200">
        <tr>
            <td><a href="addFilms.jsp">新増电影信息</a></td>
        </tr>
    </table>
    <hr width="1200" >
    <table width="1200">
        <tr>
            <td>电影序号</td>
            <td>标题</td>
            <td>描述</td>
            <td style="size:20px">语言</td>
            <td>修改电影</td>
            <td>删除电影</td>
        </tr>
        <%
            String color[]={"snow","grey"};
            for (int i=0;i<alist.size();i++){
                Film film = (Film) alist.get(i);
        %>
        <tr bgcolor="<%=color[i%2]%>" height="50">
            <td><%=film.getFilm_id()%></td>
            <td><%=film.getTitle()%></td>
            <td><%=film.getDescription()%></td>
            <td><%=film.getLanguageName()%></td>
            <td>
                <a href="updateFilms.jsp?filmId=<%=film.getFilm_id()%>&filmTitle=<%=film.getTitle()%>&filmdescription=<%=film.getDescription()%>&filmLanguage=<%=film.getLanguageName()%>">更新</a>
            </td>
            <td>
                <a onclick="return confirms()" href="FilmServlet?flag=delete&film_id=<%=film.getFilm_id()%>">删除</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</center>
</body>
</html>
