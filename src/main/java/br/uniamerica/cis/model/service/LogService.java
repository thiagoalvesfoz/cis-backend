package br.uniamerica.cis.model.service;

import java.time.LocalDateTime;

import br.uniamerica.cis.model.entity.Log;
import br.uniamerica.cis.model.entity.Usuario;

public interface LogService {	
	default Log logRegister(Usuario user, String descricao) {
		return new Log(null, LocalDateTime.now(), descricao, user);
	}
}
