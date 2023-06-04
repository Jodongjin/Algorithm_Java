package com.example.algorithm.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class 버블정렬 {
    public static void main(String[] args) {
        버블정렬 T = new 버블정렬();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = kb.nextInt();

        System.out.println(Arrays.toString(T.my_solution(n, arr)));
    }

    /**
     * i -> n - 1 번까지만 해도 됨
     */
    public int[] my_solution(int n, int[] arr) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }

    public int[] solution(int n, int[] arr) {
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        return arr;
    }
}
