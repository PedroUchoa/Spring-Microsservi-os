package com.example.analisedecredito.service.strategy.impl;

import com.example.analisedecredito.domain.Proposal;
import com.example.analisedecredito.service.strategy.CalculatePoint;
import org.springframework.stereotype.Component;

@Component
public class IncomeHigherThanRequestedValue implements CalculatePoint {


    @Override
    public int calculation(Proposal proposal) {
        return HigherIncomeValue(proposal) ? 100 : 0;
    }


    private boolean HigherIncomeValue(Proposal proposal){
        return proposal.getUsers().getIncome() > proposal.getRequestedValue();
    }

}
