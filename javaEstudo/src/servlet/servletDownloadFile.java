package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.RelatorioService;
import dao.DaoUsuario;
import entidades.Usuarios;


@WebServlet("/pages/servletDownloadFile")
public class servletDownloadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 private RelatorioService relatorioService = new RelatorioService();
 
 private DaoUsuario daoUsuario = new DaoUsuario();
	
    public servletDownloadFile() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			
		ServletContext context = getServletContext();
			
		String tipoExportar = request.getParameter("tipoExportar");
		
		List<Usuarios> usuarios = daoUsuario.getUsuarios();
		
		List dados = new ArrayList();
		dados.add(usuarios);
		
		String fileUrl = relatorioService.gerarRelatorio(dados, new HashMap(), "rel_usuarios", "rel_usuarios", context);
		
		File fileDownload = new File(fileUrl);
		
		FileInputStream fileInputStream = new FileInputStream(fileDownload);
		
		String mimeType = context.getMimeType(fileUrl);
		
		if (mimeType == null){
			
			mimeType = "application/octet-stream";
		}
		
		response.setContentType(mimeType);
		response.setContentLength((int) fileDownload.length());
		
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment, filename=\"%$\"", fileDownload.getName());
		
		response.setHeader(headerKey, headerValue);
		
		OutputStream outputStream = response.getOutputStream();
		
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		
		while ((bytesRead = fileInputStream.read(buffer)) != -1){
			outputStream.write(buffer,0,bytesRead);
		}
		
		fileInputStream.close();
		outputStream.close();
		
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
