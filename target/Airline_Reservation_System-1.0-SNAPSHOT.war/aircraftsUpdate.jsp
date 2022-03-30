<%@ page import="com.example.airline_reservation_system.model.entity.Aircraft" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 14/2/2022
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Updating Records</title>

  <style>
    table {
      font-family: arial, sans-serif;
      border-collapse: collapse;
      width: 100%;
    }

    td, th {
      border: 1px solid #dddddd;
      text-align: left;
      padding: 8px;
    }

    tr:nth-child(even) {
      background-color: #dddddd;
    }
  </style>

</head>
<body>
<%
  Aircraft aircraft = (Aircraft) request.getAttribute("aircraft");
%>
<form action="AircraftController" method="post">
  <table>

    <tr>
      <td>Aircraft Code</td>
      <td>
        <input type="text" name="aircraftCode" readonly value="<%=aircraft.getId()%>" />
      </td>
    </tr>

    <tr>
      <td>Range</td>
      <td>
        <input type="text" name="range" value="<%=aircraft.getRange()%>" />
      </td>
    </tr>

    <tr>
      <td>Model</td>
      <td>
        <input type="text" name="model" value="<%=aircraft.getModel()%>" />
      </td>
    </tr>


  </table>
  <input type="submit" name="UPDATE" value="UPDATE"/>
  <input type="submit" name="DELETE" value="DELETE"/>
</form>


</body>
</html>
