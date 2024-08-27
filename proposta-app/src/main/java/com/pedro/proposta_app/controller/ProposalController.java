package com.pedro.proposta_app.controller;

import com.pedro.proposta_app.dto.ProposalRequestDTO;
import com.pedro.proposta_app.dto.ProposalResponseDto;
import com.pedro.proposta_app.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/proposta")
public class ProposalController {

    @Autowired
    private ProposalService proposalService;

    @PostMapping
    public ResponseEntity<ProposalResponseDto> create(@RequestBody ProposalRequestDTO proposal){
        ProposalResponseDto responseDto = proposalService.create(proposal);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id").buildAndExpand(responseDto.id()).toUri()).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<ProposalResponseDto>> getProposals(){
         return ResponseEntity.ok().body(proposalService.getProposals());
    }
}
