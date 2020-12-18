package br.com.edsoncorp.dashcard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* Nesta classe Usuario, vamos criar uma estrutura "equivalente" a estrutura da tabela de usuarios (tbl_usuarios) do MySQL,
 * porem com as nosas nomenclaturas e nosso estilo de escrita
 * O segredo agora é fazer esse "De x Para" para a nossa tabela de usuário*/
 
@Entity // quando usamos @Entity indicamos que a classe é armazenavel em BD
@Table(name="tbl_usuario") // quando usamos @Table informamos a tabela do BD

public class Usuario {
	
	@Id // indica que é chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // faz o autoincremento, conforme tabela do BD
	@Column (name = "id_usuario") // @Column gera metainformações para cada atributo e refe-se as colunas da tabela do BD
	private int    id;
	
	@Column(name = "nome_usuario", length = 100, nullable = false) // @Column gera metainformações para cada atributo e refe-se as colunas da tabela
	private String nome;
	
	@Column(name = "email_usuario", length = 100, nullable = false, unique = true) 
	private String email;
	
	@Column(name = "racf_usuario", length = 7, nullable = false, unique = true)
	private String racf;
	
	@Column(name = "senha_usuario", length = 50, nullable = false)
	private String senha;
	
	@Column(name = "link_foto", length = 255)
	private String linkFoto;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRacf() {
		return racf;
	}

	public void setRacf(String racf) {
		this.racf = racf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	
	
	
}