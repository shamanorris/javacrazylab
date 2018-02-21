package test.jaxb;

import java.util.List;

public class Documento {

	private String codDocumento;
	private List<Proprieta> proprieta;
	private String autore;
	private String type;
	private String url;
	public String getCodDocumento() {
		return codDocumento;
	}
	public void setCodDocumento(String codDocumento) {
		this.codDocumento = codDocumento;
	}
	public List<Proprieta> getProprieta() {
		return proprieta;
	}
	
	public void setProprieta(List<Proprieta> proprieta) {
		this.proprieta = proprieta;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
