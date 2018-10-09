<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<h1>Página Pai - Load jQuery</h1>
	<br />
	<input type="button" value="Carregar Página" onclick="carregar();">

	<div id="carregarPaginaFilha"></div>
</body>
<script type="text/javascript">
	function carregar() {
$("#carregarPaginaFilha").load("paginaFilha.jsp");
	}
</script>
</html>