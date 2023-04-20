package com.example.algorithm.programmers;

import java.util.Stack;

public class 컨트롤제트 {
    public static void main(String[] args) {
        int answer = solution("1 2 Z 3");
        System.out.println("answer = " + answer);
    }

    public static int solution(String s) {
        int answer = 0;
        int preNum = 0;
        String[] arr = s.split(" ");

        for(String str: arr) {
            if(str.equals("Z")) {
                answer -= preNum;
            } else {
                answer += Integer.valueOf(str);
                preNum = Integer.valueOf(str);
            }
        }

        return answer;
    }

    public static int solution2(String s) {
        int answer = 0;
        String[] arr = s.split(" ");
        Stack<Integer> stack = new Stack<>();

        for(String str: arr) {
            if(str.equals("Z")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(str));
            }
        }

        for(int i: stack) {
            answer += i;
        }

        return answer;
    }
}
