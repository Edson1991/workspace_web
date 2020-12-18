package br.com.edsoncorp.dashcard.controller;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.edsoncorp.dashcard.dao.AgenteFinanceiroDAO;
import br.com.edsoncorp.dashcard.model.AgenteFinanceiro;

@RestController // @RestController Torna a sua classe (UsuarioController) de forma publica/exposta na internet, usando o "CTRL+SHIFT+O" para fazer o import da "org.springframework.web.binf.annotation.RestController"
@CrossOrigin("*") // o CrossOrigin informa que ele podera receber acesso do agente especifico que está no (), como está *, aceita de qq agente
public class AgenteFinanceiroController {

	@Autowired
	AgenteFinanceiroDAO dao;

	@GetMapping("/agentes") // GetMapping serve para fazer chamadas via url -> Qnd vc digitar a localhost:8080/agentes, vai chamar o metodo recuperarAgentes
	public ArrayList<AgenteFinanceiro> recuperarAgentes(){
		ArrayList<AgenteFinanceiro> lista;
		lista = dao.findAllByOrderByVolumeDesc(); // findAllByOrder é um metodo que vem do CrudRepository
		return lista;
	}
	
	@PostMapping("/novoagente")
	public ResponseEntity<AgenteFinanceiro> adicionarNovoAgente(@RequestBody AgenteFinanceiro novo) {
		try {
			dao.save(novo);
			return ResponseEntity.status(201).body(novo);
		}
		catch(Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
	
}