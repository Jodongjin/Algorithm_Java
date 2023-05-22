package com.example.algorithm.inflearn;

import java.util.*;

public class 문장속단어 {
    public static void main(String[] args) {
        문장속단어 T = new 문장속단어();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine(); // 한 줄 입력

        System.out.print(T.solution(str));
    }

    public String my_solution(String str) {
        String answer = "";
        String[] arr = str.split(" ");

        int cnt = 0;
        for(String s : arr) {
            if(s.length() > cnt) {
                cnt = s.length();
                answer = s;
            }
        }

        return answer;
    }

    public String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE; // Integer 중 가장 작은 값

        /*
        String[] s = str.split(" ");
        for(String x : s) {
            int len = x.length();
            if(len > m) {
                m = len;
                answer = x;
            }
        }
        */

        int pos;
        while ((pos = str.indexOf(' ')) != -1) { // 공백이 발견되지 않을 때까지 반복
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len > m) {
                m = len;
                answer = tmp;
            }
            str = str.substring(pos + 1); // 비교한 문자 지우기
        }
        if(str.length() > m) // 마지막에 남은 문자까지 확인 (마지막 문자는 공백이 없어서 break)
            answer = str;

        return answer;
    }
}
