package com.conchu.hbd.controller;

import com.conchu.hbd.domain.Comment;
import com.conchu.hbd.domain.CommentRequestDto;
import com.conchu.hbd.domain.Letter;
import com.conchu.hbd.repository.CommentRepository;
import com.conchu.hbd.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;

    @PostMapping("/comments")
    public ResponseEntity<HashMap> create(@RequestBody CommentRequestDto requestDto) {
        Comment comment = commentService.create(requestDto);

        HashMap<String, Object> responseMap = new HashMap<>();

        if(comment != null) {
            responseMap.put("status", 200);
            responseMap.put("message", "코멘트 등록 성공");
        }
        else{
            responseMap.put("status", 500);
            responseMap.put("message", "알 수 없는 이유로 코멘트 등록 실패");
        }
        return new ResponseEntity<HashMap>(responseMap, HttpStatus.OK);
    }

    @GetMapping("/comments/{letterId}")
    public ResponseEntity<HashMap> read(@PathVariable("letterId") String letterId) {
        HashMap<String, Object> responseMap = new HashMap<>();

        responseMap.put("status", 200);
        responseMap.put("message", "코멘트 조회 성공");
        responseMap.put("data", commentService.findComments(letterId));

        return new ResponseEntity<HashMap>(responseMap, HttpStatus.OK);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<HashMap> delete(@PathVariable("id") String id) {
        commentService.delete(id);

        HashMap<String, Object> responseMap = new HashMap<>();

        responseMap.put("status", 200);
        responseMap.put("message", "코멘트 제거 성공");

        return new ResponseEntity<HashMap>(responseMap, HttpStatus.OK);
    }
}