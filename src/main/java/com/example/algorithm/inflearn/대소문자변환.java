package com.example.algorithm.inflearn;

import java.util.*;
import java.util.stream.StreamSupport;

public class 대소문자변환 {
    public static void main(String[] args) {
        대소문자변환 T = new 대소문자변환();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.print(T.solution(str));
    }

    public String solution(String str) {
        String answer = "";

        /*
        for(char x : str.toCharArray()) {
            if(Character.isLowerCase(x))
                answer += Character.toUpperCase(x);
            else
                answer += Character.toLowerCase(x);
        }
        */

        // 대문자: 65 ~ 90, 소문자: 97 ~ 122
        for(char x : str.toCharArray()) {
            if(x >= 65 && x <= 90) // 대문자
                answer += (char)(x + 32);
            else if(x >= 97 && x <= 122)
                answer += (char)(x - 32);
        }

        return answer;
    }
}
