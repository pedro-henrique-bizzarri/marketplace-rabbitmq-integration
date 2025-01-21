package br.com.maketplace.rabbitmq.integration.domain.dto;

import br.com.maketplace.rabbitmq.integration.domain.enums.MetodoPagamentoEnum;
import br.com.maketplace.rabbitmq.integration.domain.enums.StatusPagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {

    private String nome; 
    
    private String cpf; 
    
    private Long codigo; 
    
    private MetodoPagamentoEnum metodoPagamento;
    
    private StatusPagamentoEnum status; 
    
    private double valor;

}
