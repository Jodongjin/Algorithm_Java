package com.example.algorithm.baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 그룹단어 {
    public static void main(String[] args) {
        그룹단어 T = new 그룹단어();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++)
            arr[i] = kb.next();

        System.out.println(T.my_solution(n, arr));
    }

    public int my_solution(int n, String[] arr) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(String s : arr) {
            boolean isGroup = true;
            for(int i = 0; i < s.length(); i++) {
                if(map.get(s.charAt(i)) != null && s.charAt(i - 1) != s.charAt(i)) {
                    isGroup = false;
                    break;
                } else
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            if(isGroup)
                answer++;

            map.clear();
        }

        return answer;
    }
}
