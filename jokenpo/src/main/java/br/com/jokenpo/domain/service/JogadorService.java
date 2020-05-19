package br.com.jokenpo.domain.service;

import static br.com.jokenpo.domain.utils.Constants.FILE_JOGADORES;
import static br.com.jokenpo.domain.utils.Constants.PATH_JOGADORES;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jokenpo.domain.model.Jogador;
import br.com.jokenpo.domain.repository.GenericRepository;
import br.com.jokenpo.domain.repository.JogadorRepository;

@Service
public class JogadorService {
	
	private GenericRepository genericRepository;
	private JogadorRepository jogadorRepository;
	
	@Autowired
	public JogadorService(GenericRepository genericRepository, JogadorRepository jogadorRepository) {
		this.genericRepository = genericRepository;
		this.jogadorRepository = jogadorRepository;
	}

	public List<Jogador> buscar() throws IOException {
		List<Jogador> jogadores = jogadorRepository.listar(PATH_JOGADORES);
		return jogadores;
	}

	public Jogador cadastrar(Jogador request) throws IOException {
		return jogadorRepository.salvar(PATH_JOGADORES, request);
	}
	
	public void excluir(Long id) throws IOException {
		genericRepository.excluir(id, FILE_JOGADORES);
	}
	
}