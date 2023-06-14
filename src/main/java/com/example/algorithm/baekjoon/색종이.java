package com.example.algorithm.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 색종이 {
    public static void main(String[] args) {
        색종이 T = new 색종이();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            arr[i][0] = x;
            arr[i][1] = y;
        }

        System.out.println(T.my_solution(n, arr));
    }

    public int my_solution(int n, int[][] arr) {
        int answer = 0;
        int[][] dohwaji = new int[101][101];

        for(int[] paper : arr) {
            int x = paper[0];
            int y = paper[1];
            for(int i = x + 1; i <= x + 10; i++) {
                for(int j = y + 1; j <= y + 10; j++) {
                    dohwaji[i][j] = 1;
                }
            }
        }

        for(int i = 1; i <= 100; i++) {
            for(int j = 1; j <= 100; j++) {
                if(dohwaji[i][j] == 1)
                    answer++;
            }
        }

        return answer;
    }
}
