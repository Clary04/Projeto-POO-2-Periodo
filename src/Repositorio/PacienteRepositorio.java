package Repositorio;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import AtendimentoHospitalar.Paciente;
import ConexaoBanco.Conexao;

public class PacienteRepositorio implements ControleDeDados<Paciente>{

	@Override
	public void Insert(Paciente paciente) {
	
		String sql = "Insert into Paciente (CPF, Nome, Data_de_Nascimento) values ('"+paciente.getCPF()+"','"+paciente.getNome()+"','"+paciente.getDataNascimento()+"');"
				+ " \n"
				+ "Insert into Email_Paciente values ('"+paciente.getCPF()+"','"+paciente.getEmail()+"');"
				+ "\n"
				+ "Insert into Telefone_Paciente values('"+paciente.getCPF()+"','"+paciente.getTelefone()+"');";
		
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
	public ArrayList<Paciente> List(String sql) {
		
		Conexao con = new Conexao();
		
		ArrayList<Paciente> profissionais = new ArrayList<Paciente>();
		
		try {
			ResultSet rs = con.Buscar(sql);
				 
			while( rs.next())
			{
			    Paciente p = new Paciente();
			    
			    p.setCPF( rs.getString( "CPF" ) );
			    p.setNome( rs.getString( "Nome" ) );
			    p.setDataNascimento( rs.getString( "DataNascimento" ) );
			    p.setHistoricoHospitalar(rs.getString("Historico_Hospitalar"));
			    p.setLatitude(rs.getString("Latitude"));
			    p.setLongitude(rs.getNString("Longitude"));
			    p.setTriagemID(rs.getInt("TriagemID"));
			    
			    profissionais.add( p );
			}
			
			return profissionais;
		
		}catch(Exception e){
			e.getMessage();
		}		
		
		return null;
	}
	
	
	
}
