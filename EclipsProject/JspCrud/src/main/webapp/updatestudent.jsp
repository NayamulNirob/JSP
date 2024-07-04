<jsp:useBean class="modle.Student" id="e"/>
<%@page  import="dao.StudentDao" %>
<jsp:setProperty name="e" property="*" />


<%
StudentDao.updateStudent(e);
    
        response.sendRedirect("viewallstudent.jsp");
%>