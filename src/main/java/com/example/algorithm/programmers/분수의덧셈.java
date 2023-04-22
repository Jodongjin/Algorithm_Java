package com.example.algorithm.programmers;

import java.util.Arrays;

public class 분수의덧셈 {
    public static void main(String[] args) {
        int[] answer = solution(1, 2, 3, 4);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    public static int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int sumDenom = denom1 * denom2;
        int sumNumer = (numer1 * (sumDenom / denom1)) + (numer2 * (sumDenom / denom2));

        int min = Math.min(sumDenom, sumNumer);
        for(int i = min; i > 1; i--) {
            while(sumDenom % i == 0 && sumNumer % i == 0) {
                sumDenom /= i;
                sumNumer /= i;
            }
        }
        answer[0] = sumNumer;
        answer[1] = sumDenom;

        return answer;
    }
}
