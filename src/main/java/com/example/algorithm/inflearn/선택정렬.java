package com.example.algorithm.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class 선택정렬 {
    public static void main(String[] args) {
        선택정렬 T = new 선택정렬();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = kb.nextInt();

        System.out.println(Arrays.toString(T.my_solution(n, arr)));
    }

    public int[] my_solution(int n, int[] arr) {
        int[] answer = new int[n];

        for(int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[minIdx])
                    minIdx = j;
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }

        for(int i = 0; i < n; i++)
            answer[i] = arr[i];

        return answer;
    }

    public int[] solution(int n, int[] arr) {
        for(int i = 0; i < n - 1; i++) {
            int idx = i;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[idx]) idx = j;
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }

        return arr;
    }
}
