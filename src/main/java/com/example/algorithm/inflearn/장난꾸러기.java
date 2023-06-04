package com.example.algorithm.inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 장난꾸러기 {
    public static void main(String[] args) {
        장난꾸러기 T = new 장난꾸러기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = kb.nextInt();

        System.out.println(Arrays.toString(T.my_solution(n, arr)));
    }

    public int[] my_solution(int n, int[] arr) {
        int[] answer = new int[2];
        int[] copy = new int[n];
        for(int i = 0; i < n; i++)
            copy[i] = arr[i];
        Arrays.sort(arr);

        int idx = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] != copy[i])
                answer[idx++] = i + 1;
        }

        return answer;
    }

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone(); // 깊은 복사
        Arrays.sort(tmp);
        for(int i = 0; i < n; i++) {
            if(arr[i] != tmp[i]) answer.add(i + 1);
        }

        return answer;
    }
}
