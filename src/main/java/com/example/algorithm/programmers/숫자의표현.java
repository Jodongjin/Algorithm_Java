package com.example.algorithm.programmers;

import java.util.Scanner;

public class 숫자의표현 {
    public static void main(String[] args) {
        숫자의표현 T = new 숫자의표현();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.println(T.my_solution(n));
    }

    public int my_solution(int n) {
        int answer = 0;

        for(int i = 1; i <= n / 2; i++) {
            int sum = 0;
            for(int j = i; j <= n / 2 + 1; j++) {
                sum += j;
                if(sum == n) {
                    answer++;
                    break;
                } else if(sum > n)
                    break;
            }
        }
        answer++; // 자기 자신

        return answer;
    }
}
