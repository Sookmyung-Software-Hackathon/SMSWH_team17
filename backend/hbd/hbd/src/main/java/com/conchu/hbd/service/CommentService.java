package com.conchu.hbd.service;

import com.conchu.hbd.domain.Comment;
import com.conchu.hbd.domain.CommentRequestDto;
import com.conchu.hbd.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment create(CommentRequestDto requestDto) {
        return commentRepository.save(new Comment(requestDto));
    }

    public List<Comment> findComments(String letterId) {
        List<Comment> comments = commentRepository.findByLetterId(letterId);
        Collections.shuffle(comments);
        return comments;
    }

    public String delete(String id) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("comment가 존재하지 않습니다.")
        );
        commentRepository.delete(comment);

        return id;
    }


}