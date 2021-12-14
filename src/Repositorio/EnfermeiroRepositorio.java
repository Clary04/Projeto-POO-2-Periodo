package Repositorio;

import java.sql.ResultSet;
import java.util.ArrayList;

import AtendimentoHospitalar.Enfermeiro;
import ConexaoBanco.Conexao;

import javax.swing.JOptionPane;


public class EnfermeiroRepositorio implements ControleDeDados<Enfermeiro> {
	
	@Override
	public void Insert(Enfermeiro enfermeiro) {

		String sql = "Insert into Enfermeiro values(" +"'"+ enfermeiro.getCPF()+"'" + "," + "'"+enfermeiro.getCodigo()+"'" + ","
				+ "'"+enfermeiro.getDataNascimento()+"'" + "," + "'"+enfermeiro.getCIF()+"'" + ");";
		
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
	public ArrayList<Enfermeiro> List(String sql) {
		
		Conexao con = new Conexao();
		
		ArrayList<Enfermeiro> enfermeiros =new ArrayList<Enfermeiro>();
		
		try {
			ResultSet rs = con.Buscar(sql);
				 
			while( rs.next())
			{
				Enfermeiro enfermeiro= new Enfermeiro();
			
				enfermeiro.setCPF( rs.getString( "CPF" ) );
				enfermeiro.setCIF(rs.getString( "CIF" ));

				enfermeiros.add( enfermeiro );
			}
			
			return  enfermeiros;
		
		}catch(Exception e){
			e.getMessage();
		}		
		
		return null;
	}
}
	
