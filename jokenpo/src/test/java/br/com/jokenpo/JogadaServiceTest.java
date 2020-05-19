package br.com.jokenpo;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.jokenpo.domain.model.Jogada;
import br.com.jokenpo.domain.model.Jogador;
import br.com.jokenpo.domain.repository.GenericRepository;
import br.com.jokenpo.domain.repository.JogadaRepository;
import br.com.jokenpo.domain.service.JogadaService;
import br.com.jokenpo.service.config.JokenpoResultado;

class JogadaServiceTest {
	
	private JogadaService jogadaService = new JogadaService(
			new GenericRepository() , new JogadaRepository(), new JokenpoResultado());

	@Test
	void testBuscar() {
		assertNotNull(jogadaService.buscar());
	}

	@Test
	void testJogar() {
		
		List<Jogada> jogadas = new ArrayList<>();
		
		Jogador jogador1 = new Jogador();
		jogador1.setNome("Diogo");
		
		Jogada play1 = new Jogada();
		play1.setId(1L);
		play1.setJogador(jogador1);
		play1.setJokenpoItem("PapeL");
		
		Jogador jogador2 = new Jogador();
		jogador2.setNome("Pedro");
		
		Jogada play2 = new Jogada();
		play2.setId(2L);
		play2.setJogador(jogador2);
		play2.setJokenpoItem("tesOura");
		
		Jogador jogador3 = new Jogador();
		jogador3.setNome("Luiz");
		
		Jogada play3 = new Jogada();
		play3.setId(3L);
		play3.setJogador(jogador3);
		play3.setJokenpoItem("Pedra");
		
		jogadas.add(play1);
		jogadas.add(play2);
		jogadas.add(play3);
		
		assertEquals(play3, jogadaService.jogar(jogadas)); 
	}

}