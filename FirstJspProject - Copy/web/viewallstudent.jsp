<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Student" %>
<%@page import="dao.StudentDao" %>
<%@page import="java.util.*" %>




<%

List<Student> list= StudentDao.viewAllStudent();
request.setAttribute("list",list);

%>

<table border="1" >
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Subject</th>
            <th>Action</th>
        </tr>
    </thead>

    <tbody>

        <c:forEach var="s" items="${list}">
            <tr>
                <td>${s.getId()}</td>
                <td>${s.getName()}</td>
                <td>${s.getEmail()}</td>
                <td>${s.getgender()}</td>
                <td>${s.getsubject()}</td>
                <td>
                    
                    
                    <a href="deletestudent.jsp?id=${s.getId()}">Delete</a>
                    <a href="updatestudentfrom.jsp?id=${s.getId()}">Edit</a>
                </td>
            </tr>

        </c:forEach>

    </tbody>   

</table>
