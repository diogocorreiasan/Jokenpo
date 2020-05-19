package br.com.jokenpo.domain.model;

public class Jogada {
	
	private Long id;
	private Jogador jogador;
	private String jokenpoItem;
	
	public Jogada() { }
	
	public Jogada(Long id, Jogador jogador, String jokenpoItem) {
		this.id = id;
		this.jogador = jogador;
		this.jokenpoItem = jokenpoItem;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public String getJokenpoItem() {
		return jokenpoItem;
	}

	public void setJokenpoItem(String jokenpoItem) {
		this.jokenpoItem = jokenpoItem;
	}
	
}