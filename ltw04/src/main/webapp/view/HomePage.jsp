<%@ page import="ltw04.Models.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            color: #333;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }
        h2 {
            margin: 0;
            color: #007bff;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 15px;
            color: #fff;
            background-color: #007bff;
            text-decoration: none;
            border-radius: 4px;
        }
        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <%
            User user = (User) session.getAttribute("user");
            if (user != null) {
        %>
            <h2>Welcome, <%= user.getUserName() %>!</h2>
        <%
            } else {
        %>
            <h2>Welcome, Guest!</h2>
        <%
            }
        %>
       <a href="<%= request.getContextPath() %>/Logout">Logout</a>
    </div>
</body>
</html>
