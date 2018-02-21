package test.jaxb;

public class Proprieta {

	private String nome;
	private String valore;
	private String tipo;
	
	public Proprieta(){
		
	}
	
	public Proprieta(String nome, String valore, String tipo){
		this.nome = nome;
		this.valore = valore;
		this.tipo = tipo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValore() {
		return valore;
	}
	public void setValore(String valore) {
		this.valore = valore;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
