package com.example.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 약수구하기 {
    public static void main(String[] args) {
        int[] answer = solution(24);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    public static int[] solution(int n) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            if(n % i == 0)
                list.add(i);
        }

        answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
