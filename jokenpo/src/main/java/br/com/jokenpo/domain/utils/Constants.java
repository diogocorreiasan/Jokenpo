package br.com.jokenpo.domain.utils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

@Component
public class Constants {
	
	public static final String CAMINHO =  "src/main/resources/";
	public static final String JOGADAS_TXT = "jogadas.txt";
	public static final String JOGADORES_TXT = "jogadas.txt";
	
	public static final Path PATH_JOGADAS =  Paths.get(CAMINHO + JOGADAS_TXT);
	public static final Path PATH_JOGADORES =  Paths.get(CAMINHO + JOGADORES_TXT);
	public static final File FILE_JOGADAS = new File(CAMINHO + JOGADAS_TXT);
	public static final File FILE_JOGADORES = new File(CAMINHO + JOGADORES_TXT);

}
