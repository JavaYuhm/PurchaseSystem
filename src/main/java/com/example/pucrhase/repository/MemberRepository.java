package com.example.pucrhase.repository;

import com.example.pucrhase.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class MemberRepository implements JpaRepository<Member, Long> {
}
