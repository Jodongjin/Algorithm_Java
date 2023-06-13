package com.example.algorithm.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class 제로 {
    public static void main(String[] args) {
        제로 T = new 제로();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = kb.nextInt();

        System.out.println(T.my_solution(n, arr));
    }

    public int my_solution(int n, int[] arr) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i : arr) {
            if(i == 0)
                stack.pop();
            else
                stack.push(i);
        }

        for(int i : stack)
            answer += i;

        return answer;
    }
}
