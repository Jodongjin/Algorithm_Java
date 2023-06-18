package com.example.algorithm.programmers;

import java.util.*;

public class 뉴스클러스터링_1 {
    public static void main(String[] args) {
        뉴스클러스터링_1 T = new 뉴스클러스터링_1();
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";

        System.out.println(T.my_solution(str1, str2));
    }

    /**
     * Map으로 하나씩 비교해가면서 구현
     *
     * 중간에 알파벳이 아닌 문자가 섞여있을 경우, 그것을 지우고 하면 되는 줄로 이해했음 ,,
     * ex) a+bc -> ab, bc로 가능 -> 문제는 a+bc일 경우, ab는 이어 붙일 수 없고 bc부터 시작하라였음 ㅜㅡㅜ
     * 집합 A와 B가 모두 공집합(연속되는 두 알파벳을 만들 수 없을 때)일 때의 예외처리를 안 함
     */
    public int my_solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(int i = 0 ; i < str1.length() - 1 ; ++i){
            char first = str1.charAt(i);
            char second = str1.charAt(i + 1);

            if(first >= 'a' && first <= 'z' &&
                    second >= 'a' && second <= 'z'){
                map1.put(first + "" + second, map1.getOrDefault(first + "" + second, 0) + 1);
            }
        }
        for(int i = 0 ; i < str2.length() - 1 ; ++i){
            char first = str2.charAt(i);
            char second = str2.charAt(i + 1);

            if(first >= 'a' && first <= 'z' &&
                    second >= 'a' && second <= 'z'){
                map2.put(first + "" + second, map2.getOrDefault(first + "" + second, 0) + 1);
            }
        }

        int inter = 0;
        int union = 0;
        // 교집합 key가 같은 것 중 작은 값
        // 합집합 모든 A, B key에 대해 작은 값
        for(String key : map1.keySet()) {
            if(map2.containsKey(key)) { // key가 있을 때
                inter += Math.min(map1.get(key), map2.get(key));
                union += Math.max(map1.get(key), map2.get(key));
            }
            else // key가 없을 때
                union += map1.get(key);
        }

        // union에 대해 map2에 있지만 map1에 없는 것도 추가
        for(String key : map2.keySet()) {
            if(!map1.containsKey(key))
                union += map2.get(key);
        }

        double value;
        if(union == 0) value = 1; // 이 경우도 생각
        else value = (double) inter / union;
        answer = (int) (value * 65536); // Math.round() 안 써야 함

        return answer;
    }

    /**
     * List로 하나씩 지워가면서 구현
     */
    public int solution(String str1, String str2) {
        ArrayList<String> multiSet1 = new ArrayList<>();
        ArrayList<String> multiSet2 = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for(int i = 0 ; i < str1.length() - 1 ; ++i){
            char first = str1.charAt(i);
            char second = str1.charAt(i + 1);

            if(first >= 'a' && first <= 'z' &&
                    second >= 'a' && second <= 'z'){
                multiSet1.add(first + "" + second);
            }
        }

        for(int i = 0 ; i < str2.length() - 1 ; ++i){
            char first = str2.charAt(i);
            char second = str2.charAt(i + 1);

            if(first >= 'a' && first <= 'z' &&
                    second >= 'a' && second <= 'z'){
                multiSet2.add(first + "" + second);
            }
        }

        Collections.sort(multiSet1);
        Collections.sort(multiSet2);

        for(String s : multiSet1){
            if(multiSet2.remove(s)){
                intersection.add(s);
            }
            union.add(s);
        }

        for(String s : multiSet2){
            union.add(s);
        }

        double jakard = 0;

        if(union.size() == 0) {
            jakard = 1;
        } else {
            jakard = (double)intersection.size() / (double)union.size();
        }

        return (int)(jakard * 65536);
    }
}