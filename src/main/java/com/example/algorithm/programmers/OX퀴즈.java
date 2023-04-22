package com.example.algorithm.programmers;

import java.util.Arrays;

public class OX퀴즈 {
    public static void main(String[] args) {
        String[] answer = solution(new String[]{"3 - 4 = -3", "5 + 6 = 11"});
        System.out.println("answer = " + Arrays.toString(answer));
    }

    public static String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        String[] arr = new String[3];

        for(int i = 0; i < quiz.length; i++) {
            arr = quiz[i].split(" ");
            if(arr[1].equals("+")) {
                if(Integer.valueOf(arr[0]) + Integer.valueOf(arr[2]) == Integer.valueOf(arr[4]))
                    answer[i] = "O";
                else
                    answer[i] = "X";
            } else {
                if(Integer.valueOf(arr[0]) - Integer.valueOf(arr[2]) == Integer.valueOf(arr[4]))
                    answer[i] = "O";
                else
                    answer[i] = "X";
            }
        }

        return answer;
    }
}
