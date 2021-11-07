package com.conchu.hbd.service;

import com.conchu.hbd.domain.Letter;
import com.conchu.hbd.domain.LetterDto;
import org.springframework.stereotype.Service;

@Service
public interface LetterService {

    public Letter save(LetterDto letterDto);

    public Letter findById(String id);

    public String deleteInfo(String id);

    public String getMent(Long num);
}
