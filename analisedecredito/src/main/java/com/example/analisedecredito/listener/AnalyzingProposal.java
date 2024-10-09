package com.example.analisedecredito.listener;

import com.example.analisedecredito.domain.Proposal;
import com.example.analisedecredito.service.AnalyzeCreditService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnalyzingProposal {

    @Autowired
    private  AnalyzeCreditService analyzeCreditService;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void AnalyzingAnProposal(Proposal proposal){
        analyzeCreditService.analyze(proposal);
    }

}
