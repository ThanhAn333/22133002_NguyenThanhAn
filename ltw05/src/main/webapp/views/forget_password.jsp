<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quên Mật Khẩu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container my-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow-sm">
                    <div class="card-body py-4">
                        <h1 class="text-center mb-4">Quên Mật Khẩu</h1>
                        <p>Vui lòng nhập địa chỉ email hoặc số điện thoại để khôi phục mật khẩu của bạn.</p>
                        <hr>

                        <!-- Hiển thị thông báo lỗi nếu có -->
                        <c:if test="${not empty alert}">
                            <div class="alert alert-danger">${alert}</div>
                        </c:if>

                        <!-- Form yêu cầu khôi phục mật khẩu -->
                        <form action="<%= request.getContextPath() %>/forget_password" method="post">
                            <div class="mb-3">
                                <label for="email" class="form-label"><b>Email</b></label>
                                <input type="text" placeholder="Nhập Email" name="email" id="email" class="form-control" required>
                            </div>
                            <hr>
                            <button type="submit" class="btn btn-primary w-100">Gửi Yêu Cầu</button>
                        </form>

                        <div class="text-center mt-4">
                            <p>Nhớ mật khẩu? <a href="<%= request.getContextPath() %>/login" class="text-primary"><b>Đăng nhập</b></a>.</p>
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
