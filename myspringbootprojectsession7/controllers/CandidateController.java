package com.example.myspringbootprojectsession7.controllers;

import com.example.myspringbootprojectsession7.dto.CandidateCreateDTO;
import com.example.myspringbootprojectsession7.dto.CandidateUpdateDTO;
import com.example.myspringbootprojectsession7.entities.Candidate;
import com.example.myspringbootprojectsession7.repositories.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateRepository candidateRepository;

    public CandidateController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @PostMapping
    public ResponseEntity<Candidate> createCandidate(
            @Valid @RequestBody CandidateCreateDTO request) {
        Candidate candidate = new Candidate(
                request.getFullName(),
                request.getEmail(),
                request.getAge(),
                request.getYearsOfExperience()
        );
        Candidate savedCandidate = candidateRepository.save(candidate);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCandidate);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Candidate> updateCandidate(
            @PathVariable Integer id,
            @Valid @ModelAttribute CandidateUpdateDTO request) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Candidate not found"));
        candidate.setAddress(request.getAddress());
        candidate.setBio(request.getBio());
        return ResponseEntity.ok(candidateRepository.save(candidate));
    }
}
