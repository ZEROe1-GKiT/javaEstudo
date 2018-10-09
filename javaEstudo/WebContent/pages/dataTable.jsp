<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>DataTable jQuery</title>

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.js"></script>
	
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	
</head>
<body>
	<table id="example" class="display" style="width: 100%">
		<thead>
			<tr>
				<th>ID</th>
				<th>Login</th>
				<th>Nome</th>
				<th>Senha</th>
				<th>Telefone</th>
			</tr>
		</thead>
<!-- <tfoot>
			<tr>
				<th>Name</th>
				<th>Position</th>
				<th>Office</th>
				<th>Age</th>
				<th>Start date</th>
				<th>Salary</th>
			</tr>
		</tfoot> -->
	</table>
		<table id="pegasus" class="display" style="width: 100%">
		<thead>
			<tr>
				<th>Código</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Senha</th>
				<th>Status</th>
			</tr>
		</thead>
		</table>
</body>
<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": "carregarDadosDataTable"
    } );
} );

$(document).ready(function() {
    $('#pegasus').DataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": "carregarDadosDataTable2"
    } );
} );
</script>
</html>