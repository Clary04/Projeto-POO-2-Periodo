package Repositorio;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import AtendimentoHospitalar.Acompanhante;
import ConexaoBanco.Conexao;

public class AcompanhanteRepositorio implements ControleDeDados<Acompanhante> {

	@Override
	public void Insert(Acompanhante acompanhante) {

		String sql = "Insert into Acompanhante values("+"'"+acompanhante.getCPF()+"'" + "," + "'"+acompanhante.getNome()+"'" + ","
				+ "'"+acompanhante.getParentesco()+"'" + "," + "'"+acompanhante.getCPF_Paciente()+"'" + ");";
		
		Conexao con = new Conexao();

		try {
			con.AlterandoDadosSQL(sql);
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Override
	public void Update(String sql) {
		// TODO Auto-generated method stub

		Conexao con = new Conexao();

		try {
			con.AlterandoDadosSQL(sql);
			JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso!");
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Override
	public void Delete(String sql) {
		// TODO Auto-generated method stub
		Conexao con = new Conexao();

		try {
			con.AlterandoDadosSQL(sql);
			JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Override
	public ArrayList List(String sql) {
		// TODO Auto-generated method stub
		
		Conexao con = new Conexao();

		ArrayList<Acompanhante> acompanhantes = new ArrayList<Acompanhante>();

		try {
			ResultSet rs = con.Buscar(sql);

			while (rs.next()) {
				Acompanhante ac = new Acompanhante();

				ac.setCPF(rs.getString("CPF"));
				ac.setNome(rs.getString("Nome"));
				ac.setParentesco(rs.getString("Parentesco"));
				ac.setCPF_Paciente(rs.getString("CPF_do_Paciente"));
				
				acompanhantes.add(ac);
			}

			return acompanhantes;

		} catch (Exception e) {
			e.getMessage();
		}

		return null;
	}

}
