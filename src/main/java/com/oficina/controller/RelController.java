package com.oficina.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oficina.component.ConexaoComponente;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
@RequestMapping("/relatorios")
public class RelController {
	
	@Autowired
	private ConexaoComponente conexaoComponente;
	
	@GetMapping("/fabricantes/buscatodos")
    public void buscaFabricantes(HttpServletResponse respostaHttp) throws JRException, IOException, SQLException {
       
		InputStream jasperStream = this.getClass().getResourceAsStream("/Relatorios/fabricantes.jasper");
		  
	    Map<String,Object> params = new HashMap<>();
	    	     
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
	    
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,  obterConexaoJDBC() );

	    respostaHttp.setContentType("application/x-pdf");
	    respostaHttp.setHeader("Content-disposition", "inline; filename=relatorio-fabricantes.pdf");

	    final OutputStream outStream = respostaHttp.getOutputStream();
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	  }

	private Connection obterConexaoJDBC() throws SQLException {
		//return DriverManager.getConnection("jdbc:mysql://localhost/bookstore?useSSL=false", "root", "root" );
		
		return conexaoComponente.obterConexaoJDBC();
	}
}
