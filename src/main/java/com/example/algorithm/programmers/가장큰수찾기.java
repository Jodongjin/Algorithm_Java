package com.example.algorithm.programmers;

import java.util.Arrays;

public class 가장큰수찾기 {
    public static void main(String[] args) {
        int[] answer = solution(new int[]{1, 8, 3});
        System.out.println("answer = " + Arrays.toString(answer));
    }

    public static int[] solution(int[] array) {
        int[] answer = new int[2];

        /* 이거 왜 안 되지 ,, ? -> indexOf()가 안 됨 */
        // answer[0] = Arrays.stream(array).max().getAsInt();
        // answer[1] = Arrays.asList(array).indexOf(answer[0]);

        int maxNum = 0;
        int indexNum = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] > maxNum) {
                maxNum = array[i];
                indexNum = i;
            }
        }

        answer[0] = maxNum;
        answer[1] = indexNum;

        return answer;
    }
}
