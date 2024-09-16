<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forget Password</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
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
            width: 350px;
            text-align: center;
        }
        h2 {
            margin-bottom: 20px;
            color: #007bff;
        }
        label, input {
            display: block;
            width: 100%;
            margin-bottom: 10px;
            text-align: left;
        }
        input[type="text"] {
            padding: 10px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        p {
            margin-top: 15px;
        }
        .error {
            color: red;
        }
        .message {
            color: green;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Forget Password</h2>
        <form action="ForgetPassword" method="post">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required>
            <button type="submit">Submit</button>
        </form>
        <p class="message"><%= request.getAttribute("message") %></p>
    </div>
</body>
</html>
