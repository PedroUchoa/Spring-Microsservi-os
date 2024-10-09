package com.example.analisedecredito.service.strategy.impl;

import com.example.analisedecredito.constant.ConstantMessage;
import com.example.analisedecredito.domain.Proposal;
import com.example.analisedecredito.exceptions.StrategyException;
import com.example.analisedecredito.service.strategy.CalculatePoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(2)
@Component
public class ScorePointsImpl implements CalculatePoint {


    @Override
    public int calculation(Proposal proposal) {
        int score = score();

        if (score<200){
            throw new StrategyException(String.format(ConstantMessage.PONTUACAO_SERASA_BAIXA,proposal.getUsers().getName()));
        } else if (score <= 400) {
            return 150;
        } else if (score <= 600) {
            return 180;
        }else {
            return 220;
        }


    }


    private int score(){
        return new Random().nextInt(0,1000);
    }

}
