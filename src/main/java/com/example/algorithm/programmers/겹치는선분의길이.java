package com.example.algorithm.programmers;

import java.util.Arrays;

public class 겹치는선분의길이 {
    public static void main(String[] args) {
        int answer = solution(new int[][]{{0, 1}, {2, 5}, {3, 9}});
        System.out.println("answer = " + answer);
    }

    public static int solution(int[][] lines) {
        int answer = 0;
        String[] arr = new String[]{"", "", ""};

        for(int i = 0; i < lines.length; i++) {
            for(int x = lines[i][0]; x <= lines[i][1]; x++) {
                arr[i] += String.valueOf(x);
            }
        }
        System.out.println("arr = " + Arrays.toString(arr));

        for(int i = 0; i < arr[1].length(); i++) {
            String[] ar = arr[0].split("");
            for(String s : ar) {
                if()
            }
        }

        return answer;
    }
}
