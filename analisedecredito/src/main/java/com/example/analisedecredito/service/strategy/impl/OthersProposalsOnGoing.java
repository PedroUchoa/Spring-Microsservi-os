package com.example.analisedecredito.service.strategy.impl;

import com.example.analisedecredito.domain.Proposal;
import com.example.analisedecredito.service.strategy.CalculatePoint;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OthersProposalsOnGoing implements CalculatePoint {


    @Override
    public int calculation(Proposal proposal) {
        return  isOthersProposalOnGoing() ? 0 : 80;
    }

    private boolean isOthersProposalOnGoing(){
        return new Random().nextBoolean();
    }

}
