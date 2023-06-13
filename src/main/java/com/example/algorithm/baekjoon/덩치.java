package com.example.algorithm.baekjoon;

import java.util.Scanner;

public class 덩치 {
    public static class Person {
        public int weight, height;
        Person(int w, int h) {
            this.weight = w;
            this.height = h;
        }
    }
    public static void main(String[] args) {
        덩치 T = new 덩치();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        Person[] arr = new Person[n];
        for(int i = 0; i < n; i++) {
            int weight = kb.nextInt();
            int height = kb.nextInt();
            arr[i] = new Person(weight, height);
        }

        for(int i : T.my_solution(n, arr))
            System.out.print(i + " ");
    }

    public int[] my_solution(int n, Person[] arr) {
        int[] answer = new int[n];

        for(int i = 0; i < n; i++) {
            int cnt = 1;
            for(int j = 0; j < n; j++) {
                if(arr[j].weight > arr[i].weight && arr[j].height > arr[i].height)
                    cnt++;
            }
            answer[i] = cnt;
        }

        return answer;
    }
}
