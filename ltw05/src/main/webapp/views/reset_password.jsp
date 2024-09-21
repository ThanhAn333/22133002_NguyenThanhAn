<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Khôi Phục Mật Khẩu</title>
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
        <h1>Khôi Phục Mật Khẩu</h1>
        <p>Vui lòng nhập mật khẩu mới của bạn.</p>
        <hr>

        <!-- Hiển thị thông báo nếu có lỗi -->
        <c:if test="${not empty alert}">
            <div class="error">${alert}</div>
        </c:if>

        <!-- Form khôi phục mật khẩu -->
        <form action="<%= request.getContextPath() %>/reset_password" method="post">
            <label for="password"><b>Mật Khẩu Mới</b></label>
            <input type="password" placeholder="Nhập Mật Khẩu Mới" name="password" id="password" required>

            <label for="confirmPassword"><b>Xác Nhận Mật Khẩu</b></label>
            <input type="password" placeholder="Xác Nhận Mật Khẩu Mới" name="confirmPassword" id="confirmPassword" required>
            <hr>

            <button type="submit" class="submit">Đặt lại Mật Khẩu</button>
        </form>

        <div class="login">
            <p>Đã khôi phục? <a href="<%= request.getContextPath() %>/login">Đăng nhập</a>.</p>
        </div>
    </div>
</body>
</html>
