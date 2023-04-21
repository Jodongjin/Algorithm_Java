package com.example.algorithm.programmers;

import java.util.Arrays;

/**
 * 프로그래머스에서 테스트 하나 에러 ,, 왜지 ?
 */
public class 캐릭터의좌표 {
    public static void main(String[] args) {
        int[] answer = solution(new String[]{"left", "right", "up", "right", "right"}, new int[]{11, 11});
        System.out.println("answer = " + Arrays.toString(answer));
    }

    public static int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[]{0, 0};
        int maxX = board[0] / 2;
        int maxY = board[1] / 2;

        for(String s: keyinput) {
            switch (s) {
                case "left":
                    if(Math.abs(answer[0]) < maxX)
                        answer[0]--;
                    break;
                case "right":
                    if(Math.abs(answer[0]) < maxX)
                        answer[0]++;
                    break;
                case "up":
                    if(Math.abs(answer[1]) < maxY)
                        answer[1]++;
                    break;
                case "down":
                    if(Math.abs(answer[1]) < maxY)
                        answer[1]--;
                    break;
            }
        }

        return answer;
    }
}
