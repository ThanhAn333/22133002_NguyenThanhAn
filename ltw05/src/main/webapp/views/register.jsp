<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container my-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow-sm">
                    <div class="card-body py-4">
                        <h1 class="text-center mb-4">Register</h1>
                        <form action="<%= request.getContextPath() %>/register" method="post">
                            <p class="text-center">Please fill in this form to create an account.</p>
                            <hr>

                            <!-- Display error alert if present -->
                            <c:if test="${not empty alert}">
                                <div class="alert alert-danger">${alert}</div>
                            </c:if>

                            <!-- Email Input -->
                            <div class="mb-3">
                                <label for="email" class="form-label"><b>Email</b></label>
                                <input type="email" placeholder="Enter Email" name="email" id="email" class="form-control" required>
                            </div>

                            <!-- Username Input -->
                            <div class="mb-3">
                                <label for="username" class="form-label"><b>Username</b></label>
                                <input type="text" placeholder="Enter Username" name="username" id="username" class="form-control" required>
                            </div>

                            <!-- Password Input -->
                            <div class="mb-3">
                                <label for="password" class="form-label"><b>Password</b></label>
                                <input type="password" placeholder="Enter Password" name="password" id="password" class="form-control" required>
                            </div>

                            <!-- Phone Input -->
                            <div class="mb-3">
                                <label for="phone" class="form-label"><b>Phone</b></label>
                                <input type="text" placeholder="Enter Phone Number" name="phone" id="phone" class="form-control" required>
                            </div>

                            <!-- Full Name Input -->
                            <div class="mb-3">
                                <label for="fullname" class="form-label"><b>Full Name</b></label>
                                <input type="text" placeholder="Enter Full Name" name="fullname" id="fullname" class="form-control" required>
                            </div>

                            <hr>

                            <p>By creating an account, you agree to our <a href="#">Terms and Privacy</a>.</p>
                            <button type="submit" class="btn btn-success w-100">Register</button>
                        </form>
                        
                        <div class="text-center mt-4">
                            <p>Already have an account? <a href="<%= request.getContextPath() %>/login" class="text-primary"><b>Sign in</b></a>.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>
