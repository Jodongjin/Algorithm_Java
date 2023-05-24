package com.example.algorithm.inflearn;

import java.util.*;

public class 공통원소구하기 {
    public static void main(String[] args) {
        공통원소구하기 T = new 공통원소구하기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
        }

        int m = kb.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m; i++) {
            b[i] = kb.nextInt();
        }

        System.out.println(T.my_solution(n, m, a, b));
    }

    public List<Integer> my_solution(int n, int m, int[] a, int[] b) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int p1 = 0;
        int p2 = 0;
        for(int i = 0; i < Math.min(n, m); i++) {
            if(a[p1] == b[p2]) {
                answer.add(a[p1]);
                p1++; // 굳이 둘 다 증가 안 해도 다음 비교에서 p1이 무조건 더 크니 p2 증가함
            }
            if(a[p1] < b[p2])
                p1++;
            else
                p2++;
        }

        return answer;
    }

    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int p1 = 0, p2 = 0;
        while(p1 < n && p2 < m) {
            if(a[p1] == b[p2]) {
                answer.add(a[p1++]);
                p2++;
            }
            else if(a[p1] < b[p2]) p1++;
            else p2++;
        }

        return answer;
    }
}
