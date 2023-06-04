package com.example.algorithm.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class 삽입정렬 {
    public static void main(String[] args) {
        삽입정렬 T = new 삽입정렬();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = kb.nextInt();

        System.out.println(Arrays.toString(T.solution(n, arr)));
    }

    public int[] my_solution(int n, int[] arr) {
        for(int i = 1; i < n; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                else break;
            }
        }

        return arr;
    }

    /**
     * 더 큰 수가 있으면 바꿔주는 게 아니라 뒤로 미루다가 마지막에 삽입
     */
    public int[] solution(int n, int[] arr) {
        for(int i = 1; i < n; i++) {
            int tmp = arr[i], j;
            for(j = i - 1; j >= 0; j--) {
                if(arr[j] > tmp) arr[j + 1] = arr[j];
                else break;
            }
            arr[j + 1] = tmp;
        }

        return arr;
    }
}
