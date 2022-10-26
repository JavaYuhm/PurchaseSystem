package com.example.pucrhase.repository;

import com.example.pucrhase.domain.PuchasingRequest;
import com.example.pucrhase.domain.RFQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RFQRepository extends JpaRepository<RFQ, Long> {
    Optional<RFQ> findByRfqNo(String rfqNo);
}
