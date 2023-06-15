package com.example.algorithm.programmers;

import java.util.Scanner;

public class 점프와순간이동 {
    public static void main(String[] args) {
        점프와순간이동 T = new 점프와순간이동();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.println(T.solution(n));
    }

    /**
     * top-down
     */
    public int solution(int n) {
        int ans = 0;

        while(n != 0) {
            if(n % 2 == 0) n /= 2;
            else {
                n--;
                ans++;
            }
        }

        return ans;
    }
}
