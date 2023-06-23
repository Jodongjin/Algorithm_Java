package com.example.algorithm.programmers;

import java.util.Scanner;

public class 모음사전 {
    public static void main(String[] args) {
        모음사전 T = new 모음사전();
        Scanner kb = new Scanner(System.in);
        String word = kb.next();

        System.out.println(T.solution(word));
    }

    /**
     * 5 번째 자리는 1씩 증가
     * 4 번째 자리는 6씩 증가
     * 3 번째 자리는 31씩 증가
     * 즉, 자리수가 왼쪽으로 갈 수록 * 5 + 1씩 증가
     * 알파벳의 순서와 자리를 고려하여 계산
     *
     * 처음에 answer = word.length()로 초기화
     */
    public String mapping = "AEIOU";
    public int[] rate_increase = {781, 156, 31, 6, 1};
    public int solution(String word) {
        int answer = word.length();

        for(int i = 0; i < word.length(); i++)
            answer += rate_increase[i] * mapping.indexOf(word.charAt(i));

        return answer;
    }
}
