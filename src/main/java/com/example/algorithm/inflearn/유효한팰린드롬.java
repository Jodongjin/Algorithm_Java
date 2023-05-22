package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 유효한팰린드롬 {
    public static void main(String[] args) {
        유효한팰린드롬 T = new 유효한팰린드롬();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(T.solution(str));
    }

    public String my_solution(String str) {
        String answer = "NO";
        char[] arr = str.toCharArray();
        String tmp = "";

        for(int i = 0; i < arr.length; i++) {
            if(Character.isAlphabetic(arr[i]))
                tmp += arr[i];
        }
        if(tmp.equalsIgnoreCase(new StringBuilder(tmp).reverse().toString()))
            answer = "YES";

        return answer;
    }

    public String solution(String s) {
        String answer = "NO";
        s = s.toUpperCase().replaceAll("[^A-Z]", ""); // A-Z가 아닌 문자 제거
        String tmp = new StringBuilder(s).reverse().toString();
        if(s.equals(tmp))
            answer = "YES";

        return answer;
    }
}
