package com.example.algorithm.baekjoon;

import java.util.Scanner;

public class 분수찾기 {
    public static void main(String[] args) {
        분수찾기 T = new 분수찾기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.println(T.solution(n));
    }

    public String solution(int n) {
        int line = 0;
        int cnt = 0;
        int top = 0;
        int bottom = 0;

        while(cnt < n) {
            line++;
            cnt = line * (line + 1) / 2;
        }

        /**
         * 홀수 분자 & 짝수 분모 = n이 속한 line까지의 총 개수 - n + 1
         * 홀수 분모 & 짝수 분자는 모르겠음 ,,
         */
        if(line % 2 != 0) { // 홀수 라인
            // 분자 + 분모 = 1 + line
            top = 1 + cnt - n; // 분자 = 1 + line(line+1)/2 - x;
            bottom = line + n - cnt; // 분모 = 1 + line - 분자
        } else {
            bottom = 1 + cnt - n;
            top = line + n - cnt;
        }

        return top + "/" + bottom;
    }
}
