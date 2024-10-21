package com.pedro.proposta_app.repository;

import com.pedro.proposta_app.entity.Proposal;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal,Long> {

    List<Proposal> findAllProposalByIntegratedIsFalse();


    @Transactional
    @Modifying
    @Query(value = "UPDATE proposal set approved = :approved, observation = :observation where id = :id", nativeQuery = true)
    void updateProposal(Long id, Boolean approved, String observation);
}
