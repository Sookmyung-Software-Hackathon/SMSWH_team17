package com.conchu.hbd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RestController
public class FortuneController {

    String[] fortunecookies = {
            "와!! 좋은 인연을 얻게 될 거에요!!!",
            "당첨~~~~~!! 메일로 성함과 전화번호를 보내주시면 스타벅스 기프티콘을 드립니다~",
            "머지않아 단비가 내릴 예정이에요!!!",
            "오늘 생각하지 않은 곳에서 아주 큰! 행운이 찾아옵니다 ~",
            "오늘은 매사에 행운이 따르고 생활에 여유가 생길 운이에요!!",
            "명예와 재물운이 상승하고 있어요!!!",
            "재물운이 좋아지고 있네요! 돈이 되는 일은 무조건 좋은 결과를 보게 됩니다:)",
            "헉, 금전운이 엄청나요. 곧 예상치 못한 수입이 들어올 거에요!",
            "다른 사람에게 나눠줘도 남을 만큼 거대한 행운이 다가오고 있네요~",
            "오늘 길에서 우연히 돈을 주울 운이래요!!"
    };

    @GetMapping("/fortunes")
    public ResponseEntity<HashMap> pickCookie() {
        int num = (int)(Math.random() * 100);

        int result;
        if (num >= 10 && num < 20) result = num % 10;
        else result = num / 10;

        HashMap<String, String> responseMap = new HashMap<>();
        responseMap.put("status", "200");
        responseMap.put("message", "OK");
        responseMap.put("data", fortunecookies[result]);
        return new ResponseEntity<HashMap>(responseMap, HttpStatus.OK);
    }
}
