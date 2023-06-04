package com.example.algorithm.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class 뮤직비디오 {
    public static void main(String[] args) {
        뮤직비디오 T = new 뮤직비디오();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = kb.nextInt();

        System.out.println(T.my_solution(n, m, arr));
    }

    public int my_solution(int n, int m, int[] arr) {
        int answer = 0;
        answer = Arrays.stream(arr).sum() / m;

        while(true) {
            int cnt = 1; // DVD의 개수
            int sum = 0; // DVD의 용량
            for(int i = 0; i < n; i++) {
                if(sum + arr[i] <= answer) // DVD의 용량이 설정한 최소 용량을 넘어가지 않으면 더하기
                    sum += arr[i];
                else { // 새로운 sum(DVD)을 만드는 순간 cnt(DVD 개수) 증가
                    sum = arr[i];
                    cnt++;
                }
            }
            if(cnt == m) // DVD의 개수가 m과 같다면 answer(DVD의 최소 용량)가 정답
                break;
            answer++; // 같지 않다면 answer(DVD의 최소 용량) 증가
        }

        return answer;
    }
}
