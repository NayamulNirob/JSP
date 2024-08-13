<jsp:useBean class="model.Teacher" id="s"/>
<%@page import="dao.TeacherDao"%>
<jsp:setProperty name="s" property="*"></jsp:setProperty>


<%

int i=TeacherDao.saveTeacher(s);

if(i>0){
    
response.sendRedirect("success.jsp");
}
else{
    
 response.sendRedirect("error.jsp");   
}   


%>