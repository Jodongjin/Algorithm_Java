package com.example.algorithm.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class 이분검색 {
    public static void main(String[] args) {
        이분검색 T = new 이분검색();
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
        Arrays.sort(arr);

        int p;
        int rt = n - 1, lt = 0;
        while(true) {
            p = rt + lt / 2;
            if(arr[p] == m) {
                answer = p + 1;
                break;
            }
            else if(arr[p] > m) // 왼쪽에 있음
                rt = p - 1;
            else // 오른쪽에 있음
                lt = p + 1;
        }

        return answer;
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 0, rt = n - 1;
        while(lt <= rt) { // lt > rt 이면 찾는 값이 없음
            int mid  = (lt + rt) / 2;
            if(arr[mid] == m) {
                answer = mid + 1;
                break;
            }
            if(arr[mid] > m) rt = mid - 1;
            else lt = mid + 1;
        }

        return answer;
    }
}
