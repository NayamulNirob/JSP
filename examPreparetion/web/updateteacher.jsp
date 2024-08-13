<jsp:useBean class="model.Teacher" id="e"/>
<%@page  import="dao.TeacherDao" %>
<jsp:setProperty name="e" property="*" />


<%
        TeacherDao.updateTeacher(e);
    
        response.sendRedirect("viewallteacher.jsp");
%>
