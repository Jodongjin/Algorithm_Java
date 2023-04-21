package com.example.algorithm.programmers;

public class 유한소수판별하기 {
    public static void main(String[] args) {
        int answer = solution(12, 21);
        System.out.println("answer = " + answer);
    }

    /**
     * 1. 기약분수화
     * 2. 분모의 소인수가 2와 5로만 이루어져 있는지 판별
     */
    public static int solution(int a, int b) {
        int answer = 0;

        for(int i = Math.min(a, b) == a ? a : b; i > 1; i--) {
            if(a % i == 0 && b % i == 0) {
                while(a % i == 0 && b % i == 0) {
                    a /= i;
                    b /= i;
                }
            }
        }

        // b의 소인수가 2와 5만 있어야 함
        while(b % 2 == 0 || b % 5 == 0) {
            if(b % 2 == 0)
                b /= 2;
            else if(b % 5 == 0)
                b /= 5;
        }
        answer = b > 1 ? 2 : 1;

        return answer;
    }
}
