package Repositorio;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import AtendimentoHospitalar.Usuario;
import ConexaoBanco.Conexao;

public class UsuarioRepositorio implements ControleDeDados<Usuario>{

	@Override
	public void Insert(Usuario usuario) {

		String sql = null;
		
		Conexao con = new Conexao();
		
		try {
			con.AlterandoDadosSQL(sql);
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
		}catch(Exception e){
			e.getMessage();
		}
		  
	}

	@Override
	public void Update(String sql) {
		
		Conexao con = new Conexao();
		
		try {
			con.AlterandoDadosSQL(sql);
			JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso!");
		}catch(Exception e){
			e.getMessage();
		}
		  
		
	}

	@Override
	public void Delete(String sql) {

		Conexao con = new Conexao();
		
		try {
			con.AlterandoDadosSQL(sql);
			JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
		}catch(Exception e){
			e.getMessage();
		}
		  
		
	}

	@Override
	public ArrayList<Usuario> List(String sql) {
		
		Conexao con = new Conexao();
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			
			ResultSet rs = con.Buscar(sql);
				 
			while( rs.next())
			{
			    Usuario usuario = new Usuario();
			    
			    usuario.setLogin( rs.getString( "Login_user" ) );
			    usuario.setSenha( rs.getString( "Senha" ) );
			    usuario.setCPF_Paciente( rs.getString( "CPF_Paciente" ) );
			    usuario.setCPF_Profissional(rs.getString("CPF_Profissional"));
			   

			    usuarios.add( usuario );
			}
			
			return usuarios;
		
		}catch(Exception e){
			e.getMessage();
		}		
		
		return null;
	}
	
	
}
