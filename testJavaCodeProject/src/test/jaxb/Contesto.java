package test.jaxb;

public class Contesto {
	private String guid;
	private String abi;
	private String matricola;
	private String codRichiedente;
	private DataEsecuzione dataEsecuzione;
	private String puntoOperativo;
	
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getAbi() {
		return abi;
	}
	public void setAbi(String abi) {
		this.abi = abi;
	}

	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getCodRichiedente() {
		return codRichiedente;
	}
	public void setCodRichiedente(String codRichiedente) {
		this.codRichiedente = codRichiedente;
	}

	public DataEsecuzione getDataEsecuzione() {
		return dataEsecuzione;
	}
	public void setDataEsecuzione(DataEsecuzione dataEsecuzione) {
		this.dataEsecuzione = dataEsecuzione;
	}
	public String getPuntoOperativo() {
		return puntoOperativo;
	}
	public void setPuntoOperativo(String puntoOperativo) {
		this.puntoOperativo = puntoOperativo;
	}

	
}
