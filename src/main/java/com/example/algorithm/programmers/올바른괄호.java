package com.example.algorithm.programmers;

import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) {
        boolean answer = solution("(())()");
        System.out.println("answer = " + answer);
    }
    /**
     * s.split() -> 한 문자 배열로 선언
     * isOpen, isClose boolean으로 배열 loop하면서 조건문 비교하면 될 듯 ?
     * answer = false일 때: 오픈 상태가 아닌데 닫힘 괄호가 왔을 때, 오픈 괄호의 개수만큼 닫힘 괄호가 없을 때
     *
     * 시간 초과
     */
    public static boolean solution(String s) {
        boolean answer = true;
        String[] arr = s.split("");
        boolean isOpen = false;

        int cnt = 0; // 오픈 괄호의 수 == 필요한 닫힘 괄호의 수
        for(String str : arr) {
            if(!isOpen && str.equals(")"))
                answer = false;
            else if(!isOpen && str.equals("(")) { // 오픈 상태가 아니고, "("로 시작하면 오픈, cnt 증가
                isOpen = true;
                cnt++;
            }
            else if (isOpen && str.equals("(")) // 오픈 상태이고, "("로 시작하면 cnt++
                cnt++;
            else if(isOpen && str.equals(")")) { // 오픈 상태이고, ")"로 시작하면 cnt--
                cnt--;
                if(cnt == 0) // 닫힘이 왔는데 cnt가 0이라면, 오픈 상태 거짓으로 변경
                    isOpen = false;
            }

            if(cnt < 0) // 닫힘이 더 많음
                answer = false;
        }
        if(isOpen) // 마지막이 오픈 상태이면 거짓
            answer = false;

        return answer;
    }

    /**
     * Stack을 활용
     * "("일 때 push, ")"일 때 pop
     * pop 할 게 없으면 answer = false
     *
     * 시간 초과...
     */
    public static boolean solution_1(String s) {
        boolean answer = true;
        String[] arr = s.split("");
        Stack<String> stack = new Stack<>();

        for(String str : arr) {
            if(str.equals("("))
                stack.push(str);
            else if(str.equals(")")) {
                if(stack.isEmpty())
                    answer = false;
                else
                    stack.pop();
            }
        }
        if(!stack.isEmpty())
            answer = false;

        return answer;
    }

    /**
     * 통과, String.split()이 시간 많이 잡는 듯
     */
    public static boolean solution2(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                stack.push(s.charAt(i));
            else {
                if(stack.isEmpty())
                    answer = false;
                else
                    stack.pop();
            }
        }
        if(!stack.isEmpty())
            answer = false;

        return answer;
    }
}
