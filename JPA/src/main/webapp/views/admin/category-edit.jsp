<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<form action="${pageContext.request.contextPath }/admin/category/update"
	method="post" enctype="multipart/form-data">

	<input type="text" id="categoryId" name="categoryId"
		value="${cate.categoryId }" hidden="hidden"><br> <label
		for="fname">Category name:</label><br> <input type="text"
		id="categoryname" name="categoryname" value="${cate.categoryname }"><br>
	<label for="lname">Images:</label><br>
	<input type="file" id="images" name="images" accept="image/*" onchange="previewImage(event)"><br>
    
    <img id="imagePreview" src="" alt="Image Preview" style="max-width: 300px; margin-top: 10px;"><br>
	 <label
		for="status">Status:</label><br> <input type="text" id="status"
		name="status" value="${cate.status }"><br> <br> <input
		type="submit" value="Submit">
</form>
<script>
    function previewImage(event) {
        var imagePreview = document.getElementById('imagePreview');
        var file = event.target.files[0];
        
        if (file) {
            var reader = new FileReader();
            reader.onload = function(e) {
                imagePreview.src = e.target.result;
            };
            reader.readAsDataURL(file);
        }
    }
</script>