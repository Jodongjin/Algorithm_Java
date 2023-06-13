package com.example.algorithm.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class 스택 {
    public static void main(String[] args) {
        스택 T = new 스택();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] commands = new String[n];
        kb.nextLine();
        for(int i = 0; i < n; i++)
            commands[i] = kb.nextLine();

        T.my_solution(commands);
    }

    /**
     * System.out.println() 시간 초과 -> StringBuillder
     */
    public void my_solution(String[] commands) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(String command : commands) {
            String[] arr = command.split(" ");
            switch (arr[0]) {
                case "push":
                    stack.push(Integer.valueOf(arr[1]));
                    break;
                case "pop":
                    if(stack.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(stack.pop()).append('\n');
                    break;
                case "size":
                    sb.append(stack.size()).append('\n');
                    break;
                case "empty":
                    if(stack.isEmpty())
                        sb.append(1).append('\n');
                    else
                        sb.append(0).append('\n');
                    break;
                default:
                    if(stack.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(stack.peek()).append('\n');
            }
        }

        System.out.println(sb);
    }
}
