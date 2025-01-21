package br.com.maketplace.rabbitmq.integration.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.maketplace.rabbitmq.integration.domain.dto.Pagamento;
import br.com.maketplace.rabbitmq.integration.domain.enums.StatusPagamentoProcessadoEnum;
import br.com.maketplace.rabbitmq.integration.rabbitmq.PagamentoProducer;
import br.com.maketplace.rabbitmq.integration.rabbitmq.RabbitMQConstants;

@Service
public class IntegracaoPagamentoBancarioService {

    @Autowired
    private PagamentoProducer pagamentoProducer;

    public void integrarPagamentoBancario(Pagamento pagamento) throws InterruptedException{
        // É gerado randomico para simular uma integracao com uma API externa de pagamento
        System.out.println(RabbitMQConstants.getDataHoraAtualSistema() + " Pagamento enviado para integração bancária...");
        boolean integrou = new Random().nextDouble() < 0.7;

        // É gerado atraso randomico para simular um processamento lento na integração
        Thread.sleep((new Random().nextInt(5) + 5) * 1000);
        System.out.println(RabbitMQConstants.getDataHoraAtualSistema() + " Pagamento processado pelo banco");

        if (integrou)
            pagamentoProducer.enviarFilaPagamentoProcessado(pagamento, StatusPagamentoProcessadoEnum.SUCESSO);
        else 
            pagamentoProducer.enviarFilaPagamentoProcessado(pagamento, StatusPagamentoProcessadoEnum.ERRO);
    }
}
