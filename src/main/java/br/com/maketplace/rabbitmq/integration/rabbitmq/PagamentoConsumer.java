package br.com.maketplace.rabbitmq.integration.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PagamentoConsumer {

    @RabbitListener(queues = RabbitMQConstants.QUEUE_PAYMENT)
    public void consumirFilaPagamento(String pagamento){
        System.out.println(
            "\nO sistema recebeu uma mensagem do RabbitMQ, fila: " + RabbitMQConstants.QUEUE_PAYMENT +
            "\nPagamento: " + pagamento);
    }
}
