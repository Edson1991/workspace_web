package br.com.edsoncorp.dashcard.controller;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.edsoncorp.dashcard.dao.UsuarioDAO;
import br.com.edsoncorp.dashcard.model.AgenteFinanceiro;
import br.com.edsoncorp.dashcard.model.Usuario;

@RestController // @RestController Torna a sua classe (UsuarioController) de forma publica/exposta na internet, usando o "CTRL+SHIFT+O" para fazer o import da "org.springframework.web.binf.annotation.RestController"
@CrossOrigin("*") // o Crossorigin informa que ele podera receber acesso de do agente especifico que está no (), como está *, aceita de qq agente
public class UsuarioController {

	/* @Autowired faz a "injeção de dependência". O que é isso?
	 * Basicamente delegamos a instanciação do objeto para a maquina virtual 
	 * (que em outras palavras é "NÃO precisar dar NEW na variavel "UsuarioDAO dao = new UsuarioDAO()")
	 * Mas o que acontece se nao tivermos um objeto que implementa a interface UsuarioDAO?
	 * A propria infra-estrutura do JPA (que é framework que possui o CrudRepository) 
	 * se encarrega de gerar uma implementação desse objeto.* 
	 *  */
	@Autowired 
	UsuarioDAO dao;
	
	@GetMapping("/todos") // GetMapping serve para fazer chamadas via url -> Qnd vc digitar a localhost:8080/todos, vai chamar o metodo recuperarTodos
	public ArrayList<Usuario> recuperarTodos(){	
		ArrayList<Usuario> lista;
		lista = (ArrayList<Usuario>)dao.findAll(); // findAll é um metodo que vem do CrudRepository
		return lista;
		
	}
	
	@PostMapping("/login") // PostMapping serve para o browser enviar informações para o backend
	public  ResponseEntity<Usuario> testandoUsuario(@RequestBody Usuario dadosLogin) { // ResponseEntity deixa vc manipular cabeçalho HTTP e receber o codigo de retono ( 200, 404, etc)
		/* Passo 1 - recuperar usuario email ou racf
		 * Passo 2 - se o usuario nao existir, retorno codigo 404(not found)
		 * passo 3 - se ele existir, vou conferir a senha
		 * passo 4 - se a senha nao coincidir, retorno codigo 401 (unauthorized)
		 * passo 5 - usuario existe e a senha coincide, retorno 200*/
		
		Usuario resultado = dao.findByEmailOrRacf(dadosLogin.getEmail(), dadosLogin.getRacf());
		if (resultado != null) {  // usuario existe
			// vou conferir a senha
			if (resultado.getSenha().equals(dadosLogin.getSenha())){
				return ResponseEntity.ok(resultado); // retorno ok "200"
			}
			else {
				//senha errada  - erro 401
				return ResponseEntity.status(401).build();
			}
		}
		else {
			// usuario errado - erro 404
			return ResponseEntity.notFound().build();
		}
					
	}
	
	@PostMapping("/novouser")
	public ResponseEntity<Usuario> adicionarNovoUsuario(@RequestBody Usuario novo) {
		try {
			dao.save(novo);
			
			return ResponseEntity.status(201).body(novo);
		}
		catch(Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
	
	
}
