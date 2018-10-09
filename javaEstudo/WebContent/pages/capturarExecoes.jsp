<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Capturar Exceções</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<h3>Capturando Exceções com JQuery</h3>
	<input type="text" value="Valor Informado" id="testeval">
	<input type="button" onclick="testarExcecao();" value="Testar Exceção">
</body>
<script>
	function testarExcecao() {

		valorInformado = ($('#testeval').val());

		$.ajax({

			method : "POST",
			url : "capturarExecoes",
			data : {
				valorParam : valorInformado
			}
		})

		.done(function(response) {
			alert("Sucesso: " + response);
		})
		.fail(function(xhr, status, errorThrown) {
			alert("Erro: " + xhr.responseText);
		});
	}
</script>
</html>