package com.conchu.hbd.repository;

import com.conchu.hbd.domain.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LetterRepository extends JpaRepository<Letter, Long>{
    Optional<Letter> findById(String id);
    void deleteById(String id);
}
