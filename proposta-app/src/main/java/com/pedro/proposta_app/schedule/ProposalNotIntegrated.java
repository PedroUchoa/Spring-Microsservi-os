package com.pedro.proposta_app.schedule;

import com.pedro.proposta_app.entity.Proposal;
import com.pedro.proposta_app.repository.ProposalRepository;
import com.pedro.proposta_app.service.NotificationRabbitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class ProposalNotIntegrated {

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private NotificationRabbitService notificationRabbitService;

    private String exchange;

    private final Logger logger = LoggerFactory.getLogger(ProposalNotIntegrated.class);

    public ProposalNotIntegrated(@Value("${rabbitmq.propostapendente.exchange}") String exchange) {
        this.exchange = exchange;
    }

    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
    public void searchProposalNotIntegrated(){
        proposalRepository.findAllProposalByIntegratedIsFalse().forEach(proposal -> {
            try{
                notificationRabbitService.notification(proposal,exchange);
                updateProposal(proposal);
            }catch (RuntimeException ex){
                logger.error(ex.getMessage());
            }
        });
    }

    private void updateProposal(Proposal proposal){
        proposal.setIntegrated(true);
        proposalRepository.save(proposal);
    }

}
