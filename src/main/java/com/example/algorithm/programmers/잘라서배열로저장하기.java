package com.example.algorithm.programmers;

import java.util.ArrayList;
import java.util.List;

public class 잘라서배열로저장하기 {
    public static void main(String[] args) {
        String[] answer = solution("abc1Addfggg4556b", 6);
        System.out.println("answer = " + answer);
    }

    public static String[] solution(String my_str, int n) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        int idx = 0;

        for(int i = 0; i < my_str.length() / n; i++) {
            list.add(my_str.substring(idx, idx + n));
            idx += n;
        }

        if(my_str.length() % n != 0) { // 문자열이 남았을 때
            list.add(my_str.substring(idx, my_str.length()));
        }

        answer = list.toArray(new String[list.size()]);

        return answer;
    }
}
