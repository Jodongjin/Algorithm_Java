package com.example.algorithm.programmers;

import java.util.Arrays;

public class H_Index {
    public static void main(String[] args) {
        int answer = solution2(new int[]{3, 0, 6, 1, 5});
        System.out.println("answer = " + answer);
    }

    public static int solution2(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i; // 현재 논문부터 마지막 논문까지 개수
            if (citations[i] >= h) { // 남은 논문의 수가 현재 논문의 인용된 수보다 작거나 같으면
                answer = h;
                break;
            }
        }

        return answer;
    }
}
