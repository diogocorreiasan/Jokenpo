package br.com.jokenpo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.jokenpo.domain.model.Jogada;
import br.com.jokenpo.domain.model.Jogador;
import br.com.jokenpo.service.config.JokenpoResultado;

class JokenpoResultadoTest {
	
	private JokenpoResultado jokenpoResultado = new JokenpoResultado();

	@Test
	void testObterResultadoVitoriaPlay1() {
		
		Jogador jogador1 = new Jogador();
		jogador1.setNome("Diogo");
		
		Jogada play1 = new Jogada();
		play1.setId(2L);
		play1.setJogador(jogador1);
		play1.setJokenpoItem("pedra");
		
		Jogador jogador2 = new Jogador();
		jogador2.setNome("Pedro");
		
		Jogada play2 = new Jogada();
		play2.setId(3L);
		play2.setJogador(jogador2);
		play2.setJokenpoItem("tesoura");
		
		assertEquals(play1, jokenpoResultado.obterResultado(play1, play2));
	}
	
	@Test
	void testObterResultadoVitoriaPlay2() {
		
		Jogador jogador1 = new Jogador();
		jogador1.setNome("Diogo");
		
		Jogada play1 = new Jogada();
		play1.setId(2L);
		play1.setJogador(jogador1);
		play1.setJokenpoItem("PapeL");
		
		Jogador jogador2 = new Jogador();
		jogador2.setNome("Pedro");
		
		Jogada play2 = new Jogada();
		play2.setId(3L);
		play2.setJogador(jogador2);
		play2.setJokenpoItem("tesOura");
		
		assertEquals(play2, jokenpoResultado.obterResultado(play1, play2));
	}

}
