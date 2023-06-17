package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 괄호회전하기 {
    public static void main(String[] args) {
        괄호회전하기 T = new 괄호회전하기();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();

        System.out.println(T.my_solution(s));
    }

    public int my_solution(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++) {
            for(char c : arr) {
                if(stack.isEmpty())
                    stack.push(c);
                else {
                    switch (c) {
                        case ']':
                            if(stack.peek() == '[') stack.pop();
                            else stack.push(c);
                            break;
                        case '}':
                            if(stack.peek() == '{') stack.pop();
                            else stack.push(c);
                            break;
                        case ')':
                            if(stack.peek() == '(') stack.pop();
                            else stack.push(c);
                            break;
                        default:
                            stack.push(c);
                    }
                }
            }
            if(stack.isEmpty()) answer++;
            stack.clear();

            char tmp = arr[0];
            for(int j = 0; j < arr.length - 1; j++)
                arr[j] = arr[j + 1];
            arr[arr.length - 1] = tmp;
        }

        return answer;
    }
}
