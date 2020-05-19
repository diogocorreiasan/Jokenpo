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

import br.com.jokenpo.domain.model.Jogador;

@Component
public class JogadorRepository {
	
	public List<Jogador> listar(Path path) throws IOException{
		
		List<Jogador> jogadores = new ArrayList<>();
		
		BufferedReader reader = Files.newBufferedReader(path);
		
		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] token = line.split(";");
			jogadores.add(new Jogador(Long.parseLong(token[0]), token[1]));
		}
		
		return jogadores;
	}

	public Jogador salvar(Path path, Jogador request) throws IOException {
		Charset utf8 = StandardCharsets.UTF_8;
		
		Files.write(path, (request.getId()
				+ ";" 
				+ request.getNome()
				+ System.lineSeparator()).getBytes(utf8),StandardOpenOption.APPEND);
		
		return request;
	}

}