package com.example.algorithm.inflearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 가장짧은문자거리 {
    public static void main(String[] args) {
        가장짧은문자거리 T = new 가장짧은문자거리();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char t = kb.next().charAt(0);

        for(int x : T.solution(str, t)) {
            System.out.print(x + " ");
        }
    }

    public int[] my_solution(String str, char t) {
        int[] answer = new int[str.length()];
        List<Integer> list = new ArrayList<>(); // t의 인덱스들
        char[] arr = str.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == t)
                list.add(i);
        }

        for(int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for(int idx : list) {
                if(Math.abs(idx - i) < min)
                    min = Math.abs(idx - i);
            }
            answer[i] = min;
        }

        return answer;
    }

    /**
     * str을 왼쪽에 있는 e로부터의 거리를 계산 (왼쪽에서 오른쪽으로 순회)
     * 오른쪽에 있는 e로부터의 거리를 계산 (오른쪽에서 왼쪽으로 순회), 이 때 최소값이 최종 값
     */
    public int[] solution(String s, char t) {
        int[] answer = new int[s.length()];
        int p = 1000; // s의 최대 길이 100
        for(int i = 0; i < s.length(); i++) { // 왼쪽에서 출발
            if(s.charAt(i) == t) {
                p = 0;
                answer[i] = p;
            }
            else {
                p++;
                answer[i] = p;
            }
        }

        p = 1000;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == t)
                p = 0; // answer[i]는 이미 0
            else {
                p++;
                answer[i] = Math.min(answer[i], p); // 최소값으로
            }
        }

        return answer;
    }
}
