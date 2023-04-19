package com.example.algorithm.programmers;

import java.util.Arrays;

public class _2차원으로만들기 {
    public static void main(String[] args) {
        int[][] answer = solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2);
        System.out.println("answer = " + Arrays.deepToString(answer));
    }

    public static int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];

        int startIdx = 0;
        for(int i = 0; i < num_list.length / n; i++) {
            answer[i] = Arrays.copyOfRange(num_list, startIdx, startIdx + n);
            startIdx += n;
        }

        return answer;
    }
}
