package com.example.algorithm.programmers;

import java.util.HashMap;
import java.util.Map;

public class 연속부분수열합의개수 {
    public static void main(String[] args) {
        연속부분수열합의개수 T = new 연속부분수열합의개수();
        int[] elements = {7, 9, 1, 1, 4};

        System.out.println(T.my_solutioin(elements));
    }

    public int my_solutioin(int[] elements) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // 수열의 길이
        for(int i = 1; i <= elements.length; i++) {
            // 수열의 시작 (0 ~ n - 1)
            for(int j = 0; j < elements.length; j++) {
                int sum = 0;
                // i길이의 j수열의 합
                for(int k = 0; k < i; k++) {
                    int idx = j + k == 0 ? 0 : (j + k) % elements.length;
                    sum += elements[idx];
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        answer = map.size();

        return answer;
    }
}
