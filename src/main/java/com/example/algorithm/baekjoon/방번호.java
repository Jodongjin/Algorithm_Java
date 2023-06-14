package com.example.algorithm.baekjoon;

import java.util.Scanner;

public class 방번호 {
    public static void main(String[] args) {
        방번호 T = new 방번호();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.my_solution(str));
    }

    public int my_solution(String str) {
        int answer = 0;
        int[] arr = new int[10]; // 0 ~ 9

        for(String s : str.split("")) {
            int n = Integer.valueOf(s);
            if(n == 6 || n == 9)
                arr[6]++;
            else
                arr[n]++;
        }
        arr[6] = (int) Math.round((double) arr[6] / 2);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 10; i++) {
            if(arr[i] > max)
                max = arr[i];
        }

        answer = max;

        return answer;
    }
}
