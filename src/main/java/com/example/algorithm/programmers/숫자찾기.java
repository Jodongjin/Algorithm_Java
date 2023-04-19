package com.example.algorithm.programmers;

public class 숫자찾기 {
    public static void main(String[] args) {
        int answer = solution(29183, 1);
        System.out.println("answer = " + answer);
    }

    public static int solution(int num, int k) {
        int answer = 0;

        answer = ("-" + num).indexOf(String.valueOf(k));

        return answer;
    }
}
