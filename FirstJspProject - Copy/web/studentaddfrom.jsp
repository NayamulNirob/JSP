
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Student From</h1>

        <form action="savestudent.jsp" method="post">

            Name: <input type="text" name="name"> <br>
            Email:<input type="email" name="email"> <br>
            Gender:
            <input type="radio" name="gender" value="Male">Male
            <input type="radio" name="gender" value="Female">Female
            <input type="radio" name="gender" value="Others">Others<br>
            <div class="form-group">
                <label for="subject">Subject</label>
                <select name="subject" id="subject" class="form-control">
                    <option value="">Please Select</option>
                    <option value="Java">Java</option>
                    <option value="C#">C#</option>
                </select>
            </div>


            <input type="submit" value="Save">
        </form>

    </body>
</html>