package com.example.algorithm.programmers;

import java.util.Scanner;

public class 다음큰숫자 {
    public static void main(String[] args) {
        다음큰숫자 T = new 다음큰숫자();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.println(T.my_solution(n));
    }

    public int my_solution(int n) {
        int answer = 0;
        String binaryN = Integer.toString(n, 2);
        int oneCntN = 0;
        for(char c : binaryN.toCharArray())
            if(c == '1') oneCntN++;

        for(int i = n + 1; i <= Integer.MAX_VALUE; i++) {
            String binaryI = Integer.toString(i, 2);
            int oneCntI = 0;
            for(char c : binaryI.toCharArray())
                if(c == '1') oneCntI++;
            if(oneCntN == oneCntI) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public int solution(int n) {
        int a = Integer.bitCount(n);
        int compare = n+1;
        while(true) {
            if(Integer.bitCount(compare)==a)
                break;
            compare++;
        }
        return compare;
    }
}
