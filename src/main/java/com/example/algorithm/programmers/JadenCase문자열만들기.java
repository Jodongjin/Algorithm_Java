package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class JadenCase문자열만들기 {
    public static void main(String[] args) {
        JadenCase문자열만들기 T = new JadenCase문자열만들기();
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine();

        System.out.println(T.my_solution(s));
    }

    public String my_solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");

        for(int i = 0; i < arr.length; i++) {
            if(arr[i].length() == 0) answer += " "; // 공백 연속 -> 공백 더하기
            else {
                answer += arr[i].substring(0, 1).toUpperCase();
                answer += arr[i].substring(1, arr[i].length()).toLowerCase();
                answer += " ";
            }
        }

        if(s.substring(s.length() - 1, s.length()).equals(" ")) return answer; // 마지막 문자가 공백이라면 그대로 return
        return answer.substring(0, answer.length() - 1); // 아니라면 띄어쓰기 이므로 지우고 return
    }
}
