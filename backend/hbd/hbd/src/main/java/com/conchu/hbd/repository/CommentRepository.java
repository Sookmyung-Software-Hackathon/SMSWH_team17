package com.conchu.hbd.repository;

import com.conchu.hbd.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByLetterId(String letterId);

    Optional<Comment> findById(String id);
}