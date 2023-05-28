package com.example.algorithm.inflearn;

import java.util.Scanner;
import java.util.Stack;

public class 괄호문자제거 {
    public static void main(String[] args) {
        괄호문자제거 T = new 괄호문자제거();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }

    public String my_solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c == '(')
                stack.push(c);
            else if(c == ')')
                stack.pop();
            else { // 문자일 때
                if(stack.isEmpty()) // 스택이 비었다면 (괄호에 포함되지 않는 문자)
                    answer += c;
            }
        }

        return answer;
    }

    /**
     * '(' && 문자 -> push
     * ')' -> '(' 만날 때까지 pop
     * 마지막은 괄호에 포함되지 않는 문자들만 남음
     *
     * stack.get(i): index로 조회
     * for(char c : stack) 또한 가능
     * stack.pop() -> return popped value
     */
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(x == ')') {
                while (stack.pop() != '('); // 마지막 pop은 '(' (조건문에서 '('도 pop)
            }
            else
                stack.push(x);
        }
        for(int i = 0; i < stack.size(); i++) answer += stack.get(i);

        /*
        for(char x : stack) {
            answer += x;
        }
         */

        return answer;
    }
}
