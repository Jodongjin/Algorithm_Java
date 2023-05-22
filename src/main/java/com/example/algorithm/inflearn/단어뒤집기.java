package com.example.algorithm.inflearn;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 단어뒤집기 {
    public static void main(String[] args) {
        단어뒤집기 T = new 단어뒤집기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.next();
        }

        for(String x : T.solution2(n, arr)) {
            System.out.println(x);
        }
    }

    public ArrayList<String> my_solution(int n, String[] arr) {
        ArrayList<String> answer = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String[] strArr = arr[i].split("");
            for(int j = 0; j < arr[i].length() / 2; j++) {
                String temp = strArr[j];
                strArr[j] = strArr[strArr.length - 1 - j];
                strArr[strArr.length - 1 - j] = temp;
            }
            answer.add(Arrays.stream(strArr).collect(Collectors.joining()));
        }

        return answer;
    }

    /**
     * String 객체는 불변 객체이기 때문에 수정 때마다 새로운 객체 생성
     * StringBuilder 객체는 toString() 하기 전까지 하나의 객체로 수정 가능 (메모리 효율 up)
     */
    public ArrayList<String> solution(int n, String[] arr) {
        ArrayList<String> answer = new ArrayList<>();
        for(String x : arr) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }

    /**
     * left, right를 가리키는 인덱스를 활용
     */
    public ArrayList<String> solution2(int n, String[] arr) {
        ArrayList<String> answer = new ArrayList<>();
        for(String x : arr) {
            char[] s = x.toCharArray();
            int lt = 0;
            int rt = s.length - 1;
            while(lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }

        return answer;
    }
}
