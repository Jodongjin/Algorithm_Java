package com.example.algorithm.inflearn;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기 {
    public static void main(String[] args) {
        쇠막대기 T = new 쇠막대기();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.solution(str));
    }

    /**
     * '(' 직후에 ')' -> 레이저
     * '(' -> 레이저 or 쇠막대기++ (직후가 ')' 이라면 레이저)
     * ')' 직후에 ')' -> 쇠막대기--
     * 레이저 만나면 answer += 현재 쇠막대기
     *
     * !오답! -> 막대기의 마지막 끄트머리 부분을 어떻게 더해야할지 몰랐음 까비,,
     */
    public int my_solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        int cnt = 0;
        for(char c : str.toCharArray()) {
            System.out.println("c = " + c);
            if(c == '(')
                cnt++;
            else {
                if(stack.peek() == '(') { // 레이저
                    cnt--; // 직전 '('는 레이저이기 때문에 cnt--
                    answer += cnt;
                } else // 쇠막대기 감소
                    cnt--;
            }

            stack.push(c);
        }

        return answer;
    }

    public int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') stack.push('(');
            else {
                stack.pop(); // '(' 짝궁 빼기
                if (str.charAt(i - 1) == '(') answer += stack.size();
                else answer++;
            }
        }

        return answer;
    }
}
