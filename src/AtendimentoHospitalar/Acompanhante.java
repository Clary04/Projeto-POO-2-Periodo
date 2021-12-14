package AtendimentoHospitalar;

import java.util.ArrayList;

import Repositorio.ControleDeDados;

public class Acompanhante {

	private String CPF, Nome, Parentesco, CPF_Paciente;

	public Acompanhante(String cPF, String nome, String parentesco, String CPF_Paciente) {
		this.CPF = cPF;
		this.Nome = nome;
		this.Parentesco = parentesco;
		this.CPF_Paciente = CPF_Paciente;
	}

	public Acompanhante() {

	}

	public String getCPF_Paciente() {
		return CPF_Paciente;
	}

	public void setCPF_Paciente(String cPF_Paciente) {
		CPF_Paciente = cPF_Paciente;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		this.CPF = cPF;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public String getParentesco() {
		return Parentesco;
	}

	public void setParentesco(String parentesco) {
		this.Parentesco = parentesco;
	}

}
