package exercicio3;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Cliente {
	
	private String nome;
	private Endereco endereco;
	
	
	
	
}
