package AtendimentoHospitalar;

import java.util.ArrayList;

public class CartaoSUS {

	private String Numero_SUS;
	private String Sexo;
	private String Data_nascimento;
	private String CPF;
	

	public CartaoSUS(String numero_SUS, String sexo, String data_nascimento, String CPF) {
		super();
		Numero_SUS = numero_SUS;
		Sexo = sexo;
		Data_nascimento = data_nascimento;
		this.CPF = CPF;
	}

	public CartaoSUS() {
		
	}
	
	public String getNumero_SUS() {
		return Numero_SUS;
	}

	public void setNumero_SUS(String numero_SUS) {
		Numero_SUS = numero_SUS;
	}

	
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		this.Sexo = sexo;
	}

	public String getData_nascimento() {
		return Data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.Data_nascimento = data_nascimento;
	}

}
