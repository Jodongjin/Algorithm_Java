package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 문자열압축 {
    public static void main(String[] args) {
        문자열압축 T = new 문자열압축();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.solution(str));
    }

    public String my_solution(String str) {
        String answer = "";
        answer += str.charAt(0);
        char[] arr = str.toCharArray();

        int cnt = 1;
        int answerIdx = 0;
        for(int i = 1; i < arr.length; i++) {
            if(answer.charAt(answerIdx) == str.charAt(i))
                cnt++;
            else {
                if(cnt > 1) {
                    answer += String.valueOf(cnt);
                    answerIdx++;
                }
                answer += str.charAt(i);
                cnt = 1;
                answerIdx++;
            }
        }

        return answer;
    }

    /**
     * cnt = 1
     * i == i + 1을 비교
     * 같으면 cnt++
     * 다르면 i 번째의 문자와 cnt를 연속으로 출력, cnt = 1 초기화
     * 반복
     * 마지막 문자를 비교하기 위해 배열 요소를 빈 문자로 하나 추가
     */
    public String solution(String s) {
        String answer = "";
        s = s + " "; // 마지막 요소에 공백
        int cnt = 1;

        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1))
                cnt++;
            else {
                answer += s.charAt(i);
                if(cnt > 1)
                    answer += String.valueOf(cnt); // == Integer.toString(cnt)
                cnt = 1;
            }
        }

        return answer;
    }
}
