package AtendimentoHospitalar;

import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ConexaoBanco.Conexao;

public class Profissional extends Grupo {

	private String Codigo, DataNascimento;
	
	public Profissional(String DataNascimento, String Codigo) {
		this.DataNascimento = DataNascimento;
		this.Codigo = Codigo;
	}
	
	public Profissional() {
		
	}

	public String getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		DataNascimento = dataNascimento;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	
}
