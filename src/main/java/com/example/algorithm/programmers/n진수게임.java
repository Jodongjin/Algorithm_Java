package com.example.algorithm.programmers;

import java.util.Scanner;

public class n진수게임 {
    public static void main(String[] args) {
        n진수게임 T = new n진수게임();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int t = kb.nextInt();
        int m = kb.nextInt();
        int p = kb.nextInt();

        System.out.println(T.my_solution(n, t, m, p));
    }

    public String my_solution(int n, int t, int m, int p) {
        String answer = "";
        String tmp = "";

        for(int i = 0; i <= t * m; i++)
            tmp += Integer.toString(i, n);
        tmp = tmp.toUpperCase();

        int idx = 0;
        while(answer.length() < t) {
            if(idx % m == (p - 1)) answer += tmp.charAt(idx);
            idx++;
        }

        return answer;
    }
}
