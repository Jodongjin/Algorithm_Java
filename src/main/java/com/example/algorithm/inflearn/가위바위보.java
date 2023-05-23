package com.example.algorithm.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class 가위바위보 {
    public static void main(String[] args) {
        가위바위보 T = new 가위바위보();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        for(int i = 0; i < n; i++) {
            arrA[i] = kb.nextInt();
        }
        for(int i = 0; i < n; i++) {
            arrB[i] = kb.nextInt();
        }

        for(char x : T.solution(n, arrA, arrB).toCharArray()) {
            System.out.println(x);
        }
    }

    /**
     * 1: 가위, 2: 바위, 3: 보
     * 차가 1일 경우, 수가 크면 승리
     * 차가 2일 경우, 수가 작으면 승리
     */
    public char[] my_solution(int n, int[] arrA, int[] arrB) {
        char[] answer = new char[n];

        for(int i = 0; i < n; i++) {
            if(arrA[i] == arrB[i])
                answer[i] = 'D';
            else if(Math.abs(arrA[i] - arrB[i]) == 1) { // 차가 1일 때
                if(arrA[i] > arrB[i])
                    answer[i] = 'A';
                else
                    answer[i] = 'B';
            } else { // 차가 2일 때
                if(arrA[i] < arrB[i])
                    answer[i] = 'A';
                else
                    answer[i] = 'B';
            }
        }

        return answer;
    }

    /**
     * 비기는 경우
     * A가 이기는 경우 3가지
     * 나머지는 B가 이기는 경우
     */
    public String solution(int n, int[] a, int[] b) {
        String answer = "";
        for(int i = 0; i < n; i++) {
            if(a[i] == b[i])
                answer += "D";
            else if(a[i] == 1 && b[i] == 3)
                answer += "A";
            else if(a[i] == 2 && b[i] == 1)
                answer += "A";
            else if(a[i] == 3 && b[i] == 2)
                answer += "A";
            else
                answer += "B";
        }

        return answer;
    }
}
