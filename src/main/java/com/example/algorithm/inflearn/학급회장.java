package com.example.algorithm.inflearn;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 학급회장 {
    public static void main(String[] args) {
        학급회장 T = new 학급회장();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(T.my_solution(n, str));
    }

    public char my_solution(int n, String str) {
        char answer = ' ';
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : map.keySet()) {
            if(map.get(c) > max) {
                max = map.get(c);
                answer = c;
            }
        }

        return answer;
    }

    public char solution(int n, String s) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for(char key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }

        /*
        map.containsKey('A'); // return t or f
        map.size();
        map.remove('A'); // return value of key
         */

        return answer;
    }
}
