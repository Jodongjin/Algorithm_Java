package com.example.algorithm.programmers;

import java.util.HashMap;
import java.util.Map;

public class 의상 {
    public static void main(String[] args) {
        int answer = solution2(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
        System.out.println("answer = " + answer);
    }

    /**
     * key: 종류 / value: 개수
     * 각 key의 value를 다 곱하고 -1 (아무 것도 안 입는 경우)
     */
    public static int solution2(String[][] clothes) {
        int answer = 0;
        answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for(String[] arr : clothes) {
            map.put(arr[1], map.getOrDefault(arr[1], 1) + 1); // 안 입는 경우의 수까지
        }

        for(String key : map.keySet()) {
            answer *= map.get(key);
        }
        answer--; // 아무 것도 안 입는 경우의 수 빼기

        return answer;
    }
}
