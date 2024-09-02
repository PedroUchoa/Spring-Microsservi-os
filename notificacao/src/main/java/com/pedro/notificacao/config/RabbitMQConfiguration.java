package com.pedro.notificacao.config;


import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }


}
