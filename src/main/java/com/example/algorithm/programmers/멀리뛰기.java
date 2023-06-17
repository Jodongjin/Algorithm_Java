package com.example.algorithm.programmers;

import java.util.Scanner;

public class 멀리뛰기 {
    public static void main(String[] args) {
        멀리뛰기 T = new 멀리뛰기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        T.solution1(n);
        System.out.println(answer);
    }

    /**
     * recursive -> 시간 초과
     */
    private static long answer = 0;
    private static int aim = 0;
    public void solution1(int n) {
        if(n > aim) return;
        if(n == aim) answer++;
        else {
            solution1(n + 1);
            solution1(n + 2);
        }
    }

    /**
     * DP (Dynamic Programming) : 이전 값 활용
     */
    public long solution2(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        long[] arr =  new long[2001];

        arr[1] = 1;
        arr[2] = 2;

        for(int i = 3; i < 2001; i++)
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;

        return arr[n];
    }
}
