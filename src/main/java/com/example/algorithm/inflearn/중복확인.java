package com.example.algorithm.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class 중복확인 {
    public static void main(String[] args) {
        중복확인 T = new 중복확인();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = kb.nextInt();

        System.out.println(T.my_solution(n, arr));
    }

    public Character my_solution(int n, int[] arr) {
        char answer = 'U';
        int[] uniqueArr = new int[n];

        int idx = 0;
        for(int x : arr) {
            for(int i = 0; i < n; i++) {
                if(uniqueArr[i] == x)
                    return 'D';
            }
            uniqueArr[idx++] = x;
        }

        return answer;
    }

    /**
     * 정렬 후 버블로 비교
     */
    public String solution(int n, int[] arr) {
        String answer = "U";
        Arrays.sort(arr);
        for(int i = 0; i < n - 1; i++) {
            if(arr[i] == arr[i + 1]) return "D";
        }

        return answer;
    }
}
