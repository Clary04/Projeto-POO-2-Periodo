package AtendimentoHospitalar;

import java.util.ArrayList;

public class Atendente extends Profissional {

	private String Setor;

	public Atendente(String CPF, String DataNascimento, String Codigo, String Setor) {
		super(DataNascimento, Codigo);
		this.Setor = Setor;
		this.CPF = CPF;
		// TODO Auto-generated constructor stub
	}

	public Atendente() {
		
	}

	public String getSetor() {
		return Setor;
	}

	public void setSetor(String setor) {
		Setor = setor;
	}
	



}