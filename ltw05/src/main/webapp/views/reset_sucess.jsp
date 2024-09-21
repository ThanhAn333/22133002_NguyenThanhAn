<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đổi mật khẩu thành công</title>
    <style>
        .container {
            padding: 16px;
            text-align: center;
        }
        .back-login {
            background-color: green;
            color: white;
            padding: 10px;
            border: none;
            cursor: pointer;
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Đổi mật khẩu thành công!</h1>
        <p>Mật khẩu của bạn đã được thay dổi. Vui lòng đăng nhập lại.</p>

        <!-- Nút quay lại đăng nhập -->
        <form action="<%= request.getContextPath() %>/login" method="get">
            <button type="submit" class="back-login">Quay lại đăng nhập</button>
        </form>
    </div>

</body>
</html>
