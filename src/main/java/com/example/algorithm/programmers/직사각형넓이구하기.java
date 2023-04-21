package com.example.algorithm.programmers;

public class 직사각형넓이구하기 {
    public static void main(String[] args) {
        int answer = solution(new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}});
        System.out.println("answer = " + answer);
    }

    public static int solution(int[][] dots) {
        int answer = 0;

        int xLen = 0;
        int yLen = 0;
        for(int i = 0; i < 4; i++) {
            if(dots[0][0] != dots[i][0] && dots[0][1] == dots[i][1]) { // y값이 같을 때
                xLen = Math.abs(dots[0][0] - dots[i][0]);
            } else if(dots[0][1] != dots[i][1] && dots[0][0] == dots[i][0]) { // x값이 같을 때
                yLen = Math.abs(dots[0][1] - dots[i][1]);
            }
        }
        answer = xLen * yLen;

        return answer;
    }
}
