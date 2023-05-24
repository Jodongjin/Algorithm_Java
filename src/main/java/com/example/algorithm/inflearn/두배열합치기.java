package com.example.algorithm.inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class 두배열합치기 {
    public static void main(String[] args) {
        두배열합치기 T = new 두배열합치기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr1 = new int[n];
        for(int i = 0; i < n; i++) {
            arr1[i] = kb.nextInt();
        }
        int m = kb.nextInt();
        int[] arr2 = new int[m];
        for(int i = 0; i < m; i++) {
            arr2[i] = kb.nextInt();
        }

        System.out.println(Arrays.toString(T.my_solution2(n, arr1, m, arr2)));
    }

    public int[] my_solution(int n, int[] arr1, int m, int[] arr2) {
        int[] answer = new int[n + m];
        for(int i = 0; i < n; i++) {
            answer[i] = arr1[i];
        }
        for(int i = n; i < n + m; i++) {
            answer[i] = arr2[i];
        }
        Arrays.sort(answer);

        return answer;
    }

    public int[] my_solution2(int n, int[] arr1, int m, int[] arr2) {
        int[] answer = new int[n + m];
        int idx = 0;
        int p1 = 0, p2 = 0;
        while(p1 != n && p2 != m) {
            if(arr1[p1] > arr2[p2]) {
                answer[idx] = arr2[p2];
                p2++;
            }
            else if(arr2[p2] > arr1[p1]) {
                answer[idx] = arr1[p1];
                p1++;
            }
            else {
                answer[idx] = arr2[p2];
                p2++;
            }

            idx++;
        }

        if(p1 == n) {
            for(int i = idx; i < n + m; i++) {
                answer[i] = arr2[p2];
                p2++;
            }
        }
        else {
            for(int i = idx; i < n + m; i++) {
                answer[i] = arr1[p1];
                p1++;
            }
        }

        return answer;
    }

    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while(p1 < n && p2 < m) {
            if(a[p1] < b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]); // 같아도 b에 있는 값을 먼저 입력 -> a 먼저 입력해도 상관 x
        }
        while(p1 < n) answer.add(a[p1++]);
        while(p2 < m) answer.add(b[p2++]);

        return answer;
    }
}
