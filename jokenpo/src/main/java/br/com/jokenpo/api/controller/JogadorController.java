package br.com.jokenpo.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jokenpo.domain.model.Jogador;
import br.com.jokenpo.domain.service.JogadorService;

@RestController
@RequestMapping(value = "/jogador")
public class JogadorController {

	@Autowired
	private JogadorService jogadorService;
	
	@GetMapping
	private ResponseEntity<?> listar() {
		List<Jogador> jogadores = null;
		
		try {
			jogadores = jogadorService.buscar();
			
		} catch (IOException e) {
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return ResponseEntity.ok(jogadores);
	}
	
	@PostMapping()
	private ResponseEntity<?> cadastar(@RequestBody Jogador request) throws IOException {
		Jogador jogador = jogadorService.cadastrar(request);
		return ResponseEntity.ok(jogador);
	}
	
	@DeleteMapping("/{id}")
	private void deletar(@PathVariable Long id) throws IOException {
		jogadorService.excluir(id);
	}
	
}
