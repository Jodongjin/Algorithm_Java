package com.example.algorithm.programmers;

import java.util.Scanner;
import java.util.Stack;

public class 짝지어제거하기 {
    public static void main(String[] args) {
        짝지어제거하기 T = new 짝지어제거하기();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();

        System.out.println(T.my_solution(s));
    }

    /**
     * 시간 초과
     */
    public int my_solution(String s) {
        boolean check = true;
        while(check) {
            check = false;
            for(int i = 0; i < s.length() - 1; i++) {
                if(s.charAt(i) == s.charAt(i + 1)) {
                    if(s.length() == 2)
                        return 1;
                    else
                        s = s.substring(0, i) + s.substring(i + 2, s.length());
                    check = true;
                }
            }
        }

        return 0;
    }

    public int solution(String s) {
        int answer = -1;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.isEmpty()) stack.push(c);
            else {
                if(stack.peek() == c)
                    stack.pop();
                else
                    stack.push(c);
            }
        }

        answer = stack.isEmpty() ? 1 : 0;

        return answer;
    }
}
