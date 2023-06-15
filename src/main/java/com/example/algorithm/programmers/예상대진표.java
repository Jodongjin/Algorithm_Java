package com.example.algorithm.programmers;

import java.util.Scanner;

public class 예상대진표 {
    public static void main(String[] args) {
        예상대진표 T = new 예상대진표();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int a = kb.nextInt();
        int b = kb.nextInt();

        System.out.println(T.my_solution(n, a, b));
    }

    /**
     * 0.9 솔
     */
    public int my_solution(int n, int a, int b) {
        int answer = 1;

        while(Math.abs(a - b) != 1) {
            if(a % 2 == 1)
                a = a / 2 + 1;
            else
                a /= 2;

            if(b % 2 == 1)
                b = b / 2 + 1;
            else
                b /= 2;

            answer++;
        }

        return answer;
    }

    public int solution(int n, int a, int b) {
        int answer = 0;

        while(true) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer++;
            if(a == b) // 같아지는 전 라운드에서 만나게 됨, answer = 0 시작
                break;
        }

        return answer;
    }
}
