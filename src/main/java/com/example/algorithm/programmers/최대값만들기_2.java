package com.example.algorithm.programmers;

import java.util.Arrays;

public class 최대값만들기_2 {
    public static void main(String[] args) {
        int answer = solution(new int[]{1, 2, -3, 4, -5});
        System.out.println("answer = " + answer);
    }

    public static int solution(int[] numbers) {
        int len = numbers.length;
        Arrays.sort(numbers);
        return Math.max(numbers[0] * numbers[1], numbers[len - 2] * numbers[len - 1]);
    }
}
