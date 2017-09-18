package com.oficina.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class ConexaoComponente {
	
	private final static Log LOG = LogFactory.getLog(ConexaoComponente.class ); 
	
	
	public Connection obterConexaoJDBC() {
		
		try {
			
			
			
			//return DriverManager.getConnection("jdbc:mysql://localhost/bd_oficina?useSSL=false", "root", "senharoot" );
			
			//via banco nuvem
			return DriverManager.getConnection("jdbc:mysql://us-cdbr-iron-east-05.cleardb.net/heroku_fa3e0d6879b26f7?reconnect=true", "b5d5378030c6dd", "046740c1" );
		
		} catch (SQLException e) {
			LOG.error("Erro ao obter conexão JDBC");
			LOG.error("Código de erro: " + e.getErrorCode() );
			LOG.error("Causa do erro: " + e.getCause() );
			LOG.error("Mensagem de erro: " + e.getMessage() );
			
			throw new RuntimeException(e );
		}
	}	


}