package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 팩토리얼 {
    public static void main(String[] args) {
        팩토리얼 T = new 팩토리얼();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.println(T.my_DFS(n));
    }

    public int my_DFS(int n) {
        if(n == 1) return 1;
        return n * my_DFS(n - 1);
    }

    public int DFS(int n) {
        if(n == 1) return 1;
        else return n * DFS(n - 1);
    }
}
