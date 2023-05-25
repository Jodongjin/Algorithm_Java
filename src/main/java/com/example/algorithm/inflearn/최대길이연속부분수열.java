package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 최대길이연속부분수열 {
    public static void main(String[] args) {
        최대길이연속부분수열 T = new 최대길이연속부분수열();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, k, arr));
    }

    /**
     * idx = 0
     * while(idx < n)
     *   0을 만나면 k--
     *   k == -1 일 때, max(answer) 값 갱신, k = k로 초기화
     *   i++
     */
    public int my_solution(int n, int k, int[] arr) {
        int answer = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            int idx = i;
            int cnt = k;
            int len = 0;
            while(cnt >= 0 && idx < n) {
                if(arr[idx++] == 0) cnt--;
                len++;
            }
            if(cnt > -1) continue; // k를 다 쓰지 않았음
            if(len > answer) answer = --len;
        }

        return answer;
    }

    /**
     * two point
     * rt - lt + 1 = len
     * rt가 마지막 0을 만나면 len을 구하고, lt를 첫 0까지 이동 시켜서 cnt를 감소 -> 반복
     */
    public int solution(int n, int k, int[] arr) {
        int answer = 0, cnt = 0, lt = 0;
        for(int rt = 0; rt < n; rt++) {
            if(arr[rt] == 0) cnt++;
            while(cnt > k) {
                if(arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }
}
