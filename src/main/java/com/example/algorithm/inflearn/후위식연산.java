package com.example.algorithm.inflearn;

import java.util.Scanner;
import java.util.Stack;

public class 후위식연산 {
    public static void main(String[] args) {
        후위식연산 T = new 후위식연산();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.my_solution(str));
    }

    public int my_solution(String str) {
        int answer = 0;
        Stack<String> stack = new Stack<>();

        int op1 = 0;
        int op2 = 0;
        for(String s : str.split("")) {
            switch(s) {
                case "+":
                    stack.push(String.valueOf(Integer.valueOf(stack.pop()) + Integer.valueOf(stack.pop())));
                    break;
                case "-":
                    op2 = Integer.valueOf(stack.pop());
                    op1 = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(op1 - op2));
                    break;
                case "*":
                    stack.push(String.valueOf(Integer.valueOf(stack.pop()) * Integer.valueOf(stack.pop())));
                    break;
                case "/":
                    op2 = Integer.valueOf(stack.pop());
                    op1 = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(op1 / op2));
                    break;
                default:
                    stack.push(s);
            }
        }
        answer = Integer.valueOf(stack.pop());

        return answer;
    }

    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(Character.isDigit(x)) stack.push(x - 48);
            else {
                int rt = stack.pop();
                int lt = stack.pop();
                if(x == '+') stack.push(lt + rt);
                else if(x == '-') stack.push(lt - rt);
                else if(x == '*') stack.push(lt * rt);
                else if(x == '/') stack.push(lt / rt);
            }
        }
        answer = stack.get(0);

        return answer;
    }
}
