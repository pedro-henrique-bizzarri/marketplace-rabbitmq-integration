package br.com.maketplace.rabbitmq.integration.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.maketplace.rabbitmq.integration.domain.dto.Pagamento;
import br.com.maketplace.rabbitmq.integration.service.IntegracaoPagamentoBancarioService;

@Component
public class PagamentoConsumer {

    @Autowired
    private IntegracaoPagamentoBancarioService pagamentoBancarioService;

    @RabbitListener(queues = RabbitMQConstants.QUEUE_PAYMENT)
    public void consumirFilaPagamento(String pagamentoJson) throws InterruptedException{
        System.out.println(
            "\nO sistema recebeu uma mensagem do RabbitMQ, fila: " + RabbitMQConstants.QUEUE_PAYMENT +
            "\nPagamento: " + pagamentoJson);

        Pagamento pagamento = new Gson().fromJson(pagamentoJson, Pagamento.class);
        pagamentoBancarioService.integrarPagamentoBancario(pagamento);
    }
}
