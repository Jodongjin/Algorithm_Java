package com.example.algorithm.inflearn;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 아나그램 {
    public static void main(String[] args) {
        아나그램 T = new 아나그램();
        Scanner kb = new Scanner(System.in);
        String s1 = kb.next();
        String s2 = kb.next();

        System.out.println(T.my_solution(s1, s2));
    }

    public String my_solution(String s1, String s2) {
        String answer = "YES";
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for(char c : s2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        for(char c : map1.keySet()) { // map2에 key가 없거나 값이 다르면 answer = "NO"
            if(!map2.containsKey(c))
                answer = "NO";
            else if(map1.get(c) != map2.get(c))
                answer = "NO";
        }

        return answer;
    }
}
