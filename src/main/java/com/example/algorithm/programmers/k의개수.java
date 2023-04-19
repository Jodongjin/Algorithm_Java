package com.example.algorithm.programmers;

import java.util.ArrayList;

public class k의개수 {
    public static void main(String[] args) {
        int answer = solution(1, 13, 1);
        System.out.println("answer = " + answer);
    }

    public static int solution(int i, int j, int k) {
        int answer = 0;
        // i부터 j까지 List로 변환
        ArrayList<String> list = new ArrayList<>();
        for(int z = i; z <= j; z++) {
            list.add(String.valueOf(z));
        }

        // 각 요소가 문자열에 k를 포함하고 있는지 확인
        for(String str: list) {
            char[] arr = str.toCharArray();
            for(char c: arr) {
                if(c == (char)(k + '0'))
                    answer++;
            }
        }

        return answer;
    }

    public static int solution2(int i, int j, int k) {
        String str = "";
        for(int a = i; a <= j; a++) {
            str += a+"";
        }

        return str.length() - str.replace(k+"", "").length();
    }
}
