package com.example.algorithm.programmers;

public class 최소직사각형 {
    public static void main(String[] args) {
        int answer = solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}});
        System.out.println("answer = " + answer);
    }

    /**
     * 최대 값을 idx 0 위치로 이동
     */
    public static int solution(int[][] sizes) {
        int answer = 0;

        int widthMax = 0;
        int heightMax = 0;
        for(int[] arr : sizes) {
            if(arr[1] > arr[0]) {
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
            }

            if(arr[0] > widthMax)
                widthMax = arr[0];

            if(arr[1] > heightMax)
                heightMax = arr[1];
        }
        answer = widthMax * heightMax;

        return answer;
    }

    /**
     * 0 idx, 1 idx 중 큰 값과 작은 값을 분리하여 저장
     */
    public int solution2(int[][] sizes) {
        int length = 0, height = 0;
        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        int answer = length * height;
        return answer;
    }
}
