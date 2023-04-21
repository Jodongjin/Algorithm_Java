package com.example.algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        int answer = solution("hello", "ohell");
        System.out.println("answer = " + answer);
    }

    public static int solution(String A, String B) {
        int answer = 0;
        int count = 0;
        boolean isSuccess = false;
        String[] arr = A.split("");

        for(String s: arr) {
            String str = Arrays.stream(arr).collect(Collectors.joining());
            if(str.equals(B)) {
                answer = count;
                isSuccess = true;
                break;
            } else {
                String temp = arr[arr.length - 1];
                for(int i = arr.length - 1; i > 0; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[0] = temp;
                count++;
            }
        }
        answer = isSuccess ? count : -1;

        return answer;
    }

    public static int solution2(String A, String B) {
        String tempB = B.repeat(3);
        return tempB.indexOf(A);
    }
}

