<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Files</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<h1>Upload Files</h1>
	<input type="file" id="file" name="file" onchange="uploadFile();">
	<img alt="Imagem" src="" id="target" width="200" height="200">
</body>
<script type="text/javascript">
	function uploadFile() {

		var target = document.querySelector("img");
		var file = document.querySelector("input[type=file]").files[0];

		var reader = new FileReader();

		reader.onloadend = function() {

			target.src = reader.result;
			
			$.ajax({
				method : "POST",
				url : "fileUpload",
				data : {
					fileUpload : reader.result
				}
			}).done(function(response) {
				alert("Sucesso: " + response);
			}).fail(function(xhr, status, errorThrow) {
				alert("Error: " + xhr.responseText);
			});

		};

		if (file) {

			reader.readAsDataURL(file);

		} else {
			target.src = "";
		}
	}
</script>
</html>