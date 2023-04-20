package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class _7의개수 {
    public static void main(String[] args) {
        int answer = solution(new int[]{7, 77, 17});
        System.out.println("answer = " + answer);
    }

    public static int solution(int[] array) {
        int answer = 0;
        String[] arr = new String[array.length];
        String str = "";

        for(int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(array[i]);
        }

        for(String s: arr) {
            str += s;
        }

        String[] arr2 = str.split("");

        for(String s: arr2) {
            if(s.equals("7"))
                answer++;
        }

        return answer;
    }

    public static int solution2(int[] array) {
        int answer = 0;

        answer = (int) Arrays.stream(
                Arrays.stream(array)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining())
                        .split("") // 한 자리 단위 문자열 배열
        ).filter(s -> s.equals("7")).count(); // count -> return long

        return answer;
    }
}
