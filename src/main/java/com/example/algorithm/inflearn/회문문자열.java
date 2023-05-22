package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 회문문자열 {
    public static void main(String[] args) {
        회문문자열 T = new 회문문자열();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.solution(str));
    }

    public String my_solution(String str) {
        String answer = "";
        char[] arr = str.toCharArray();
        for(int i = 0; i < arr.length; i++) { // 대소문자 구분 없애기
            arr[i] = Character.toLowerCase(arr[i]);
        }

        answer = "YES";
        for(int i = 0; i < arr.length / 2; i++) {
            if(arr[i] != arr[arr.length - 1 - i])
                answer = "NO";
        }

        return answer;
    }

    public String solution(String str) {
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp)) // 대소문자 구분 없이 비교
            return "YES";

        /*
        str = str.toUpperCase();
        int len = str.length();
        for(int i = 0; i < len / 2; i++) {
            if(str.charAt(i) != str.charAt(len - i - 1)) {
                return "NO";
            }
        }
        */

        return answer;
    }
}
