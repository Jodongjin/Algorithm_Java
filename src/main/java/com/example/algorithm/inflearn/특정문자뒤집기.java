package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 특정문자뒤집기 {
    public static void main(String[] args) {
        특정문자뒤집기 T = new 특정문자뒤집기();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.solution(str));
    }

    /**
     * 오답 !
     * index i가 문자여도 반대쪽이 특수문자일 수 있음
     */
    public String my_solution(String str) {
        String answer = "";
        char[] arr = str.toCharArray();
        for(int i = 0; i < arr.length / 2; i++) {
            if(arr[i] >= 65 && arr[i] <= 90 || arr[i] >= 97 && arr[i] <= 122) {
                char tmp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = tmp;
            }
        }
        answer = String.valueOf(arr);

        return answer;
    }

    public String solution(String str) {
        String answer = "";
        char[] s = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;
        while(lt < rt) {
            if(!Character.isAlphabetic(s[lt])) // 알파벳이 아닐 때
                lt++;
            else if(!Character.isAlphabetic(s[rt]))
                rt--;
            else {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(s);

        return answer;
    }
}
