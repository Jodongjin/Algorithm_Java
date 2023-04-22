package com.example.algorithm.programmers;

public class 다음에올숫자 {
    public static void main(String[] args) {
        int answer = solution(new int[] {1, 2, 3, 4});
        System.out.println("answer = " + answer);
    }

    /**
     * 등차 수열인지 등비 수열인지 구분
     * 등차 or 등비로 다음 숫자 return
     */
    public static int solution(int[] common) {
        int answer = 0;

        if(common[1] - common[0] == common[2] - common[1]) { // 등차
            answer = common[common.length - 1] + (common[1] - common[0]);
        } else { // 등비
            answer = common[common.length - 1] * (common[1] / common[0]);
        }

        return answer;
    }
}
