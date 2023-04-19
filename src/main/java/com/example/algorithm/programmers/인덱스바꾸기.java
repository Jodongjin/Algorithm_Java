package com.example.algorithm.programmers;

public class 인덱스바꾸기 {
    public static void main(String[] args) {
        String answer = solution("hello", 1, 2);
        System.out.println("answer = " + answer);
    }

    public static String solution(String my_string, int num1, int num2) {
        String answer = "";
        char[] arr = new char[my_string.length()];

        arr = my_string.toCharArray();

        char temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;

        answer = String.valueOf(arr);

        return answer;
    }
}
