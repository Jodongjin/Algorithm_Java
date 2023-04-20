package com.example.algorithm.programmers;

public class 구슬을나누는경우의수 {
    public static void main(String[] args) {
        int answer = solution2(30, 2);
        System.out.println("answer = " + answer);
    }

    public static int solution2(int balls, int share) {
        int answer = 0;
        answer = combination(balls, share);

        return answer;
    }

    public static int combination(int balls, int share) {
        if (balls == share || share == 0) return 1;
        return combination((balls - 1), (share - 1)) + combination(balls - 1, share);
    }
}
