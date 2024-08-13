<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Teacher" %>
<%@page import="dao.TeacherDao" %>
<%@page import="java.util.*" %>




<%

List<Teacher> list= TeacherDao.viewAllTeacher();
request.setAttribute("list",list);

%>

<table border="1" >
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Department</th>
            <th>Gender</th>
            <th>Action</th>
        </tr>
    </thead>

    <tbody>

        <c:forEach var="t" items="${list}">
            <tr>
                <td>${t.getId()}</td>
                <td>${t.getName()}</td>
                <td>${t.getDepartment()}</td>
                <td>${t.getGender()}</td>
                <td>
                    
                    
                    <a href="deleteteacher.jsp?id=${t.getId()}">Delete</a>
                    <a href="updateteacherfrom.jsp?id=${t.getId()}">Edit</a>
                </td>
            </tr>

        </c:forEach>

    </tbody>   

</table>
