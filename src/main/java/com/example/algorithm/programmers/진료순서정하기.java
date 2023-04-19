package com.example.algorithm.programmers;

import java.util.Arrays;

public class 진료순서정하기 {
    public static void main(String[] args) {
        int[] answer = solution3(new int[]{3, 76, 24});
        System.out.println("answer = " + Arrays.toString(answer));
    }

    public static int[] solution2(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] copyArr = emergency.clone();

        Arrays.sort(copyArr);
        for(int i = 0; i < emergency.length; i++) {
            for(int j = 0; j < emergency.length; j++) {
                if(copyArr[i] == emergency[j])
                    answer[j] = emergency.length - i;
            }
        }

        return answer;
    }

    public static int[] solution3(int[] emergency) {
        int[] answer = new int[emergency.length];

        for(int i = 0; i < answer.length; i++) {
            int idx = 1;
            for(int j = 0; j < answer.length; j++) {
                if(emergency[i] < emergency[j]){
                    idx++;
                }
            }
            answer[i] = idx;
        }
        return answer;
    }
}
