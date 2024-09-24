<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
        integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container my-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow-sm">
                    <div class="card-body py-4">
                        <h1 class="text-center mb-4">LOGIN</h1>
                        <form action="${pageContext.request.contextPath}/login" method="POST">
                            <c:if test="${alert != null}">
                                <div class="alert alert-danger text-center">${alert}</div>
                            </c:if>
                            <div class="mb-3">
                                <label for="username" class="form-label">Tên đăng nhập</label>
                                <input type="text" name="username" id="username" class="form-control" required>
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Mật khẩu</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <div class="form-check">
                                    <input type="checkbox" class="form-check-input" id="rememberMe">
                                    <label class="form-check-label" for="rememberMe">Nhớ tôi</label>
                                </div>
                                <a href="${pageContext.request.contextPath}/forget_password" class="text-danger">Quên mật khẩu?</a>
                            </div>
                            <button type="submit" class="btn btn-primary w-100">Login</button>
                        </form>
                        <hr class="my-4">
                        <div class="text-center">
                            <h5>Bạn chưa có tài khoản? 
                                <a href="${pageContext.request.contextPath}/register" class="text-primary"><b>Đăng ký</b></a>
                            </h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="/ltw05/login" method="post">

		<h2>Login</h2>
		<c:if test="${alert != null}">
			<h3 class="alert alert-danger">${alert}</h3>
		</c:if>

		<div class="container">
			<label for="username"><b>User Name</b></label> <input type="text"
				placeholder="Enter Username" name="username" required> <label
				for="password"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" required>

			<button type="submit">Login</button>

			<!-- Register button that redirects to register.jsp -->
			<button type="button"
				onclick="window.location.href='<%=request.getContextPath()%>/views/register.jsp';">
				Register</button>

			<label> <input type="checkbox" checked="checked"
				name="remember"> Remember me
			</label>
		</div>

		<div class="container" style="background-color: #f1f1f1">
			<button type="button" class="cancelbtn">Cancel</button>
			<span class="password"> <a
				href="<%=request.getContextPath()%>/views/forget_password.jsp">Forgot
					Password?</a>
			</span>
		</div>
	</form>
>>>>>>> 33b0958cd7eea6bca183618b81c6e2cc4d85b5be
</body>
</html>
