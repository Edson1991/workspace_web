package br.com.edsoncorp.dashcard.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.edsoncorp.dashcard.dto.ConsolidadoStatus;
import br.com.edsoncorp.dashcard.model.Transacao;

public interface TransacaoDAO extends CrudRepository <Transacao, Integer> {
	
	
	
	@Query("SELECT new br.com.edsoncorp.dashcard.dto.ConsolidadoStatus(t.agente.nome, t.agente.volume, t.status, count(t.status))"
			+ " FROM Transacao t WHERE t.agente.id=:idAgente GROUP BY t.status")	
	public ArrayList<ConsolidadoStatus> recuperarStatus(@Param("idAgente") int idAgente);
	


}
