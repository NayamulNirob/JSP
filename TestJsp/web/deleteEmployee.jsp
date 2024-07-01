<jsp:useBean class="dao.Employee" id="e"/>
<%@page  import="dao.EmployeeDou" %>
<jsp:setProperty name="e" property="*" />


<%
    EmployeeDou.deleteEmployee(e);
    response.sendRedirect("viewallemployee.jsp");

%>