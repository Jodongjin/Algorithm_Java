package com.example.algorithm.programmers;

import java.util.Arrays;

public class 문자열정렬하기_2 {
    public static void main(String[] args) {
        String answer = solution("Bcad");
        System.out.println("answer = " + answer);
    }

    public static String solution(String my_string) {
        String answer = "";
        char[] arr = my_string.toLowerCase().toCharArray();

        Arrays.sort(arr);

        answer = new String(arr);

        return answer;
    }
}
