package br.com.maketplace.rabbitmq.integration.domain.dto;

import br.com.maketplace.rabbitmq.integration.domain.enums.StatusPagamentoProcessadoEnum;

public record PagamentoProcessado (StatusPagamentoProcessadoEnum status, Long codigoPagamento) {

}
