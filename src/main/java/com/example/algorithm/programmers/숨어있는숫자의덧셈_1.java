package com.example.algorithm.programmers;

public class 숨어있는숫자의덧셈_1 {
    public static void main(String[] args) {
        int answer = solution("aAb1B2cC34oOp");
        System.out.println("answer = " + answer);
    }

    public static int solution(String my_string) {
        int answer = 0;
        String temp;

        temp = my_string.replaceAll("[A-Za-z]", "");

        String[] strArr = temp.split("");

        for(int i = 0; i < strArr.length; i++) {
            answer += Integer.parseInt(strArr[i]);
        }


        return answer;
    }
}
