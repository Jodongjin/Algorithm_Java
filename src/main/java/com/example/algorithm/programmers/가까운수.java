package com.example.algorithm.programmers;

import java.util.Arrays;

public class 가까운수 {
    public static void main(String[] args) {
        int answer = solution(new int[]{3, 10, 28}, 200);
        System.out.println("answer = " + answer);
    }

    public static int solution(int[] array, int n) {
        int answer = 0;
        int[] arr = new int[array.length];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(array[i] - n);
        }

        int min = Arrays.stream(arr).min().getAsInt();
        int minIdx = 0;
//        int minIdx = Arrays.asList(arr).indexOf(min); -> indexOf()가 안 됨

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == min)
                minIdx = i;
        }

        answer = array[minIdx];

        return answer;
    }

    public static int solution2(int[] array, int n) {
        int answer = 0;
        int min = Math.abs(array[0] - n);
        int minIdx = 0;

        Arrays.sort(array);
        for(int i = 1; i < array.length; i++) {
            if(Math.abs(array[i] - n) < min) {
                min = Math.abs(array[i] - n);
                minIdx = i;
            }
        }
        answer = array[minIdx];

        return answer;
    }
}
