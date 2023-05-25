package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 최대매출 {
    public static void main(String[] args) {
        최대매출 T = new 최대매출();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.my_solution(n, k, arr));
    }

    public int my_solution(int n, int k, int[] arr) {
        int answer = Integer.MIN_VALUE;
        int idx = 0;
        while(idx <= n - k) {
            int sum = 0;
            for(int i = idx; i < idx + k; i++) {
                sum += arr[i];
            }
            if(sum > answer)
                answer = sum;
            idx++;
        }

        return answer;
    }

    public int solution(int n, int k, int[] arr) {
        int answer, sum = 0;
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }
        answer = sum;
        for(int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
