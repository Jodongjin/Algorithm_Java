package com.example.algorithm.programmers;

import java.util.Arrays;

public class 행렬의곱셈 {
    public static void main(String[] args) {
        행렬의곱셈 T = new 행렬의곱셈();
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};

        for(int[] arr : T.solution(arr1, arr2))
            System.out.println(Arrays.toString(arr));
    }

    /**
     * 행렬의 곱 개념을 몰랐다 ,, ㅜㅜ
     */
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i = 0; i < arr1.length; i++)
            for(int j = 0; j < arr2[0].length; j++) {
                int temp = 0;
                for (int k = 0; k < arr2.length; k++)
                    temp += arr1[i][k] * arr2[k][j];

                answer[i][j] = temp;
            }
        return answer;
    }
}
