package com.example.algorithm.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class 좌표정렬 {
    public static void main(String[] args) {
        좌표정렬 T = new 좌표정렬();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        for(int[] result : T.my_solution(n, arr)) {
            System.out.println(Arrays.toString(result));
        }
    }

    public int[][] my_solution(int n, int[][] arr) {
        int[][] answer = new int[n][2];

        return answer;
    }
}
