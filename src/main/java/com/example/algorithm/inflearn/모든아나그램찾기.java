package com.example.algorithm.inflearn;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class 모든아나그램찾기 {
    public static void main(String[] args) {
        모든아나그램찾기 T = new 모든아나그램찾기();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        String t = kb.next();

        System.out.println(T.solution(s, t));
    }

    /**
     * s 안의 t 아나그램 수
     * 아나그램의 조건 = window 안에 있는 문자열 Map의 keySet이 t와 동일, 개수도 동일
     */
    public int my_solution(String s, String t) {
        int answer = 0, lt = 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for(char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        char[] arr = s.toCharArray();
        for(int i = 0; i < t.length() - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        boolean isCorrect = true;
        for(int rt = t.length() - 1; rt < s.length(); rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            isCorrect = true;
            for(char c : tMap.keySet()) {
                if(!map.containsKey(c) || map.get(c) != tMap.get(c)) {
                    isCorrect = false;
                    break;
                }
            }
            if(isCorrect)
                answer++;

            map.put(arr[lt], map.get(arr[lt]) - 1);
            if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
        }

        return answer;
    }

    public int solution(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        for(char x : b.toCharArray()) bm.put(x, bm.getOrDefault(x, 0) + 1);
        int L = b.length() - 1;
        for(int i = 0; i < L; i++) am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);

        int lt = 0;
        for(int rt = L; rt < a.length(); rt++) {
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1);
            if(am.equals(bm)) answer++;
            am.put(a.charAt(lt), am.get(a.charAt(lt)) - 1);
            if(am.get(a.charAt(lt)) == 0) am.remove(a.charAt(lt));
            lt++;
        }

        return answer;
    }
}
