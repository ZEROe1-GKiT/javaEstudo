package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDataBasePegasus;
import entidades.UsuariosPegasus;

public class DaoUsuarioPegasus {

	private Connection connection;

	public DaoUsuarioPegasus() {
		connection = ConnectionDataBasePegasus.getConnection();
	}

	public List<UsuariosPegasus> getUsuarios() throws Exception {
		List<UsuariosPegasus> usuarios = new ArrayList<UsuariosPegasus>();

		String sql = "select * from erp_usuario where status <> 'I' order by cod_usuario ";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			UsuariosPegasus usuario = new UsuariosPegasus();
			usuario.setCod_usuario(resultSet.getLong("cod_usuario"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setSenha(resultSet.getString("senha"));
			usuario.setStatus(resultSet.getString("status"));

			usuarios.add(usuario);

		}

		return usuarios;
	}
}
