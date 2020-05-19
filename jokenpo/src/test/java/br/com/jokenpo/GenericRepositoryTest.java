package br.com.jokenpo;

import static br.com.jokenpo.domain.utils.Constants.FILE_JOGADAS;
import static br.com.jokenpo.domain.utils.Constants.FILE_JOGADORES;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import br.com.jokenpo.domain.repository.GenericRepository;

class GenericRepositoryTest {

	private GenericRepository genericRepository = new GenericRepository();
	
	@Test
	void testExcluirJogador() throws IOException {
		genericRepository.excluir(1L, FILE_JOGADORES);
	}
	
	@Test
	void testExcluirJogada() throws IOException {
		genericRepository.excluir(1L, FILE_JOGADAS);
	}

}
