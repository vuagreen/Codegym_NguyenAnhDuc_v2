<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete customer</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/customers">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><a type="text" name="name" id="name" >${requestScope["customers"].getName()}</a></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><a type="text" name="email" id="email" value="">${requestScope["customers"].getEmail()}</a></td>

            </tr>
            <tr>
                <td>Address: </td>
                <td><a type="text" name="address" id="address" value="">${requestScope["customers"].getAddress()}</a>

                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Delete customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>