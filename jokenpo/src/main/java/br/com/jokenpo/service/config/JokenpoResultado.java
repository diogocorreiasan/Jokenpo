package br.com.jokenpo.service.config;

import org.springframework.stereotype.Service;

import br.com.jokenpo.domain.model.Jogada;

@Service
public class JokenpoResultado {
	
	public Jogada obterResultado(Jogada play1, Jogada play2) {
		Jogada vencedor = null;
		
		if(play2.getJokenpoItem().equalsIgnoreCase("papel") 
				&& play1.getJokenpoItem().equalsIgnoreCase("pedra")) {
			
			vencedor = play2;
			
		}
		else if(play2.getJokenpoItem().equalsIgnoreCase("tesoura") 
				&& play1.getJokenpoItem().equalsIgnoreCase("pedra")) {
			
			vencedor = play1;
			
		}
		else if(play2.getJokenpoItem().equalsIgnoreCase("tesoura") 
				&& play1.getJokenpoItem().equalsIgnoreCase("papel")) {
			
			vencedor = play2;
			
		}		
		else if(play1.getJokenpoItem().equalsIgnoreCase("papel") 
				&& play2.getJokenpoItem().equalsIgnoreCase("pedra")) {
			
			vencedor = play1;
			
		}
		else if(play1.getJokenpoItem().equalsIgnoreCase("tesoura") 
				&& play2.getJokenpoItem().equalsIgnoreCase("pedra")) {
			
			vencedor = play2;
			
		}
		else if(play1.getJokenpoItem().equalsIgnoreCase("tesoura") 
				&& play2.getJokenpoItem().equalsIgnoreCase("papel")) {
			
			vencedor = play1;
			
		}
		else {
			vencedor = null;
		}
		
		return vencedor;
	}

}