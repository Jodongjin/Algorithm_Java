package com.example.algorithm.inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * #, *로 이루어진 7자리 == 알파벳 1글자
 * #은 2진수의 1, *은 0
 * 2진수르 10진수화, 10진수화 한 아스키 코드가 문자
 */
public class 암호 {
    public static void main(String[] args) {
        암호 T = new 암호();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();

        System.out.println(T.solution(n, str));
    }

    public String my_solution(int n, String str) {
        String answer = "";
        String binary = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '#')
                binary += String.valueOf(1);
            else
                binary += String.valueOf(0);
        }

        for(int i = 0; i < str.length(); i += 7) {
            String temp = binary.substring(i, i + 7);
            int asciiNum = Integer.parseInt(temp, 2);
            answer += (char) asciiNum;
        }

        return answer;
    }

    public String solution(int n, String s) {
        String answer = "";
        for(int i = 0; i < n; i++) {
            String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2); // 2진수 문자열을 10진수 숫자로
            answer += (char) num;
            s = s.substring(7); // 0 ~ 6 자르기
        }

        return answer;
    }
}
