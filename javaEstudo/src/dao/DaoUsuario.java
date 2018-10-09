package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDataBase;
import entidades.Usuarios;

public class DaoUsuario {

	private Connection connection;

	public DaoUsuario() {
		connection = ConnectionDataBase.getConnection();
	}

	public List<Usuarios> getUsuarios() throws Exception {
		List<Usuarios> usuarios = new ArrayList<Usuarios>();

		String sql = "select * from usuario order by id ";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			Usuarios usuario = new Usuarios();
			usuario.setId(resultSet.getLong("id"));
			usuario.setLogin(resultSet.getString("login"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setSenha(resultSet.getString("senha"));
			usuario.setTelefone(resultSet.getString("telefone"));

			usuarios.add(usuario);

		}

		return usuarios;
	}
}
