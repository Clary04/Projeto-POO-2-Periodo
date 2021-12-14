package AtendimentoHospitalar;

public abstract class Grupo {
	
	protected String CPF, Nome, Email, Telefone;
	protected int Idade;
	
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		this.Telefone = telefone;
	}
	public int getIdade() {
		return Idade;
	}
	public void setIdade(int idade) {
		this.Idade = idade;
	}
	
}
