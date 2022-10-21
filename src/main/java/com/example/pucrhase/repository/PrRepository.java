package com.example.pucrhase.repository;

import com.example.pucrhase.domain.PuchasingRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrRepository extends JpaRepository<PuchasingRequest, Long> {
    Optional<PuchasingRequest> findByPrNo(String prNo);
}
