package com.example.algorithm.inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) {
        올바른괄호 T = new 올바른괄호();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.my_solution(str));
    }

    public String my_solution(String str) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();
        for(char c : str.toCharArray()) {
            queue.add(c);
        }

        int cnt = 0;
        while (queue.size() > 0) {
            if(queue.poll() == '(')
                cnt++;
            else
                cnt--;

            if(cnt < 0) {
                answer =  "NO";
                break;
            }
        }
        if(cnt > 0)
            answer = "NO";

        return answer;
    }

    public String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c == '(')
                stack.push(c);
            else {
                if(stack.isEmpty()) // 닫힌 괄호가 더 많을 때
                    return "NO";
                else
                    stack.pop();
            }
        }
        if(!stack.isEmpty()) // 열린 괄호가 더 많을 때
            return "NO";

        return answer;
    }
}
