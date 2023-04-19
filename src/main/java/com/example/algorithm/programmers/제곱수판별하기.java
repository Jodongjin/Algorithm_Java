package com.example.algorithm.programmers;

public class 제곱수판별하기 {
    public static void main(String[] args) {
        int answer = solution(144);
        System.out.println("answer = " + answer);
    }

    public static int solution(int n) {
        int answer = 0;

        if(n % Math.sqrt(n) == 0) answer = 1;
        else answer = 2;

        return answer;
    }
}
