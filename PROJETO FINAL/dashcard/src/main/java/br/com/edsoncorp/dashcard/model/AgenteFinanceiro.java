package br.com.edsoncorp.dashcard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Quando usamos @Entity indicamos que a classe é armazenavel em BD
@Table(name = "mtb310_ag_financeiro") // quando usamos @Table informamos a tabela respectiva no BD
public class AgenteFinanceiro {
	
	@Id // informa que é chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoincremento
	@Column(name="id_agente") //correlação com a tabela no BD
	private int id;
	
	@Column(name="nome_agente", length = 100)
	private String nome;
	
	@Column(name="volume_transacional")
	private float volume;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}
	

}
