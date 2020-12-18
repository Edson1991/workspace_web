package br.com.edsoncorp.dashcard.dao;
import org.springframework.data.repository.CrudRepository;

import br.com.edsoncorp.dashcard.model.Usuario;


// Classe que faz a manipulação de dados no BD ---> DAO significa "Data Access Object"
// Crud = Create, Read, Update e Delete
	public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	
/* Este metodo "findByEmailAndSenha" segue a estretegia QueryMethodName, ou seja, se seguirmos o padrão do JPA ele irá 
 * decodificar este metodo da seguinte forma:
 * find by =: select
 * Email and Senha = where email = ? and senha = ?
 * onde email e senha são as variaveis que corresponde a coluna da tabela "tbl_usuario", conforme Usuario.java
 * */	

	//Procura por email OU racf
	public Usuario findByEmailOrRacf(String email, String racf); // O JPA vai fazer a busca automaticamente e "retorna um objeto do tipo Usuario"
	//Procura por email E senha
	public Usuario findByEmailAndSenha(String email, String senha); 
	//Grava novo user
	public Usuario save(Usuario novo);

}
