package AtendimentoHospitalar;

import java.util.ArrayList;

public class Coordenador extends Profissional {

	private String Departamento;

	public Coordenador(String CPF, String DataNascimento, String Codigo, String Departamento) {
		super(DataNascimento, Codigo);
		this.Departamento = Departamento;
		this.CPF = CPF;
	}
	
	public Coordenador() {
		
	}

	public String getDepartamento() {
		return Departamento;
	}

	public void setDepartamento(String departamento) {
		this.Departamento = departamento;
	}

}
