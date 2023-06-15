package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class 이진변환반복하기 {
    public static void main(String[] args) {
        이진변환반복하기 T = new 이진변환반복하기();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();

        System.out.println(Arrays.toString(T.my_solution(s)));
    }

    public int[] my_solution(String s) {
        int[] answer = new int[2];

        int change = 0;
        int zeroCnt = 0;
        while(!s.equals("1")) {
            for(char c : s.toCharArray()) {
                if(c == '0')
                    zeroCnt++;
            }
            s = s.replace("0", "");
            int num = s.length();
            s = Integer.toString(num, 2);
            change++;
        }
        answer[0] = change;
        answer[1] = zeroCnt;

        return answer;
    }
}
