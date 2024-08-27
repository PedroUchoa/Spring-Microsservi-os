package com.pedro.proposta_app.mapper;

import com.pedro.proposta_app.dto.ProposalRequestDTO;
import com.pedro.proposta_app.dto.ProposalResponseDto;
import com.pedro.proposta_app.entity.Proposal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.text.NumberFormat;
import java.util.List;

@Mapper
public interface ProposalMapper {

    ProposalMapper INSTANCE = Mappers.getMapper(ProposalMapper.class);

    @Mapping(target = "users.name", source = "nome")
    @Mapping(target = "users.lastName", source = "sobrenome")
    @Mapping(target = "users.cpf", source = "cpf")
    @Mapping(target = "users.phone", source = "telefone")
    @Mapping(target = "users.income", source = "renda")
    @Mapping(target = "requestedValue", source = "valorSolicitado")
    @Mapping(target = "paymentPeriod", source = "prazoPagamento")
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "integrated",constant = "true")
    @Mapping(target = "approved",ignore = true)
    @Mapping(target = "observation",ignore = true)
    Proposal convertDtoToProposal(ProposalRequestDTO proposalRequestDTO);

    @Mapping(target = "nome", source = "users.name")
    @Mapping(target = "sobrenome", source = "users.lastName")
    @Mapping(target = "telefone", source = "users.phone")
    @Mapping(target = "cpf", source = "users.cpf")
    @Mapping(target = "renda", source = "users.income")
    @Mapping(target = "valorSolicitadoFmt", expression = "java(setValorSolicitadoFmt(proposal))")
    @Mapping(target = "prazoPagamento", source = "paymentPeriod")
    @Mapping(target = "aprovado", source = "approved")
    @Mapping(target = "observacao", source = "observation")
    ProposalResponseDto covertEntityToDto(Proposal proposal);

    List<ProposalResponseDto> converListEntityToListDto(Iterable<Proposal> proposals);

    default String setValorSolicitadoFmt(Proposal proposal){
        return NumberFormat.getCurrencyInstance().format(proposal.getRequestedValue());
    }

}
