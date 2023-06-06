package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 부분집합구하기 {
    static int n;
    static int[] ch;
    public static void main(String[] args) {
        부분집합구하기 T = new 부분집합구하기();
        n = 3;
        ch = new int[n + 1];

        T.DFS(1);
    }

    /**
     * n개 원소의 부분 집합 -> 2^n
     */
    public void DFS(int L) {
        if(L == n + 1) { // 도착
            String tmp = "";
            for(int i = 1; i <= n; i++) {
                if(ch[i] == 1) tmp += (i + " ");
            }
            if(tmp.length() > 0) System.out.println(tmp);
        }
        else {
            // L 원소를 사용 o
            ch[L] = 1;
            DFS(L + 1);

            // L 원소를 사용 x
            ch[L] = 0;
            DFS(L + 1);
        }
    }
}
