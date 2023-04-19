package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 중복된문자제거 {
    public static void main(String[] args) {
        String answer = solution("people");
        System.out.println("answer = " + answer);
    }

    public static String solution(String my_string) {
        String answer = "";

        answer = Arrays.stream(my_string.split("")).distinct().collect(Collectors.joining());

        return answer;
    }
}
