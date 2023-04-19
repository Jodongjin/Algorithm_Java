package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.stream.Stream;

public class 문자열정렬하기_1 {
    public static void main(String[] args) {
        int[] answer = solution("hi12392");
        System.out.println("answer = " + Arrays.toString(answer));
    }

    public static int[] solution(String my_string) {
        int[] answer = {};
        String temp = my_string.replaceAll("[A-Za-z]", "");

        answer = Stream.of(temp.split("")).sorted().mapToInt(Integer::parseInt).toArray();

        return answer;
    }
}
