package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 중복문자제거 {
    public static void main(String[] args) {
        중복문자제거 T = new 중복문자제거();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.solution(str));
    }

    public String my_solution(String str) {
        String answer = "";
        String[] arr = str.split("");
        for(String s : arr) {
            if(!answer.contains(s))
                answer += s;
        }

        return answer;
    }

    public String solution(String str) {
        String answer = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.indexOf(str.charAt(i)) == i) // 해당 글자가 처음 등장하는 인덱스가 현재 인덱스라면 -> 최초 등장
                answer += str.charAt(i);
        }

        return answer;
    }
}
