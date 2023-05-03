package com.example.algorithm.programmers;

import java.util.Arrays;

public class K번째수 {
    public static void main(String[] args) {
        int[] answer = solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        System.out.println("answer = " + Arrays.toString(answer));
    }

    /**
     *
     */
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIdx = 0;

        for(int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            int[] arr = new int[j - i + 1];
            for (int i2 = 0; i2 < arr.length; i2++, i++) {
                arr[i2] = array[i - 1];
            }
            Arrays.sort(arr);
            answer[answerIdx++] = arr[k - 1];
        }

        return answer;
    }

    public static int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]); // from부터 to - 1까지 copy
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
