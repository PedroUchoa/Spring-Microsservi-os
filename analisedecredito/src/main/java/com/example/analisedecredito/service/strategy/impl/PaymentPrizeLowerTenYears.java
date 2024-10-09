package com.example.analisedecredito.service.strategy.impl;

import com.example.analisedecredito.domain.Proposal;
import com.example.analisedecredito.service.strategy.CalculatePoint;
import org.springframework.stereotype.Component;

@Component
public class PaymentPrizeLowerTenYears implements CalculatePoint {

    @Override
    public int calculation(Proposal proposal) {
        return proposal.getPaymentPeriod() < 120? 80 : 0;
    }



}
