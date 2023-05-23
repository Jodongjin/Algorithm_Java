package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 피보나치수열 {
    public static void main(String[] args) {
        피보나치수열 T = new 피보나치수열();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.println(T.my_solution(n));
    }

    public String my_solution(int n) {
        String answer = "1 1";
        int a = 1;
        int b = 1;
        for(int i = 2; i < n; i++) {
            answer += " " + (a + b); // " " 때문에 (a + b) 자동 캐스팅
            int tmp = b;
            b = a + b;
            a = tmp;
        }

        return answer;
    }

    public int[] solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for(int i = 2; i < n; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }

        return answer;

        /*
        return과 배열 없이
        int a = 1, b = 1, c;
        System.out.print(a + " " + b + " ");
        for(int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
         */
    }
}
