package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 귤고르기 {
    public static void main(String[] args) {
        귤고르기 T = new 귤고르기();
        int k  = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        System.out.println(T.my_solution(k, tangerine));
    }

    public int my_solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < tangerine.length; i++)
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);

        int[] arr = new int[map.size()];
        int idx = 0;
        for(int value : map.values())
            arr[idx++] = value;
        Arrays.sort(arr);

        for(int i = arr.length - 1; i >= 0; i--) {
            answer++;
            if(k - arr[i] <= 0) break;
            else k -= arr[i];
        }


        return answer;
    }
}
