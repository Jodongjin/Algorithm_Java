package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class 최댓값과최솟값 {
    public static void main(String[] args) {
        최댓값과최솟값 T = new 최댓값과최솟값();
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine();

        System.out.println(T.my_solution(s));
    }

    public String my_solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(String str : arr) {
            int n = Integer.valueOf(str);
            if(n > max) max = n;
            if(n < min) min = n;
        }
        answer += min + " " + max;

        return answer;
    }
}
