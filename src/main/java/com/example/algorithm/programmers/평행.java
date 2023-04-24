package com.example.algorithm.programmers;

public class 평행 {
    public static void main(String[] args) {
        int answer = solution(new int[][]{{1, 4}, {9, 2}, {3, 8}, {11, 6}});
        System.out.println("answer = " + answer);
    }

    /**
     * a1 a2 / a3 a4    a1 a3 / a2 a4    a1 a4 / a2 a3    세 가지 경우
     * 각 경우마다 기울기 구해서 비교, 일치하면 answer = 1
     */
    public static int solution(int[][] dots) {
        int answer = 0;

        // case 1
        if((double) (dots[1][1] - dots[0][1]) / (dots[1][0] - dots[0][0]) ==
                (double) (dots[3][1] - dots[2][1]) / (dots[3][0] - dots[2][0]))
            answer = 1;
        else if((double) (dots[2][1] - dots[0][1]) / (dots[2][0] - dots[0][0]) ==
                (double) (dots[3][1] - dots[1][1]) / (dots[3][0] - dots[1][0]))
            answer = 1;
        else if((double) (dots[3][1] - dots[0][1]) / (dots[3][0] - dots[0][0]) ==
                (double) (dots[2][1] - dots[1][1]) / (dots[2][0] - dots[1][0]))
            answer = 1;

        return answer;
    }
}
