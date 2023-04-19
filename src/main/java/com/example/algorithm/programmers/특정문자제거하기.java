package com.example.algorithm.programmers;

public class 특정문자제거하기 {
    public static void main(String[] args) {
        String answer = solution("abcdef", "f");
        System.out.println("answer = " + answer);
    }

    public static String solution(String my_string, String letter) {
        String answer = "";
        answer = my_string.replace(letter, "");
        return answer;
    }
}
