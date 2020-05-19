package br.com.jokenpo.domain.service;

import static br.com.jokenpo.domain.utils.Constants.FILE_JOGADAS;
import static br.com.jokenpo.domain.utils.Constants.PATH_JOGADAS;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jokenpo.domain.model.Jogada;
import br.com.jokenpo.domain.repository.GenericRepository;
import br.com.jokenpo.domain.repository.JogadaRepository;
import br.com.jokenpo.service.config.JokenpoResultado;

@Service
public class JogadaService {
	
	private GenericRepository gerericRepository;
	private JogadaRepository jogadaRepository;
	private JokenpoResultado jokenpo;
	
	@Autowired
	public JogadaService(GenericRepository gerericRepository, JogadaRepository jogadaRepository,
			JokenpoResultado jokenpo) {
		this.gerericRepository = gerericRepository;
		this.jogadaRepository = jogadaRepository;
		this.jokenpo = jokenpo;
	}
	
	public List<Jogada> buscar() {
		List<Jogada> jogadas = jogadaRepository.listar(PATH_JOGADAS);
		return jogadas;
	}
	
	public Jogada jogar(List<Jogada> jogadas) {
		
		Jogada jogadaVencedora = null;
		
		for (int i = 0; i+1 < jogadas.size(); i++) {
			Jogada play1 = jogadas.get(i);
			Jogada play2 = jogadas.get(i+1);
			
			if(jogadaVencedora == null) {
				jogadaVencedora = jokenpo.obterResultado(play1, play2);
			}else {
				jogadaVencedora = jokenpo.obterResultado(jogadaVencedora, play2);
			}
		}		
		
		jogadaRepository.salvar(PATH_JOGADAS, jogadas);
		
		return jogadaVencedora;
			
	}

	public void excluir(Long id) throws IOException {
		gerericRepository.excluir(id, FILE_JOGADAS);
	}

}