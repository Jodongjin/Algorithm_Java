package com.example.algorithm.programmers;

import java.util.Arrays;

public class 정수삼각형 {
    public static void main(String[] args) {
        정수삼각형 T = new 정수삼각형();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        System.out.println(T.solution(triangle));
    }

    /**
     * 충분한 크기의 matrix를 마련해둘 것
     * Max 값을 판단하며 점진적으로 증가해야 함
     */
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            // 맨 왼쪽
            dp[i][0] = dp[i - 1][0] + triangle[i][0];

            // 중간
            for (int j = 1; j <= i; j++) {
                // dp는 0으로 초기화된 triangle.length의 열을 갖고 있기에 두 번째 행에서 dp[i - 1][j] = 0으로 접근 가능 !
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }

            // 맨 오른쪽
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        int answer = 0;

        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, dp[triangle.length - 1][i]);
        }

        return answer;
    }

    /**
     * metrix를 따로 정의하지 않고 triangle에 덮어씌우는 방식 !
     */
    public int solution2(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0]; // 왼쪽 끝
            triangle[i][i] += triangle[i-1][i-1]; // 오른쪽 끝
            for (int j = 1; j < i; j++) // 중간 값
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }

        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }
}