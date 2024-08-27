package com.pedro.proposta_app.repository;

import com.pedro.proposta_app.entity.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal,Long> {

    List<Proposal> findAllProposalByIntegratedIsFalse();

}
