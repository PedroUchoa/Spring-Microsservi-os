package com.pedro.proposta_app.dto;



public record ProposalRequestDTO(String nome,String sobrenome, String telefone, String cpf, Double renda, Double valorSolicitado, int prazoPagamento) {
}
