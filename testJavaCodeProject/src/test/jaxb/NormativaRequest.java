package test.jaxb;

import java.util.List;

public class NormativaRequest {
	private Contesto contesto;
	private List<Proprieta> proprieta;
	private List<Documento> documento;
	
	public List<Proprieta> getProprieta() {
		return proprieta;
	}
	
	public void setProprieta(List<Proprieta> proprieta) {
		this.proprieta = proprieta;
	}

	public Contesto getContesto() {
		return contesto;
	}

	public void setContesto(Contesto contesto) {
		this.contesto = contesto;
	}

	public List<Documento> getDocumento() {
		return documento;
	}
	
	public void setDocumento(List<Documento> documento) {
		this.documento = documento;
	}

	
	
}
