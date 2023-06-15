package com.example.algorithm.programmers;

import java.util.Scanner;

public class 최솟값만들기 {
    public static void main(String[] args) {
        최솟값만들기 T = new 최솟값만들기();
        Scanner kb = new Scanner(System.in);
        int aLen = kb.nextInt();
        int bLen = kb.nextInt();
        int[] a = new int[aLen];
        int[] b = new int[bLen];

        System.out.println(T.my_solution(a, b));
    }

    public int my_solution(int[] a, int[] b) {
        int answer = 0;

        return answer;
    }
}
