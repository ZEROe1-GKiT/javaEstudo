<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Autenticar Usuário</title>
</head>
<body>
	<form action="servletAutenticacao" method="post" onsubmit="">
		<input readonly="readonly" type="hidden" id="url" name="url"
			value="<%=request.getParameter("url")%>"></input>
			
		<table style="background: #E8E8E8;">

			<tr>
				<td><label>Login:</label></td>
				<td><input type="text" id="login" name="login"
					style="border-radius: 5px;"></td>
			</tr>

			<tr>
				<td><label>Senha:</label></td>
				<td><input type="password" id="senha" name="senha"
					style="border-radius: 5px;"></td>
			</tr>

			<tr>
				<td />
				<td><input type="submit" id="logar" name="logar" value="Logar"
					style="width: 100%; border-radius: 5px;"></td>
			</tr>
		</table>
	</form>
</body>
</html>