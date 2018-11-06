package exercicio3;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Endereco {
	private String endereco;
	private String bairro;
	private String numero;
	private String cep;
	

}
