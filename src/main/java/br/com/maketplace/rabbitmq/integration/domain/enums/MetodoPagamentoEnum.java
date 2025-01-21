package br.com.maketplace.rabbitmq.integration.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum MetodoPagamentoEnum {

    PIX("Pix"),
    CARTAO_CREDITO("Cartão de crédito"),
    TRANSFERENCIA("Tranferência");

    private String descricao;
}
