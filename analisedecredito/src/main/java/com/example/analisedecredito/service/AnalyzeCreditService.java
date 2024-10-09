package com.example.analisedecredito.service;

import com.example.analisedecredito.domain.Proposal;
import com.example.analisedecredito.exceptions.StrategyException;
import com.example.analisedecredito.service.strategy.CalculatePoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnalyzeCreditService {

    @Autowired
    private List<CalculatePoint> calculatePointList;

    @Autowired
    private NotificationRabbitService notificationRabbitService;

    @Value("${rabbitmq.exchange.proposta.concluida}")
    private String exchangePropostaConcluida;

    public void analyze(Proposal proposal){
        try{
           int points = calculatePointList.stream().mapToInt(impl -> impl.calculation(proposal)).sum();
            proposal.setApproved(points > 350);
        }catch (StrategyException ex){
            proposal.setApproved(false);
            proposal.setObservation(ex.getMessage());
        }
        notificationRabbitService.notification(exchangePropostaConcluida,proposal);
    }

}
