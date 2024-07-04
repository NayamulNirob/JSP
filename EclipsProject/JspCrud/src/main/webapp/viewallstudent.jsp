<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="modle.Student" %>
<%@page import="dao.StudentDao" %>
<%@page import="java.util.*" %>


<%
    List<Student> list= StudentDao.viewAllStudent();
    request.setAttribute("list", list);

%>
<jsp:include page="header.jsp"></jsp:include>

<div class="Container">


<h1 class="text-center">All Student</h1>



<table class="table">
  <thead>
  
      <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Cell</th>
            <th scope="col">Action</th>
        </tr>
    
    
  </thead>
  <tbody>
    
    
    <c:forEach var="s" items="${list}">
            <tr>
                <td>${s.getId()}</td>
                <td>${s.getName()}</td>
                <td>${s.getEmail()}</td>
                <td>${s.getAddress()}</td>
                <td>${s.getCell()}</td>
                <td>
                    <a href="updatestudentfrom.jsp?id=${s.getId()}">Edit</a>
                    <a href="deletestudent.jsp?id=${s.getId()}">Delete</a>
                </td>
            </tr>

        </c:forEach>
  </tbody>
</table>



















</div>













<jsp:include page="footer.jsp"></jsp:include>

