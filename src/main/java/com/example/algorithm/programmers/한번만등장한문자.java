package com.example.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 한번만등장한문자 {
    public static void main(String[] args) {
        String answer = solution("abcabcadc");
        System.out.println("answer = " + answer);
    }

    public static String solution(String s) {
        String answer = "";
        String[] arr = s.split("");

        ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr
        ));

        for(String str: arr) {
            if(Collections.frequency(list, str) == 1)
                answer += str;
        }

        char[] answerArr = answer.toCharArray();
        Arrays.sort(answerArr);
        answer = String.valueOf(answerArr);

        return answer;
    }
}
