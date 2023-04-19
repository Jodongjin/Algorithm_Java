package com.example.algorithm.programmers;

public class 대문자와소문자 {
    public static void main(String[] args) {
        String answer = solution("cccCCC");
        System.out.println("answer = " + answer);
    }

    public static String solution(String my_string) {
        String answer = "";

        for(int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);

            if(c >= 97) {
                answer += String.valueOf(c).toUpperCase();
            } else {
                answer += String.valueOf(c).toLowerCase();
            }
        }

        return answer;
    }
}
