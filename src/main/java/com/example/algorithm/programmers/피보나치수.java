package com.example.algorithm.programmers;

import java.util.Scanner;

public class 피보나치수 {
    public static void main(String[] args) {
        피보나치수 T = new 피보나치수();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.println(T.my_solution(n));
    }

    public int my_solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i <= n; i++) {
            int sum = arr[i - 2] + arr[i - 1];
            arr[i] = sum % 1234567;
        }

        answer = arr[n];

        return answer;
    }
}
