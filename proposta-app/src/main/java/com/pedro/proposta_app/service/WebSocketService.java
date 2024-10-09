package com.pedro.proposta_app.service;

import com.pedro.proposta_app.dto.ProposalResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    @Autowired
    private SimpMessagingTemplate template;

    public void notification(ProposalResponseDto proposal){
        template.convertAndSend("/propostas",proposal);
    }


}
