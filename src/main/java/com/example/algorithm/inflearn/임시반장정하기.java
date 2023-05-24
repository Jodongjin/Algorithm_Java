package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 임시반장정하기 {
    public static void main(String[] args) {
        임시반장정하기 T = new 임시반장정하기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        /*
        int[][] arr = new int[n][5];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 5; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
         */
        int[][] arr = new int[n + 1][6];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 5; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }

    public int my_solution(int n, int[][] arr) {
        int answer = 0;
        int[] sameCnt = new int[n];

        for(int i = 0; i < 5; i++) { // 학년
            for(int j = 0; j < n; j++) { // 사람
                for(int k = 0; k < n; k++) { // 비교할 사람
                    if(arr[j][i] == arr[k][i] && j != k) // 반이 같고 같은 사람이 아니면
                        sameCnt[j]++;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(sameCnt[i] > answer)
                answer = i + 1;
        }

        return answer;
    }

    public int solution(int n, int[][] arr) {
        int answer = 0, max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) { // 학생 번호
            int cnt = 0;
            for(int j = 1; j <= n; j++) { // 비교 대상 학생 번호
                // i != j 안 해도 모든 학생에 대해 자기 자신을 더하기 때문에 상관 x
                for(int k = 1; k <= 5; k++) { // 학년
                    if(arr[i][k] == arr[j][k]) {
                        cnt++;
                        break; // 한 학년이라도 같으면 해당 학생을 다른 학년에서 중복 count 하지 않기 위해 break
                    }
                }
            }
            if(cnt > max) {
                max = cnt;
                answer = i;
            }
        }

        return answer;
    }
}
