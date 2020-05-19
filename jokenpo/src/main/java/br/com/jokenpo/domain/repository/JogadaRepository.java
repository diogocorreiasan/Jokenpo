package br.com.jokenpo.domain.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.jokenpo.domain.model.Jogada;
import br.com.jokenpo.domain.model.Jogador;

@Component
public class JogadaRepository {
	
	private static final Charset UTF_8 = StandardCharsets.UTF_8;
	
	public List<Jogada> listar(Path path){
		
		List<Jogada> jogadas = new ArrayList<>();
		
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] token = line.split(";");
				Jogada jogada = new Jogada(Long.parseLong(token[0]), new Jogador(null, token[1]), token[2]);
				jogadas.add(jogada);
			}
		} catch (Exception e) { 
			throw new RuntimeException("Erro ao listar as Jogadas " + e);
		}
		
		return jogadas;
	}

	public void salvar(Path path, List<Jogada> jogadas) {
		
		jogadas.forEach(jogada -> {
			try {
				Files.write(path, (jogada.getId()
						+ ";"
						+ jogada.getJogador().getNome() 
						+ ";"
						+ jogada.getJokenpoItem()
						+ System.lineSeparator()).getBytes(UTF_8),StandardOpenOption.APPEND);
			} catch (IOException e) {
				throw new RuntimeException("Erro ao salvar as jogadas "+ e);
			}
		});
	}

}