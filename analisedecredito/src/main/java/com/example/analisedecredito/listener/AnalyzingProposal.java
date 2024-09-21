package com.example.analisedecredito.listener;

import com.example.analisedecredito.domain.Proposal;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnalyzingProposal {

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void AnalyzingAnProposal(Proposal proposal){

    }

}
