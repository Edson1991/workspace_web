package br.com.edsoncorp.dashcard.dto;

// DTO  - Data Transfer Object - Objetos derivados de objetos puros que são criados para "views mais elaboradas"

public class ConsolidadoStatus {
	private String nomeAgente;
	private float volume;
	private int status;
	private long numeroOp; // obrigatorio ser "long" qnd temos contagem de registros no BD.
	
	
	//Obrigatorio ter construtor nas classes que são 
	
	public ConsolidadoStatus(String nomeAgente, float volume, int status, long numeroOp) {
		super();
		this.nomeAgente = nomeAgente;
		this.volume = volume;
		this.status = status;
		this.numeroOp = numeroOp;
	}
		
		
	public String getNomeAgente() {
		return nomeAgente;
	}
	public void setNomeAgente(String nomeAgente) {
		this.nomeAgente = nomeAgente;
	}
	public float getVolume() {
		return volume;
	}
	public void setVolume(float volume) {
		this.volume = volume;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getNumeroOp() {
		return numeroOp;
	}
	public void setNumeroOp(long numeroOp) {
		this.numeroOp = numeroOp;
	}
	
	

}
