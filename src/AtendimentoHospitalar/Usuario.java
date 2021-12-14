package AtendimentoHospitalar;

public class Usuario {

	private String Login, Senha, CPF_Paciente, CPF_Profissional;

	public Usuario(String Login, String Senha, String CPF_Paciente, String CPF_Profissional) {
		this.CPF_Paciente = CPF_Paciente;
		this.CPF_Profissional = CPF_Profissional;
		this.Login = Login;
		this.Senha = Senha;
	}

	public Usuario() {
		
	}
	
	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public String getCPF_Paciente() {
		return CPF_Paciente;
	}

	public void setCPF_Paciente(String cPF_Paciente) {
		CPF_Paciente = cPF_Paciente;
	}

	public String getCPF_Profissional() {
		return CPF_Profissional;
	}

	public void setCPF_Profissional(String cPF_Profissional) {
		CPF_Profissional = cPF_Profissional;
	}

	

}
