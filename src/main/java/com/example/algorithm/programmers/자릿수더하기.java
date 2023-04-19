package com.example.algorithm.programmers;

public class 자릿수더하기 {
    public static void main(String[] args) {
        int answer = solution(1234);
        System.out.println("answer = " + answer);
    }

    public static int solution(int n) {
        int answer = 0;

        String str = Integer.toString(n);

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            answer += Character.getNumericValue(c);
        }

        return answer;
    }
}
