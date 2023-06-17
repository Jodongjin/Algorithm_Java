package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class n2배열자르기 {
    public static void main(String[] args) {
        n2배열자르기 T = new n2배열자르기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int left = kb.nextInt();
        int right = kb.nextInt();

        System.out.println(Arrays.toString(T.solution(n, left, right)));
    }

    /**
     * 0.3 솔 ..?
     * 입력으로 int < input <= long 값이 들어와서 그런 듯
     * n * n 배열을 만들고 이중 for 문을 돈 게 원인
     * -> 아래 solution 처럼 입력 값을 고려하여 구현
     */
    public int[] my_solution(int n, long left, long right) {
        int[] answer;
        int[] arr = new int[n * n];

        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                arr[idx++] = Math.max(i, j) + 1;
        }

        answer = Arrays.copyOfRange(arr, (int) left, (int) right + 1);

        return answer;
    }

    public int[] solution(int n, long left, long right) {
        int len = (int)right - (int)left + 1;
        int[] answer = new int[len];

        int idx = 0;
        for(long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            answer[idx++] = Math.max((int)row, (int)col) + 1;
        }

        return answer;
    }
}
