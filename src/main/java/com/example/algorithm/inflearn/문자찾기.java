package com.example.algorithm.inflearn;

import com.example.algorithm.Test;

import java.util.Scanner;

public class 문자찾기 {
    public static void main(String[] args) {
        Test T = new Test();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);

        System.out.print(T.solution(str, c));
    }

    public int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == t)
                answer++;
        }

        return answer;
    }
}
