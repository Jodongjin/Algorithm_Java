package com.example.algorithm.programmers;

public class 이진수더하기 {
    public static void main(String[] args) {
        String answer = solution2("10", "11");
        System.out.println("answer = " + answer);
    }

    public static String solution2(String bin1, String bin2) {
        String answer = "";
        answer = Integer.toBinaryString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2));

        return answer;
    }
}
