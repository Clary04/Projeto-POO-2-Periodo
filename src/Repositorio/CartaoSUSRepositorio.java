package Repositorio;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import AtendimentoHospitalar.CartaoSUS;
import ConexaoBanco.Conexao;

public class CartaoSUSRepositorio implements ControleDeDados<CartaoSUS> {

	@Override
	public void Insert(CartaoSUS cartao) {
		
		String sql = "Insert into Cartao_SUS values ('"+cartao.getNumero_SUS()+"',"+"'"+cartao.getSexo()+"'"+",'"+cartao.getData_nascimento()+"','"+cartao.getCPF()+"');";
		System.out.println(sql);
		Conexao con = new Conexao();

		try {
			con.AlterandoDadosSQL(sql);
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
	public ArrayList List(String sql) {

		Conexao con = new Conexao();

		ArrayList<CartaoSUS> cartoes = new ArrayList<CartaoSUS>();

		try {
			
			ResultSet rs = con.Buscar(sql);

			while (rs.next()) {
				
				CartaoSUS cartao = new CartaoSUS();

				cartao.setNumero_SUS(rs.getString("Numero_SUS"));
				cartao.setSexo(rs.getString("Sexo"));
				cartao.setData_nascimento(rs.getString("Data_de_Nascimento"));
				cartao.setCPF(rs.getString("CPF_Paciente"));
				
				cartoes.add(cartao);
			}

			return cartoes;

		} catch (Exception e) {
			e.getMessage();
		}

		return null;
	}

}
