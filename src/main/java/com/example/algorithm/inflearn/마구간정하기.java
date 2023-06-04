package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 마구간정하기 {
    public static void main(String[] args) {
        마구간정하기 T = new 마구간정하기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int c = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = kb.nextInt();

        System.out.println(T.my_solution(n, c, arr));
    }

    public int my_solution(int n, int c, int[] arr) {
        int answer = 0;

        return answer;
    }
}
