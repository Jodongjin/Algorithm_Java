package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 소수 {
    public static void main(String[] args) {
        소수 T = new 소수();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.println(T.solution(n));
    }

    /**
     * 이중 for문이라 별로 ..
     */
    public int my_solution(int n) {
        int answer = 0;
        for(int i = 2; i <= n; i++) {
            for(int j = 2; j < i; j++) {
                if(j == i - 1) // break 없이 2 ~ i - 1까지 왔을 경우
                    answer++;

                if(i % j == 0)
                    break;
            }
        }

        if(n >= 2) // 2 이상일 때, 2 포함
            answer++;

        return answer;
    }

    /**
     * 에라토스테네스 체 (소수 구하기 중 가장 빠름)
     * n 배열을 0으로 초기화
     * 앞에서 순서대로 순회 -> 0이면 answer++(소수), 해당 idx의 배수 idx -> 1로 변경
     */
    public int solution(int n) {
        int answer = 0;
        int[] ch = new int[n + 1]; // n 번째 idx까지 있어야 함
        for(int i = 2; i <=n; i++) {
            if(ch[i] == 0) {
                answer++;
                for(int j = i; j <= n; j = j + i)
                    ch[j] = 1;
            }
        }

        return answer;
    }
}
