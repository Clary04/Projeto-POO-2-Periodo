package Repositorio;

import java.sql.ResultSet;
import java.util.ArrayList;

import AtendimentoHospitalar.Medico;
import ConexaoBanco.Conexao;

import javax.swing.JOptionPane;

public class MedicoRepositorio implements ControleDeDados<Medico> {
	
	@Override
	public void Insert(Medico medico) {

		String sql = "Insert into Medico values(" + "'"+medico.getCPF()+"'" + "," + "'"+medico.getCodigo()+"'" + ","
				+ "'"+medico.getDataNascimento()+"'" + "," + "'"+medico.getCRM()+"'" + ");";
		
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
	public ArrayList< Medico> List(String sql) {
		
		Conexao con = new Conexao();
		
		ArrayList< Medico>  medicos = new ArrayList< Medico>();
		
		try {
			
			ResultSet rs = con.Buscar(sql);
				 
			while( rs.next())
			{
				 Medico medico = new Medico();
			
				 medico.setCPF( rs.getString( "CPF" ) );
				 medico.setCRM(rs.getString( "CRM" ));

				medicos.add( medico );
			}
			
			return  medicos;
		
		}catch(Exception e){
			e.getMessage();
		}		
		
		return null;
	}
	
	
	
}
