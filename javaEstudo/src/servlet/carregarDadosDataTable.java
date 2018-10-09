package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUsuario;
import entidades.Usuarios;

@WebServlet("/pages/carregarDadosDataTable")
public class carregarDadosDataTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoUsuario daoUsuario = new DaoUsuario();

	public carregarDadosDataTable() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			List<Usuarios> usuarios = daoUsuario.getUsuarios();

			if (!usuarios.isEmpty()){
				
				String data = "";
				int totalUsuarios = usuarios.size();
				int index = 1;
				
				for (Usuarios usuario : usuarios) {
					
					data += "["+
							"\""+usuario.getId()+"\"," + 
							"\""+usuario.getLogin()+"\"," + 
							"\""+usuario.getNome()+"\","+ 
							"\""+usuario.getSenha()+"\"," + 
							"\""+usuario.getTelefone()+"\"" + 
							"]";
					if (index < totalUsuarios){
						data += ",";
					}
					index++;
				}
				
			String json = 
					"{" + "\"draw\": 1," + 
					"\"recordsTotal\": "+usuarios.size()+","+
					"\"recordsFiltered\": "+usuarios.size()+"," + 
					"\"data\": [" +data+ "]" + 
					"}";

			response.setStatus(200);
			response.getWriter().write(json);
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
