package br.com.maketplace.rabbitmq.integration.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.maketplace.rabbitmq.integration.domain.dto.Pagamento;
import br.com.maketplace.rabbitmq.integration.domain.dto.PagamentoProcessado;
import br.com.maketplace.rabbitmq.integration.domain.enums.StatusPagamentoProcessadoEnum;

@Component
public class PagamentoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarFilaPagamentoProcessado(Pagamento pagamento, StatusPagamentoProcessadoEnum status){
        String json = new Gson().toJson(new PagamentoProcessado(status, pagamento.getCodigo()));

        rabbitTemplate.convertAndSend(RabbitMQConstants.QUEUE_PAYMENT_PROCESSED, json);
            
        System.out.println(
            "\n" + RabbitMQConstants.getDataHoraAtualSistema() + " O sistema enviou uma mensagem para o RabbitMQ, fila: " + RabbitMQConstants.QUEUE_PAYMENT_PROCESSED +
            "\n" + RabbitMQConstants.getDataHoraAtualSistema() + " Pagamento: " + json + "\n");
    }
}
