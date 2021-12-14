package AtendimentoHospitalar;

public class Enfermeiro extends Profissional {

	private String CIF;
	
	public Enfermeiro(String CPF, String DataNascimento, String Codigo, String CIF) {
		super(DataNascimento, Codigo);
		this.CIF = CIF;
		this.CPF = CPF;
		// TODO Auto-generated constructor stub
	}

	public Enfermeiro() {
		
	}
	
	public String getCIF() {
		return CIF;
	}

	public void setCIF(String CIF) {
		this.CIF = CIF;
	}

}
