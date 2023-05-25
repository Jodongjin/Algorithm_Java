package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 연속부분수열 {
    public static void main(String[] args) {
        연속부분수열 T = new 연속부분수열();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.my_solution(n, m, arr));
    }

    public int my_solution(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0;
        int p = 0;
        for(int i = 0; i < n; i++) {
            if(sum == m) { // m일 때
                answer++;
                sum += arr[i];
            }
            else if(sum > m) { // sum이 클 때
                sum -= arr[p++];
                if(sum == m)
                    answer++;
                while (sum > m) {
                    sum -= arr[p++];
                    if(sum == m)
                        answer++;
                }
                sum += arr[i];
            }
            else // sum이 작을 때
                sum += arr[i];
        }

        return answer;
    }

    /**
     * lt, rt (two pointer)
     * sum이 크거나 m과 같을 때, lt를 빼줘야 함
     * 같을 때 빼주는 이유는 안 빼주면 무조건 m보다 클 텐데, 그럼 어차피 빼줘야 함 -> while 문 한 번 덜 반복
     */
    public int solution(int n, int m, int[] arr) {
        int answer = 0, sum = 0, lt = 0;
        for(int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if(sum == m) answer++;
            while(sum >= m) { // 하나 빼도 sum이 클 수 있기 때문
                sum -= arr[lt++];
                if(sum == m) answer++;
            }
        }

        return answer;
    }
}
