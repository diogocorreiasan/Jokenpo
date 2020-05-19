package br.com.jokenpo;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import br.com.jokenpo.domain.model.Jogador;
import br.com.jokenpo.domain.repository.GenericRepository;
import br.com.jokenpo.domain.repository.JogadorRepository;
import br.com.jokenpo.domain.service.JogadorService;

class JogadorServiceTest {
	
	private JogadorService jogadorService = new JogadorService(new GenericRepository(), new JogadorRepository());
	
	@Test
	void testBuscar() throws IOException {
		assertNotNull(jogadorService.buscar());
	}

	@Test
	void testCadastrar() {
		Jogador jogador = new Jogador(2L, "Teste");
		assertEquals(jogador, jogador);
	}

}
