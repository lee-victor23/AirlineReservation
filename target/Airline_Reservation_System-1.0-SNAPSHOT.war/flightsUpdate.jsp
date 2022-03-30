
<%@ page import="com.example.airline_reservation_system.model.entity.Aircraft" %>
<%@ page import="com.example.airline_reservation_system.model.entity.Flight" %><%--
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
    Flight flight = (Flight) request.getAttribute("flight");
%>
<form action="FlightsController" method="post">
    <table>

        <tr>
            <td>Flight ID</td>
            <td>
                <input type="text" name="flight_id" readonly value="<%=flight.getId()%>" />

            </td>
        </tr>

        <tr>
            <td>Flight No</td>
            <td>
                <input type="text" name="flight_no" value="<%=flight.getFlightNo()%>" />
            </td>
        </tr>

        <tr>
            <td>Scheduled Departure</td>
            <td>
                <input type="text" name="scheduled_departure" value="<%=String.valueOf(flight.getScheduledDeparture())%>" />
            </td>
        </tr>
        <tr>
            <td>Scheduled Arrival</td>
            <td>
                <input type="text" name="scheduled_arrival" value="<%=String.valueOf(flight.getScheduledDeparture())%>" />
            </td>
        </tr>
        <tr>
            <td>Departure airport</td>
            <td>
                <input type="text" name="departure_airport" value="<%=flight.getAirportsData().getId()%>" />

            </td>
        </tr>
        <tr>
            <td>Arrival airport</td>
            <td>
                <input type="text" name="arrival_airport" value="<%=flight.getAirportsData1().getId()%>" />
            </td>
        </tr>
        <tr>
            <td>Status</td>
            <td>
                <input type="text" name="status" value="<%=flight.getStatus()%>" />
            </td>
        </tr>
        <tr>
            <td>Aircraft code</td>
            <td>
                <input type="text" name="aircraft_code" value="<%=flight.getAircraftsData().getId()%>" />
            </td>
        </tr>
        <tr>
            <td>Actual Departure</td>
            <td>
                <input type="text" name="actual_departure" value="<%=String.valueOf(flight.getActualDeparture())%>" />
            </td>
        </tr>
        <tr>
            <td>Actual Arrival</td>
            <td>
                <input type="text" name="actual_arrival" value="<%=String.valueOf(flight.getActualDeparture())%>" />
            </td>
        </tr>


    </table>
    <input type="submit" name="UPDATE" value="UPDATE"/>
    <input type="submit" name="DELETE" value="DELETE"/>
</form>


</body>
</html>
