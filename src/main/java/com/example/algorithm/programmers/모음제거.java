package com.example.algorithm.programmers;

public class 모음제거 {
    public static void main(String[] args) {
        String answer = solution("bus");
        System.out.println("answer = " + answer);
    }

    public static String solution(String my_string) {
        String answer = "";

        answer = my_string.replaceAll("[aeiou]", "");

        return answer;
    }
}
