package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 재귀함수 {
    public static void main(String[] args) {
        재귀함수 T = new 재귀함수();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        T.my_solution(n);
    }

    public void my_solution(int n) {
        if(n == 0)
            return;
        my_solution(n - 1);
        System.out.print(n + " ");
    }

    /**
     * 재귀 == DFS (깊이 우선 탐색)
     * stack으로 쌓여서 마지막에 호출되는 것부터 역순(back tracking)으로 실행된다고 생각
     * stack frame: 매개 변수, 지역 변수, 복귀 주소 등으로 구성
     */
    public void DFS(int n) {
        if(n == 0) return;
        else {
            DFS(n - 1);
            System.out.print(n + " ");
        }
    }
}
