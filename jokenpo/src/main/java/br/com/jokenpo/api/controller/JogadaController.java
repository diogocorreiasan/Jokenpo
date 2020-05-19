package br.com.jokenpo.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jokenpo.domain.model.Jogada;
import br.com.jokenpo.domain.service.JogadaService;

@RestController
@RequestMapping(value = "/jogada")
public class JogadaController {
	 
	@Autowired
	private JogadaService jogadaService;
	
	@GetMapping
	private ResponseEntity<?> listar() {
		List<Jogada> jogadas = jogadaService.buscar();
		return ResponseEntity.ok(jogadas);
	}
	
	@PostMapping("/jogar")
	private ResponseEntity<?> cadastar(@RequestBody List<Jogada> jogadas) {
		Jogada jogadaVencedora = jogadaService.jogar(jogadas);
		
		if(jogadaVencedora == null) {
			return ResponseEntity.ok("Jogo empatado");
		}
		
		return ResponseEntity.ok(jogadaVencedora);
	}
	
	@DeleteMapping("/{id}")
	private void deletar(@PathVariable Long id) {
		try {
			jogadaService.excluir(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}