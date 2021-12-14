package Repositorio;

import java.sql.ResultSet;
import java.util.ArrayList;
import AtendimentoHospitalar.Profissional;
import javax.swing.JOptionPane;

import ConexaoBanco.Conexao;

public class ProfissionalRepositorio implements ControleDeDados<Profissional>{

	@Override
	public void Insert(Profissional profissional) {

		String sql = "Insert into Profissional (CPF, Nome, Data_de_Nascimento, Codigo) values ('"+profissional.getCPF()+"','"+profissional.getNome()+"','"+profissional.getDataNascimento()+"','"+profissional.getCodigo()+"');"
				+ " \n"
				+ "Insert into Email_Profissional values ('"+profissional.getCPF()+"','"+profissional.getEmail()+"');"
				+ "\n"
				+ "Insert into Telefone_Profissional values('"+profissional.getCPF()+"','"+profissional.getTelefone()+"');";
		
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
	public ArrayList<Profissional> List(String sql) {
		
		Conexao con = new Conexao();
		
		ArrayList<Profissional> profissionais = new ArrayList<Profissional>();
		
		try {
			ResultSet rs = con.Buscar(sql);
				 
			while( rs.next())
			{
			    Profissional p = new Profissional();
			    
			    p.setCPF( rs.getString( "CPF" ) );
			    p.setNome( rs.getString( "Nome" ) );
			    p.setDataNascimento( rs.getString( "DataNascimento" ) );
			    p.setCodigo(rs.getString("Codigo"));
			   
			    profissionais.add( p );
			}
			
			return profissionais;
		
		}catch(Exception e){
			e.getMessage();
		}		
		
		return null;
	}
	
	
}
