package com.example.algorithm.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class 마구간정하기 {
    public static void main(String[] args) {
        마구간정하기 T = new 마구간정하기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int c = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = kb.nextInt();

        System.out.println(T.solution(n, c, arr));
    }

    /**
     * 결정 알고리즘에서 lt, rt의 대상은 정답으로 정하면 됨
     * lt, rt를 두 말의 최대 거리 (정답)으로 두면 됨
     */
    public int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n - 1]; // arr[n - 1] - arr[0]으로 하면 범위를 더 좁힐 수 있음
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if(count(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            }
            else rt = mid - 1;
        }

        return answer;
    }

    public int count(int[] arr, int dist) {
        int cnt = 1; // 말의 수, 처음에 0 idx에 배치 -> 1
        int ep = arr[0]; // 마지막 배치 위치
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - ep >= dist) {
                cnt++;
                ep = arr[i];
            }
        }

        return cnt;
    }
}
