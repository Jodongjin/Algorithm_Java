package com.example.algorithm.programmers;

import java.util.Arrays;

public class 삼각형의완성조건_2 {
    public static void main(String[] args) {
        int answer = solution(new int[]{3, 6});
        System.out.println("answer = " + answer);
    }

    public static int solution(int[] sides) {
        int answer = 0;
        int[] arr = new int[3];
        int count = 0;

        for(int i = 0; i < sides[0] + sides[1]; i++) {
            arr[0] = sides[0];
            arr[1] = sides[1];
            arr[2] = i;
            Arrays.sort(arr);
            if(arr[0] + arr[1] > arr[2])
                count++;
        }
        answer = count;

        return answer;
    }
}
