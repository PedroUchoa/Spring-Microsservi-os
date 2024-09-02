package com.pedro.notificacao.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationSnsService {


    @Autowired
    private AmazonSNS amazonSNS;

    public void notification(String phone,String message){
        PublishRequest publishRequest = new PublishRequest().withMessage(message).withPhoneNumber(phone);
        amazonSNS.publish(publishRequest);
    }

}
