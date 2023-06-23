package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 뒤에있는큰수찾기 {
    public static void main(String[] args) {
        뒤에있는큰수찾기 T = new 뒤에있는큰수찾기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++)
            numbers[i] = kb.nextInt();

        System.out.println(Arrays.toString(T.solution(numbers)));
    }

    /**
     * 4개 시간초과
     */
    public int[] my_solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            boolean check = false;
            for(int j = i + 1; j < numbers.length; j++) {
                if(numbers[i] < numbers[j]) {
                    answer[i] = numbers[j];
                    check = true;
                    break;
                }
            }
            if(!check) answer[i] = -1;
        }

        return answer;
    }

    /**
     * 좀 더 빠른 코드
     */
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[numbers.length];

        for(int i=0 ; i<numbers.length ; i++) {
            // 하강 직선일 때는 push
            if(stack.isEmpty() || numbers[i]<numbers[i-1]) {
                stack.push(i);
            } else {
                // 현재값보다 작은 index는 pop하여 현재값으로
                while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]) {
                    ret[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }
        }
        // 나머지는 -1
        while(!stack.isEmpty()) {
            ret[stack.pop()] = -1;
        }
        return ret;
    }
}

