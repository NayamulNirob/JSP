<%@page import="model.Teacher" %>
<%@page import="dao.TeacherDao" %>

<%
String id=request.getParameter("id");    
    Teacher s=TeacherDao.getById(Integer.parseInt(id));
%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Teacher Update From</h1>

        <form action="updateteacher.jsp" method="post">
            <input type="hidden" name="id" value="<%=s.getId()%>">
            Name: <input type="text" name="name" value="<%=s.getName()%>"> <br>
            
            <div class="form-group">
                <label for="department">Department:</label>
                <select name="department" id="department" class="form-control">
                    <option value="">Please Select</option>
                    <option value="Java" <%= "Java".equals(s.getDepartment()) ? "selected" : "" %>>Java</option>
                    <option value="C#" <%= "C#".equals(s.getDepartment()) ? "selected" : "" %>>C#</option>
                </select>
            </div><br>
            
            Gender:
            <input type="radio" name="gender" value="Male" <%= "Male".equals(s.getGender()) ? "checked" : "" %> /> Male
            <input type="radio" name="gender" value="Female" <%= "Female".equals(s.getGender()) ? "checked" : "" %> /> Female
            <input type="radio" name="gender" value="Others" <%= "Others".equals(s.getGender()) ? "checked" : "" %> /> Others
            <br>

            

            <input type="submit" value="Edit">
        </form>

    </body>
</html>