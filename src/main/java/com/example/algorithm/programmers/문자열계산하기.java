package com.example.algorithm.programmers;

import java.util.Arrays;

public class 문자열계산하기 {
    public static void main(String[] args) {
        int answer = solution2("13 - 14 + 1");
        System.out.println("answer = " + answer);
    }

    public static int solution2(String my_string) {
        int answer = 0;
        String[] arr = my_string.split(" ");
        answer = Integer.valueOf(arr[0]);

        for(int i = 1; i < arr.length; i += 2) {
            if(arr[i].equals("+")) {
                answer += Integer.valueOf(arr[i + 1]);
            } else {
                answer -= Integer.valueOf(arr[i + 1]);
            }
        }

        return answer;
    }

    public int solution3(String myString) {
        return Arrays.stream(myString.replaceAll("- ", "-").replaceAll("[+] ", "").trim().split(" ")).mapToInt(Integer::parseInt).sum();
    }
}
