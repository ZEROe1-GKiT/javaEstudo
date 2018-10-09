package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUsuarioPegasus;
import entidades.UsuariosPegasus;

@WebServlet("/pages/carregarDadosDataTable2")
public class carregarDadosDataTable2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoUsuarioPegasus daoUsuarioPegasus = new DaoUsuarioPegasus();

	public carregarDadosDataTable2() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			List<UsuariosPegasus> usuarios = daoUsuarioPegasus.getUsuarios();

			if (!usuarios.isEmpty()){
				
				String data = "";
				int totalUsuarios = usuarios.size();
				int index = 1;
				
				for (UsuariosPegasus usuario : usuarios) {
					
					data += "["+
							"\""+usuario.getCod_usuario()+"\"," + 
							"\""+usuario.getNome()+"\"," + 
							"\""+usuario.getEmail()+"\","+ 
							"\""+usuario.getSenha()+"\"," + 
							"\""+usuario.getStatus()+"\"" + 
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
