package com.example.algorithm.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class 봉우리 {
    public static void main(String[] args) {
        봉우리 T = new 봉우리();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }

    public int my_solution(int n, int[][] arr) {
        int answer = 0;
        int[][] arr2 = new int[n + 2][n + 2];

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                arr2[i][j] = arr[i - 1][j - 1];
            }
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(arr2[i][j] > arr2[i - 1][j] && arr2[i][j] > arr2[i + 1][j]
                && arr2[i][j] > arr2[i][j - 1] && arr2[i][j] > arr2[i][j + 1])
                    answer++;
            }
        }

        return answer;
    }

    /**
     * 순회할 idx를 미리 정의
     */
    int[] dx = {-1, 0, 1, 0}; // i(행)
    int[] dy = {0, 1, 0, -1}; // j(열)
    public int solution(int n, int[][] arr) {
        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                boolean flag = true;
                for(int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n // 참조하기 전에 걸러야 함 !
                    && arr[nx][ny] > arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    answer++;
            }
        }

        return answer;
    }
}
