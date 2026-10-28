package com.example.myspringbootprojectsession7.repositories;

import com.example.myspringbootprojectsession7.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
}
