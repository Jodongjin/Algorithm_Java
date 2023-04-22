package com.example.algorithm.programmers;

import java.util.Arrays;

public class 연속된수의합 {
    public static void main(String[] args) {
        int[] answer = solution(3, 12);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    /**
     * 2로 나눴을 때 나머지가 0이면 나눈 수가 중간 값
     * 나머지가 1이면 나눈 수가 중간에서 왼쪽 값
     */
    public static int[] solution(int num, int total) {
        int[] answer = new int[num];

        if(total % num == 0) {
            int idx = total / num;
            for(int i = 0; i < answer.length; i++) {
                answer[i] = idx - (num / 2);
                idx++;
            }
        } else {
            int idx = total / num;
            for(int i = 0; i < answer.length; i++) {
                answer[i] = idx - (num / 2 - 1);
                idx++;
            }
        }

        return answer;
    }
}
