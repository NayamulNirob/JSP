

<jsp:useBean class="dao.Employee" id="s"/>
<%@page  import="dao.EmployeeDou" %>
<jsp:setProperty name="s" property="*" />

<%
int i= EmployeeDou.saveEmployee(s);

if(i>0){
response.sendRedirect("success.jsp");
}
else{
response.sendRedirect("error.jsp");
}

%>
</html>
