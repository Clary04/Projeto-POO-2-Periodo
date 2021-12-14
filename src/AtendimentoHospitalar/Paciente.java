package AtendimentoHospitalar;

import java.util.ArrayList;

public class Paciente extends Grupo{

	private String DataNascimento, HistoricoHospitalar, Latitude, Longitude;
	private int triagemID;

	public Paciente(String DataNascimento, String HistoricoHospitalar, String Latitude, String Longitude, int TriagemID) {
		this.DataNascimento = DataNascimento;
		this.HistoricoHospitalar = HistoricoHospitalar;
		this.Longitude = Longitude;
		this.Latitude = Latitude;
		this.triagemID = TriagemID;
	}

	public Paciente() {
		
	}
	
	public int getTriagemID() {
		return triagemID;
	}

	public void setTriagemID(int triagemID) {
		this.triagemID = triagemID;
	}

	public String getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		DataNascimento = dataNascimento;
	}

	public String getHistoricoHospitalar() {
		return HistoricoHospitalar;
	}

	public void setHistoricoHospitalar(String historicoHospitalar) {
		HistoricoHospitalar = historicoHospitalar;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

}
