package com.example.algorithm.inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 뒤집은소수 {
    public static void main(String[] args) {
        뒤집은소수 T = new 뒤집은소수();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.my_solution(n, arr));
    }

    public String my_solution(int n, int[] arr) {
        String answer = "";
        int[] reverse = new int[n];
        for(int i = 0; i < n; i++) {
            reverse[i] = Integer.parseInt(new StringBuilder(String.valueOf(arr[i])).reverse().toString());
        }

        for(int i : reverse) {
            if(i == 2)
                answer += i + " ";
            for(int j = 2; j < i; j++) {
                if(i % j == 0)
                    break;

                if(j == i - 1)
                    answer += i + " ";
            }
        }

        return answer;
    }

    /**
     * 10으로 나눈 나머지를 추가하며 숫자 뒤집음
     * 뒤집힌 숫자 -> res = res * 10 + t (1의 자리를 만들고 추가)
     */
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;
            while(tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if(isPrime(res))
                answer.add(res);
        }

        return answer;
    }

    public boolean isPrime(int num) {
        if(num == 1)
            return false;
        for(int i = 2; i < num; i++) {
            if(num % i == 0)
                return false;
        }

        return true;
    }
}
