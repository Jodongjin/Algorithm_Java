package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 숫자만추출 {
    public static void main(String[] args) {
        숫자만추출 T = new 숫자만추출();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.my_solution(str));
    }

    public int my_solution(String str) {
        int answer = 0;
        String tmp = "";
        for(char c : str.toCharArray()) {
            if(!Character.isAlphabetic(c))
                tmp += c;
        }
        answer = Integer.valueOf(tmp);

        return answer;
    }

    public int solution(String s) {
        /*
        int answer = 0;
        for(char x : s.toCharArray()) {
            if(x >= 48 && x <= 57) // 숫자이면
                answer = answer * 10 + (x - 48); // 1의자리 비워주면서 삽입
        }
        */

        String answer = "";
        for(char x : s.toCharArray()) {
            if(Character.isDigit(x))
                answer += x;
        }

        return Integer.parseInt(answer); // == Integer.valueOf(answer);
    }
}
