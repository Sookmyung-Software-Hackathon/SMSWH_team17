package com.conchu.hbd.controller;

import com.conchu.hbd.domain.Letter;
import com.conchu.hbd.domain.LetterDto;
import com.conchu.hbd.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@Controller
@RestController
@RequiredArgsConstructor
public class LetterController {

    private final LetterService letterService;

    @PostMapping("/letters")
    private ResponseEntity create(@RequestBody LetterDto letterDto){
        Letter letter = letterService.save(letterDto);
        HashMap<String, Object> responseMap = new HashMap<>();

        if(letter != null){
            responseMap.put("status", 200);
            responseMap.put("message", "축하 정보 저장 성공");
            responseMap.put("id", letter.getId());
            return new ResponseEntity<HashMap> (responseMap, HttpStatus.OK);
        }
        else{
            responseMap.put("status", 500);
            responseMap.put("message", "축하 정보 저장 실패");
            return new ResponseEntity<HashMap> (responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/letters/{id}")
    private ResponseEntity read(@PathVariable String id){
        Letter letter = letterService.findById(id);
        HashMap<String, Object> responseMap = new HashMap<>();

        LetterDto letterDto = new LetterDto(letter.getCategory(), letter.getName());
        String ment = letterService.getMent(letter.getLetternum());
        if(letter != null && ment!= null){
            responseMap.put("status", 200);
            responseMap.put("message", "축하 정보 조회 성공");
            responseMap.put("data", letterDto);
            responseMap.put("ment", ment);
            return new ResponseEntity<HashMap> (responseMap, HttpStatus.OK);
        }
        else{
            responseMap.put("status", 401);
            responseMap.put("message", "없는 정보");
            return new ResponseEntity<HashMap> (responseMap, HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/letters/{id}")
    private ResponseEntity delete(@PathVariable String id){

        String deletedId = letterService.deleteInfo(id);
        HashMap<String, Object> responseMap = new HashMap<>();

        if(deletedId != null){
            responseMap.put("status", 200);
            responseMap.put("message", "축하 정보 제거 성공");
            responseMap.put("id", deletedId);
            return new ResponseEntity<HashMap> (responseMap, HttpStatus.OK);
        }
        else{
            responseMap.put("status", 401);
            responseMap.put("message", "없는 정보");
            return new ResponseEntity<HashMap> (responseMap, HttpStatus.UNAUTHORIZED);
        }
    }
}
