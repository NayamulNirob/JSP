<jsp:useBean class="modle.Student" id="e"/>


<%@page  import="dao.StudentDao" %>

<jsp:setProperty name="e" property="*" />


<%
int i=StudentDao.saveStudent(e);

    if(i>0){
        response.sendRedirect("success.jsp");
    }
    else{
    response.sendRedirect("error.jsp");
    }
%>