package br.com.jokenpo.domain.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class GenericRepository {
	
	public void excluir(Long id, File file) throws IOException {
		
	    List<String> lista = Files.lines(file.toPath())
	                        .filter(line -> !line.contains(id.toString()))
	                        .collect(Collectors.toList());
	    Files.write(file.toPath(), lista, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);		
		
	}

}
