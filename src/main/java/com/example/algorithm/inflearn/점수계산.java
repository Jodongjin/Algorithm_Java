package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 점수계산 {
    public static void main(String[] args) {
        점수계산 T = new 점수계산();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }

    public int my_solution(int n, int[] arr) {
        int answer = 0;
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) { // 오답일 때
                int score = 0;
                for(int j = 1; j <= cnt; j++)
                    score += j;
                answer += score;
                cnt = 0;
            }
            else { // 정답일 때
                cnt++;
            }
        }

        return answer;
    }

    /**
     * 1을 만나면 cnt++, sum 누적
     */
    public int solution(int n, int[] arr) {
        int answer = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 1) {
                cnt++;
                answer += cnt;
            }
            else
                cnt = 0;
        }

        return answer;
    }
}
