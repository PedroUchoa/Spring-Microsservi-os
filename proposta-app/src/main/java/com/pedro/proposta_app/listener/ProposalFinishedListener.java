package com.pedro.proposta_app.listener;

import com.pedro.proposta_app.dto.ProposalResponseDto;
import com.pedro.proposta_app.entity.Proposal;
import com.pedro.proposta_app.mapper.ProposalMapper;
import com.pedro.proposta_app.repository.ProposalRepository;
import com.pedro.proposta_app.service.WebSocketService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class ProposalFinishedListener {

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private WebSocketService webSocketService;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.concluida}")
    public void ProposalFinished(Proposal proposal){
        updateProposal(proposal);
        webSocketService.notification(ProposalMapper.INSTANCE.covertEntityToDto(proposal));
    }

    private void updateProposal(Proposal proposal){
        proposalRepository.updateProposal(proposal.getId(), proposal.getApproved(), proposal.getObservation());
    }

}
