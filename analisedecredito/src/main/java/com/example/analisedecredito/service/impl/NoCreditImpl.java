package com.example.analisedecredito.service.impl;

import com.example.analisedecredito.domain.Proposal;
import com.example.analisedecredito.service.strategy.CalculatePoint;

import java.util.Random;

public class NoCreditImpl implements CalculatePoint {
    @Override
    public int calculation(Proposal proposal) {
        if (negativeCredit()){
            throw new RuntimeException("Nome negativado");
        }
        return 100;
    }

    private boolean negativeCredit(){
        return new Random().nextBoolean();
    }

}
