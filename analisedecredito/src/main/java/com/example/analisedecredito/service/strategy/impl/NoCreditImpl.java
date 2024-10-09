package com.example.analisedecredito.service.strategy.impl;

import com.example.analisedecredito.constant.ConstantMessage;
import com.example.analisedecredito.domain.Proposal;
import com.example.analisedecredito.exceptions.StrategyException;
import com.example.analisedecredito.service.strategy.CalculatePoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(1)
@Component
public class NoCreditImpl implements CalculatePoint {
    @Override
    public int calculation(Proposal proposal) {
        if (negativeCredit()){
            throw new StrategyException(String.format(ConstantMessage.CLIENTE_NGATIVADO,proposal.getUsers().getName()));
        }
        return 100;
    }

    private boolean negativeCredit(){
        return new Random().nextBoolean();
    }

}
