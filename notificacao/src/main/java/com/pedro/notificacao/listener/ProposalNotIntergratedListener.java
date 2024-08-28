package com.pedro.notificacao.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class ProposalNotIntergratedListener {

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void proposalNotIntegrated(){

    }


}
