package com.example.algorithm.baekjoon;

import java.util.Scanner;

public class 럭키스트레이트 {
    public static void main(String[] args) {
        럭키스트레이트 T = new 럭키스트레이트();
        Scanner kb = new Scanner(System.in);
        int score = kb.nextInt();

        System.out.println(T.my_solution(score));
    }

    public String my_solution(int score) {
        int len = String.valueOf(score).length();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++)
            arr[i] = Integer.valueOf(String.valueOf(score).charAt(i));

        int sum = 0;
        for(int i = 0; i < len; i++) {
            if(i < len / 2)
                sum += arr[i];
            else
                sum -= arr[i];
        }

        return sum == 0 ? "LUCKY" : "READY";
    }
}
