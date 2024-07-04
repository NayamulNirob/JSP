<jsp:useBean class="modle.Student" id="s"/>
<%@page import="dao.StudentDao"%>
<jsp:setProperty name="s" property="*"></jsp:setProperty>



<%

StudentDao.deleteStudent(s);
response.sendRedirect("viewallstudent.jsp");

%>
