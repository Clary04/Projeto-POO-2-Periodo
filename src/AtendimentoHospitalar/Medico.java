package AtendimentoHospitalar;

public class Medico extends Profissional {

	private String CRM;

	public Medico(String CPF, String DataNascimento, String Codigo, String CRM) {
		super(DataNascimento, Codigo);
		this.CRM = CRM;
		this.CPF = CPF;
		// TODO Auto-generated constructor stub
	}
	
	public Medico() {
		
	}

	public String getCRM() {
		return CRM;
	}

	public void setCRM(String cRM) {
		this.CRM = cRM;
	}

}
