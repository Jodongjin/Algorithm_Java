package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 쇠막대기 {
    public static void main(String[] args) {
        쇠막대기 T = new 쇠막대기();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.my_solution(str));
    }

    /**
     * '(' 직후에 ')' -> 레이저
     * ')' 직후에 ')' -> 쇠막대기--
     * '(' -> 레이저 or 쇠막대기++ (직후가 ')' 이라면 레이저)
     */
    public int my_solution(String str) {
        int answer = 0;

        return answer;
    }
}
