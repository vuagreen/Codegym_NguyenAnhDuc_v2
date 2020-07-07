<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 15/04/2020
  Time: 1:27 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="/save">
    <input type="checkbox" id="vehicle1" name="condiment" value="Bike">
    <label for="vehicle1"> I have a bike</label><br>
    <input type="checkbox" id="vehicle2" name="condiment" value="Car">
    <label for="vehicle2"> I have a car</label><br>
    <input type="checkbox" id="vehicle3" name="condiment" value="Boat">
    <label for="vehicle3"> I have a boat</label><br>
    <input type="checkbox" id="vehicle4" name="condiment" value="Boat">
    <label for="vehicle3"> I have a boat</label><br>
    <input type="submit" id="save" value="Save">
  </form>
  </body>
</html>
