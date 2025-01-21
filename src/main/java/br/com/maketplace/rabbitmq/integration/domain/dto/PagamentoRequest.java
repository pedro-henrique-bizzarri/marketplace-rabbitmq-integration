package br.com.maketplace.rabbitmq.integration.domain.dto;

import br.com.maketplace.rabbitmq.integration.domain.enums.MetodoPagamentoEnum;
import br.com.maketplace.rabbitmq.integration.domain.enums.StatusPagamentoEnum;

public record PagamentoRequest(String nome, String cpf, Long codigo, MetodoPagamentoEnum metodoPagamento, StatusPagamentoEnum status, double valor) {

}
