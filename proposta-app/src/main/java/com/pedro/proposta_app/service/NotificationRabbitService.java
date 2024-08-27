package com.pedro.proposta_app.service;

import com.pedro.proposta_app.entity.Proposal;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationRabbitService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void notification(Proposal proposal, String exchange){
        rabbitTemplate.convertAndSend(exchange,"",proposal);
    }
}
