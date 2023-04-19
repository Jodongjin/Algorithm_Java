package com.example.algorithm.programmers;

import java.util.Arrays;

public class n의배수고르기 {
    public static void main(String[] args) {
        int[] answer = solution(3, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12});
        System.out.println("answer = " + Arrays.toString(answer));
    }

    public static int[] solution(int n, int[] numlist) {
        int[] answer = {};

        answer = Arrays.stream(numlist).filter(num -> num % n == 0).toArray();

        return answer;
    }
}
