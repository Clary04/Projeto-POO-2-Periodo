package ConexaoBanco;

import java.sql.*;

public class Conexao {
	private String url, usuario, senha;
	private Connection con;
	
	
	public Conexao() {
		url = "jdbc:postgresql://localhost:5432/AtendimentoHospitalar";
		usuario = "postgres";
		senha = "admin123";
	
		try {
			
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, senha);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void AlterandoDadosSQL(String sql) {
		
		try {
			
			Statement stm = con.createStatement();
			int res = stm.executeUpdate(sql);
			con.close();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ResultSet Buscar(String sql) {
		
		try {
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			con.close();
			
			return rs;
			
		}catch(Exception e) {
			e.getMessage();
			return null;
		}
	}

}
