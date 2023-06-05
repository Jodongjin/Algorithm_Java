package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 이진수출력 {
    public static void main(String[] args) {
        이진수출력 T = new 이진수출력();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        T.my_DFS(n);
    }

    public void my_DFS(int n) {
        if(n == 1 || n == 0) {
            System.out.print(n);
            return;
        }
        my_DFS(n / 2);
        System.out.print(n % 2);
    }

    public void DFS(int n) {
        if(n == 0) return; // 1이 남았을 경우 -> 1 / 2 = 0, 0은 출력하지 않고 1부터 출력하게 됨
        else {
            DFS(n / 2);
            System.out.print(n % 2);
        }
    }
}
