package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 보이는학생 {
    public static void main(String[] args) {
        보이는학생 T = new 보이는학생();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.my_solution(n, arr));
    }

    /**
     * 제일 뒤부터 순회, 본인 앞에 본인보다 크거나 같은 사람이 있으면 answer-- -> 복잡도 높음
     */
    public int my_solution(int n, int[] arr) {
        /*
        int answer = n;
        for(int i = n - 1; i > 0; i--) { // i > 0: 가장 앞에 사람은 무조건 보임
            for(int j = 0; j < i; j++) {
                if(arr[i] == arr[j] || arr[i] < arr[j]) {
                    answer--;
                    break;
                }
            }
        }
        */
        int answer = 1;
        int max = arr[0];
        for(int i = 1; i < n; i++) {
            if(arr[i] > max) {
                answer++;
                max = arr[i];
            }
        }

        return answer;
    }

    public int solution(int n, int[] arr) {
        int answer = 1;
        int max = arr[0];
        for(int i = 1; i < n; i++) {
            if(arr[i] > max) {
                answer++;
                max = arr[i];
            }
        }

        return answer;
    }
}
