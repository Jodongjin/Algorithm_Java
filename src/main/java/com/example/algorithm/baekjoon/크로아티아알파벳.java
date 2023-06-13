package com.example.algorithm.baekjoon;

import java.util.Scanner;

public class 크로아티아알파벳 {
    String[] alpa = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    public static void main(String[] args) {
        크로아티아알파벳 T = new 크로아티아알파벳();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.my_solution(str));
    }

    public int my_solution(String str) {
        int answer = 0;

        for(String a : alpa) {
            if(str.contains(a))
                str = str.replace(a, "!");
        }

        answer = str.length();

        return answer;
    }
}
