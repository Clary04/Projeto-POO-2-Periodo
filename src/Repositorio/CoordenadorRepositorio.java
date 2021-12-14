package Repositorio;

import java.sql.ResultSet;
import java.util.ArrayList;

import AtendimentoHospitalar.Coordenador;
import ConexaoBanco.Conexao;

import javax.swing.JOptionPane;

public class CoordenadorRepositorio implements ControleDeDados<Coordenador> {
	
	@Override
	public void Insert(Coordenador coordenador) {
		
		String sql = "Insert into Coordenador values(" +"'"+ coordenador.getCPF()+"'" + "," + "'"+coordenador.getCodigo()+"'" + ","
				+ "'"+coordenador.getDataNascimento()+"'" + "," + "'"+coordenador.getDepartamento()+"'" + ");";

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
	public ArrayList<Coordenador> List(String sql) {
		
		Conexao con = new Conexao();
		
		ArrayList<Coordenador> coordenadores =new ArrayList<Coordenador>();
		
		try {
			ResultSet rs = con.Buscar(sql);
				 
			while( rs.next())
			{
				Coordenador coordenador = new Coordenador();
			
				coordenador.setCPF( rs.getString( "CPF" ) );
				coordenador.setDepartamento(rs.getString( "Departamento" ));

				 coordenadores.add(  coordenador );
			}
			
			return  coordenadores;
		
		}catch(Exception e){
			e.getMessage();
		}		
		
		return null;
	}
	
	
}



