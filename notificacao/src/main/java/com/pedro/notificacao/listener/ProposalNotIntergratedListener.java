package com.pedro.notificacao.listener;

import com.pedro.notificacao.constant.ConstantMessage;
import com.pedro.notificacao.domain.Proposal;
import com.pedro.notificacao.service.NotificationSnsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProposalNotIntergratedListener {

    @Autowired
    private NotificationSnsService notificationSnsService;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void proposalNotIntegrated(Proposal proposal){
        String message =String.format(ConstantMessage.PROPOSTA_EM_ANALISE,proposal.getUsers().getName());
        notificationSnsService.notification(proposal.getUsers().getPhone(), message);
    }

    @RabbitListener(queues = "${rabbitmq.queue.proposta.concluida}")
    public void proposalFinished(Proposal proposal){
        String message =String.format(ConstantMessage.PROPOSTA_APROVADA,proposal.getUsers().getName());
        notificationSnsService.notification(proposal.getUsers().getPhone(), message);
    }

}
