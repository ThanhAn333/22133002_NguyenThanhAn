<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Quên Mật Khẩu</title>
    <style>
        .container {
            padding: 16px;
        }
        .submit {
            background-color: blue;
            color: white;
            padding: 10px;
            border: none;
            cursor: pointer;
        }
        .login {
            text-align: center;
            margin-top: 20px;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Quên Mật Khẩu</h1>
        <p>Vui lòng nhập địa chỉ email hoặc số điện thoại để khôi phục mật khẩu của bạn.</p>
        <hr>

        <!-- Hiển thị thông báo nếu có lỗi -->
        <c:if test="${not empty alert}">
            <div class="error">${alert}</div>
        </c:if>

        <!-- Form yêu cầu khôi phục mật khẩu -->
        <form action="<%= request.getContextPath() %>/forget_password" method="post">
            <label for="email"><b>Email</b></label>
            <input type="text" placeholder="Nhập Email" name="email" id="email" required>
            <hr>
            <button type="submit" class="submit">Gửi Yêu Cầu</button>
        </form>

        <div class="login">
            <p>Nhớ mật khẩu? <a href="<%= request.getContextPath() %>/login">Đăng nhập</a>.</p>
        </div>
    </div>
</body>
</html>
