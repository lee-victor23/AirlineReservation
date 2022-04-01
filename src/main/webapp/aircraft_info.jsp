<%@ page import="com.example.airline_reservation_system.model.entity.Aircraft" %><%--
  Created by IntelliJ IDEA.
  User: spiri
  Date: 31/3/2022
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Aircraft</title>

<style>
    body {
        font-family: Arial, Helvetica, sans-serif;
    }

    * {
        box-sizing: border-box;
    }

    /* Button used to open the contact form - fixed at the bottom of the page */
    .open-button {
        background-color: #555;
        color: white;
        padding: 16px 20px;
        border: none;
        cursor: pointer;
        opacity: 0.8;
        position: fixed;
        bottom: 23px;
        right: 28px;
        width: 280px;
    }

    /* The popup form - hidden by default */
    .form-popup {
        overflow-x: hidden;
        overflow-y: auto;
        height: 400px;
        display: none;
        position: fixed;
        top: 60%;
        left: 50%;
        -webkit-transform: translate(-50%, -50%);
        transform: translate(-50%, -50%);
    }

    /* Add styles to the form container */
    .form-container {
        max-width: 500px;
        padding: 10px;
        background-color: white;
    }

    /* Full-width input fields */
    .form-container input[type=text], .form-container input[type=password] {
        width: 100%;
        padding: 15px;
        margin: 5px 0 22px 0;
        border: none;
        background: #f1f1f1;
    }

    /* When the inputs get focus, do something */
    .form-container input[type=text]:focus, .form-container input[type=password]:focus {
        background-color: #ddd;
        outline: none;
    }

    /* Set a style for the submit button */
    .form-container .btn {
        background-color: #4CAF50;
        color: white;
        padding: 16px 20px;
        border: none;
        cursor: pointer;
        width: 100%;
        margin-bottom: 10px;
        opacity: 0.8;
    }

    /* Add a red background color to the cancel button */
    .form-container .cancel {
        background-color: red;
    }

    /* Add some hover effects to buttons */
    .form-container .btn:hover, .open-button:hover {
        opacity: 1;
    }

    .pageref {
        text-align: center;
        font-weight: bold;
    }
</style>
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
</head>
<body class="m-3">

<div class="row col-md-6">
    <table class="table table-striped table-bordered table-sm">
        <tr>
            <th>Aircraft Code</th>
            <th>Range</th>
            <th>Model</th>
        </tr>
        <%

            Aircraft a = (Aircraft) request.getAttribute("aircraft");

            out.println("<tr>");
            out.println("<td>" + a.getId() + "</td>");
            out.println("<td>" + a.getRange() + "</td>");
            out.println("<td>" + a.getModel() + "</td>");
            out.println("</tr>");


        %>
    </table>
</div>

</body>
</html>
