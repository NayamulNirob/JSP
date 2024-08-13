<jsp:useBean class="model.Teacher" id="s"/>
<%@page import="dao.TeacherDao"%>
<jsp:setProperty name="s" property="*"></jsp:setProperty>



<%

TeacherDao.deleteTeacher(s);
response.sendRedirect("viewallteacher.jsp");

%>