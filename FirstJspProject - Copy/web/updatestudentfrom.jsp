<%@page import="model.Student" %>
<%@page import="dao.StudentDao" %>

<%
String id=request.getParameter("id");    
    Student s=StudentDao.getById(Integer.parseInt(id));
%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Student Update From</h1>

        <form action="updatestudent.jsp" method="post">
            <input type="hidden" name="id" value="<%=s.getId()%>">
            Name: <input type="text" name="name" value="<%=s.getName()%>"> <br>
            Email:<input type="email" name="email" value="<%=s.getEmail()%>"> <br>
            
            Gender:
            <input type="radio" name="gender" value="Male" <%= "Male".equals(s.getgender()) ? "checked" : "" %> /> Male
            <input type="radio" name="gender" value="Female" <%= "Female".equals(s.getgender()) ? "checked" : "" %> /> Female
            <input type="radio" name="gender" value="Others" <%= "Others".equals(s.getgender()) ? "checked" : "" %> /> Others

            <div class="form-group">
                <label for="subject">Subject</label>
                <select name="subject" id="subject" class="form-control">
                    <option value="">Please Select</option>
                    <option value="Java" <%= "Java".equals(s.getsubject()) ? "selected" : "" %>>Java</option>
                    <option value="C#" <%= "C#".equals(s.getsubject()) ? "selected" : "" %>>C#</option>
                </select>
            </div>

            <input type="submit" value="Edit">
        </form>

    </body>
</html>