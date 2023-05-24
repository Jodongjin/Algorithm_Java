package com.example.algorithm.inflearn;

import java.util.Map;
import java.util.Scanner;

public class 격자판최대합 {
    public static void main(String[] args) {
        격자판최대합 T = new 격자판최대합();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.my_solution(n, arr));
    }

    public int my_solution(int n, int[][] arr) {
        int answer = 0;

        int[] rowSum = new int[n];
        int[] colSum = new int[n];
        int[] oppSum = new int[2];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                rowSum[i] += arr[i][j];
                colSum[j] += arr[i][j];
                if(i == j)
                    oppSum[0] += arr[i][j];
            }
        }
        oppSum[1] = arr[0][4] + arr[1][3] + arr[2][2] + arr[3][1] + arr[4][0];

        for(int sum : rowSum) {
            if(sum > answer)
                answer = sum;
        }
        for(int sum : colSum) {
            if(sum > answer)
                answer = sum;
        }
        for(int sum : oppSum) {
            if(sum > answer)
                answer = sum;
        }

        return answer;
    }

    public int solution(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;
        for(int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for(int j = 0; j < n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }
        sum1 = sum2 = 0;
        for(int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n - i - 1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }
}
