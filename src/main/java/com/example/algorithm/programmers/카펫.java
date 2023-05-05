package com.example.algorithm.programmers;

import java.util.Arrays;

public class 카펫 {
    public static void main(String[] args) {
        int[] answer = solution(10, 2);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    /**
     * width + height = brown / 2 + 2
     * 해당 수가 나오는 모든 width, height 경우의 수 loop
     *   width - 2 * height - 2 == yellow인 경우 정답
     */
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int widthHeight = brown / 2 + 2;

        int width = 0;
        int height = 0;
        for(int i = 1; i < widthHeight; i++) {
            width = i;
            height = widthHeight - i;
            if((width - 2) * (height - 2) == yellow)
                break;
        }
        if(width < height) {
            answer[1] = width;
            answer[0] = height;
        } else {
            answer[0] = width;
            answer[1] = height;
        }

        return answer;
    }
}
