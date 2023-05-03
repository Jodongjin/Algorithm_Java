package com.example.algorithm.programmers;

import java.util.Arrays;

public class 주식가격 {
    public static void main(String[] args) {
        int[] answer = solution(new int[]{1, 2, 3, 2, 3});
        System.out.println("answer = " + Arrays.toString(answer));
    }
    /**
     * 문제를 이해하는 게 중요한 문제
     * 총 몇 초 동안 떨어지지 않았냐가 아니라 연속적으로 떨어지지 않은 초를 구하는 것
     */
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if(prices[i] > prices[j])
                    break;
            }
        }

        return answer;
    }
}
