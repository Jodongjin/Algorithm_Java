package com.example.algorithm.programmers;

import java.util.Arrays;

public class 행렬의곱셈 {
    public static void main(String[] args) {
        행렬의곱셈 T = new 행렬의곱셈();
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};

        for(int[] arr : T.my_solution(arr1, arr2))
            System.out.println(Arrays.toString(arr));
    }

    public int[][] my_solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1.length];

        return answer;
    }
}
