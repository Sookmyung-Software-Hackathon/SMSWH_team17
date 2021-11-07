package com.conchu.hbd.service;

import com.conchu.hbd.domain.Letter;
import com.conchu.hbd.domain.LetterDto;
import com.conchu.hbd.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor
@Component
public class LetterServiceImpl implements LetterService {

    @Autowired private final LetterRepository letterRepository;

    public Letter save(LetterDto letterDto){
        return letterRepository.save(new Letter(letterDto));
    }

    public Letter findById(String id){
        return letterRepository.findById(id).orElse(null);
    }

    public String deleteInfo(String id){
        if(findById(id)!= null) {
            letterRepository.deleteById(id);
            return id;
        }
        else return null;
    }


    public String getMent(Long num){
        if(num == 0){
            return "항상 행복하고 무병장수하길 바래!<br/>오늘 하루도 수고했어! 넌 정말 멋져!!";
        }
        else if(num == 1){
            return "널 보면 항상 기분이 좋아져! <br/> 오늘도 적게 일하고 많이 버는 하루 되길~";
        }
        else if(num == 2){
            return "정말 고생했어!  <br/>앞으로도 오늘처럼 좋은 일만 있길 바랄게!";
        }
        else{
            return null;
        }
    }
}
