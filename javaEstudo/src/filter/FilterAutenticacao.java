package filter;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import user.userLogado;
import connection.ConnectionDataBase;
import connection.ConnectionDataBasePegasus;

@WebFilter(urlPatterns = { "/pages/*" })
public class FilterAutenticacao implements Filter {

	private static Connection connection;
	private static Connection connectionPegasus;


	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		String urlParaAutenticar = req.getServletPath();

		userLogado userLogado = (userLogado) session.getAttribute("usuario");

		if (userLogado == null
				&& !urlParaAutenticar
						.equalsIgnoreCase("/pages/servletAutenticacao")) {

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/autenticar.jsp?url="
							+ urlParaAutenticar);
			dispatcher.forward(request, response);
			return;
		}

		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		connection = ConnectionDataBase.getConnection();
		connectionPegasus = ConnectionDataBasePegasus.getConnection();
	}

}
