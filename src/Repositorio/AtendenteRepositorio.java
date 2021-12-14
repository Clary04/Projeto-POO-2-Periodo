package Repositorio;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import AtendimentoHospitalar.Atendente;
import ConexaoBanco.Conexao;

public class AtendenteRepositorio implements ControleDeDados<Atendente> {

	@Override
	public void Insert(Atendente atendente) {

		String sql = "Insert into Atendente values(" + "'"+atendente.getCPF()+"'" + "," + "'"+atendente.getCodigo()+"'" + ","
				+ "'"+atendente.getDataNascimento()+"'" + "," + atendente.getSetor() + ");";

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

		Conexao con = new Conexao();

		try {
			con.AlterandoDadosSQL(sql);
			JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Override
	public ArrayList<Atendente> List(String sql) {

		Conexao con = new Conexao();

		ArrayList<Atendente> atendentes = new ArrayList<Atendente>();

		try {
			ResultSet rs = con.Buscar(sql);

			while (rs.next()) {
				Atendente atendente = new Atendente();

				atendente.setCPF(rs.getString("CPF"));
				atendente.setSetor(rs.getString("Setor"));

				atendentes.add(atendente);
			}

			return atendentes;

		} catch (Exception e) {
			e.getMessage();
		}

		return null;
	}
}
