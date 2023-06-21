package com.example.algorithm.programmers;

import javax.security.auth.login.CredentialNotFoundException;
import java.util.Arrays;

public class 땅따먹기 {
    public static void main(String[] args) {
        땅따먹기 T = new 땅따먹기();
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};

        System.out.println(T.solution(land));
    }

    /**
     * 문제를 깊게 이해하지 못 한 코드
     * 이전의 값이 최대값이 아니어도 다음 값이 이전 값에서 최대값을 선택한 것 이상의 값을 만들 수 있는 경우가 있음
     */
    public int my_solution(int[][] land) {
        int answer = 0;
        int[] prev = new int[land.length];
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for(int i = 0; i < 4; i++) {
            if(land[0][i] > max) {
                max = land[0][i];
                maxIdx = i;
            }
        }
        prev[0] = maxIdx;
        answer += max;

        for(int i = 1; i < land.length; i++) {
            max = Integer.MIN_VALUE;
            maxIdx = Integer.MIN_VALUE;
            for(int j = 0; j < 4; j++) {
                if(land[i][j] > max && prev[i - 1] != j) {
                    max = land[i][j];
                    maxIdx = j;
                }
            }
            prev[i] = maxIdx;
            answer += max;
        }

        return answer;
    }

    /**
     * DP
     */
    public int solution(int[][] land) {
        int answer = 0;

        for(int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }

        for(int i = 0; i < 4; i++) {
            if(answer < land[land.length - 1][i])
                answer = land[land.length - 1][i];
        }

        return answer;
    }
}
