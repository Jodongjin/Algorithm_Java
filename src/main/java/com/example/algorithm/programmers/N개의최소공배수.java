package com.example.algorithm.programmers;

import java.util.*;

public class N개의최소공배수 {
    public static void main(String[] args) {
        N개의최소공배수 T = new N개의최소공배수();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = kb.nextInt();

        System.out.println(T.solution(arr));
    }

    /**
     * 0.8 솔
     */
    public int my_solution(int[] arr) {
        int answer = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int n = arr.length;
        int mul = 1;
        for(int i = 0; i < n; i++)
            mul *= arr[i];

        for(int i = mul; i >= arr[n - 1]; i--) {
            boolean check = true;
            for(int k : arr) {
                if(i % k != 0)
                    check = false;
            }
            if(check && i < answer)
                answer = i;
        }

        return answer;
    }

    public int solution(int[] arr) {
        int answer = arr[0];

        for(int i = 1; i < arr.length; i++) {
            int gcd = gcd(answer, arr[i]);
            answer = answer * arr[i] / gcd; // 최소 공배수 = 두 수의 곱 / 최대 공약수
        } // 차례대로 최소 공배수를 구하면서 전진

        return answer;
    }

    public int gcd(int a, int b) {
        int x = Math.max(a, b);
        int y = Math.min(a, b);

        while(x % y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }

        return y;
    }
}