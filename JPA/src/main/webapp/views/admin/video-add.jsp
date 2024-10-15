<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<form action="${pageContext.request.contextPath }/admin/video/insert"
	method="post" enctype="multipart/form-data">

	<label for="title">Title :</label><br> <input type="text"
		id="title" name="title"><br> <label for="poster">Poster
		:</label><br> <input type="file" id="poster" name="poster"
		accept="image/*" onchange="previewImage(event)"><br> <img
		id="imagePreview" src="" alt="Image Preview"
		style="max-width: 300px; margin-top: 10px;"><br> <label
		for="description">Description:</label><br> <input type="text"
		id="description" name="description"><br> <label
		for="active">Active:</label><br> <input type="text" id="active"
		name="active"><br> <label for="views">Views:</label><br>
	<input type="number" id="views" name="views" min="0" value="0"><br>
	<br> <input type="submit" value="Submit">
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
