package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 피보나치재귀 {
    static int[] fibo;
    public static void main(String[] args) {
        피보나치재귀 T = new 피보나치재귀();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        /**
         * for(int i = 1; i <= n; i++) System.out.print(T.DFS(i) + " ");
         * 위 처럼 출력하면 오래걸림 -> DFS(n)을 호출하면 1 ~ n까지 모두 호출되기 때문에 DFS()에서 출력
         */

        fibo = new int[n + 1]; // idx 1부터 사용
        T.DFS(n);
        for(int i = 1; i <= n; i++) System.out.print(fibo[i] + " ");
    }

    public int DFS(int n) {
        if(fibo[n] > 0) return fibo[n]; // 이미 방문한 숫자라면 재귀 더 뻗을 필요 x -> 시간 많이 감소
        if(n == 1) return fibo[n] = 1; // 대입식 return 가능
        else if(n == 2) return fibo[n] = 1;
        else return fibo[n] = DFS(n - 2) + DFS(n - 1);
    }
}

/**
 * 이러한 기술을 "메모이제이션"이라고 함
 * 재귀 문제에서 중복 호출을 방지하기 위해 메모리를 마련해서 값을 저장하는 것
 */
