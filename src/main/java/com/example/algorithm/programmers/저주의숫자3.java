package com.example.algorithm.programmers;

import java.util.ArrayList;
import java.util.List;

public class 저주의숫자3 {
    public static void main(String[] args) {
        int answer = solution(15);
        System.out.println("answer = " + answer);
    }
    public static int solution(int n) {
        int answer = 0;
        int cnt = 0;
        List<Integer> list = new ArrayList<>();

        int idx = 1;
        while(list.size() != n) {
            String s = String.valueOf(idx);
            if(idx % 3 != 0 && !s.contains("3"))
                list.add(idx);
            idx++;
        }
        answer = list.get(list.size() - 1);

        return answer;
    }
}
