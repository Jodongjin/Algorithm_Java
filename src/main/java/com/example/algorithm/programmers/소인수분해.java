package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.HashSet;

public class 소인수분해 {
    public static void main(String[] args) {
        int[] answer = solution(12);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    public static int[] solution(int n) {
        int[] answer = {};
        HashSet<Integer> set = new HashSet<>();

        for(int i = 2; i <= n; i++) {
            while(n % i == 0) {
                set.add(i);
                n /= i;
            }
        }
        if(n != 1)
            set.add(n);

        answer = set.stream().mapToInt(Integer::intValue).sorted().toArray();

        return answer;
    }
}
