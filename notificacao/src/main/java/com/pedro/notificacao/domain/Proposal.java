package com.pedro.notificacao.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Proposal {

    private Long id;

    private Double requestedValue;

    private int paymentPeriod;

    private Boolean approved;

    private boolean integrated;

    private String observation;

    private Users users;


}
