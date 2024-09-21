<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<style>
    /* Add some basic styling for better appearance */
    .container {
        padding: 16px;
    }
    .register {
        background-color: green;
        color: white;
        padding: 10px;
        border: none;
        cursor: pointer;
    }
    .signin {
        text-align: center;
        margin-top: 20px;
    }
</style>
</head>
<body>

    <form action="<%= request.getContextPath() %>/register" method="post">
        <div class="container">
            <h1>Register</h1>
            <p>Please fill in this form to create an account.</p>
            <hr>

            <!-- loi, nhap lai -->
            <c:if test="${not empty alert}">
                <div style="color: red;">${alert}</div>
            </c:if>
           

            <label for="email"><b>Email</b></label>
            <input type="email" placeholder="Enter Email" name="email" id="email" required>

            <label for="username"><b>User Name</b></label>
            <input type="text" placeholder="Enter User Name" name="username" id="username" required>

            <label for="password"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="password" id="password" required>

            
            <label for="phone"><b>Phone</b></label>
            <input type="text" placeholder="Enter Phone Number" name="phone" id="phone" required>
            
             <label for="fullname"><b>Full Name</b></label>
            <input type="text" placeholder="Enter Full Name" name="fullname" id="fullname" required>
            
            
            <hr>

            <p>By creating an account you agree to our <a href="#">Terms and Privacy</a>.</p>
            <button type="submit" class="register">Register</button>
        </div>

        <div class="container signin">
            <p>Already have an account? <a href="<%= request.getContextPath() %>/login">Sign in</a>.</p>
        </div>
    </form>

</body>
</html>
