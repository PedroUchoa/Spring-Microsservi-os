package com.pedro.proposta_app.service;

import com.pedro.proposta_app.dto.ProposalRequestDTO;
import com.pedro.proposta_app.dto.ProposalResponseDto;
import com.pedro.proposta_app.entity.Proposal;
import com.pedro.proposta_app.mapper.ProposalMapper;
import com.pedro.proposta_app.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalService {

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private NotificationRabbitService notificationRabbitService;


    private String exchange;

    public ProposalService(@Value("${rabbitmq.propostapendente.exchange}") String exchange) {
        this.exchange = exchange;
    }

    public ProposalResponseDto create(ProposalRequestDTO requestDto){
        Proposal proposal = ProposalMapper.INSTANCE.convertDtoToProposal(requestDto);
        proposalRepository.save(proposal);

        notificationRabbitMQ(proposal);

        return ProposalMapper.INSTANCE.covertEntityToDto(proposal);
    }


    public List<ProposalResponseDto> getProposals() {
        return ProposalMapper.INSTANCE.converListEntityToListDto(proposalRepository.findAll());
    }


    public void notificationRabbitMQ(Proposal proposal){
        try{
            notificationRabbitService.notification(proposal,exchange);
        }catch (RuntimeException ex){
            proposal.setIntegrated(false);
            proposalRepository.save(proposal);
        }
    }

}
