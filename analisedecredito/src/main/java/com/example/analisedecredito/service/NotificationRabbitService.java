package com.example.analisedecredito.service;

import com.example.analisedecredito.domain.Proposal;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class NotificationRabbitService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void notification(String exchange, Proposal proposal){
        rabbitTemplate.convertAndSend(exchange,"",proposal);
    }


}
