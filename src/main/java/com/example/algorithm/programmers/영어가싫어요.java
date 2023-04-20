package com.example.algorithm.programmers;

public class 영어가싫어요 {
    public static void main(String[] args) {
        long answer = solution("onetwothreefourfivesixseveneightnine");
        System.out.println("answer = " + answer);
    }

    public static long solution(String numbers) {
        long answer = 0;
        String str = numbers.replace("zero", "0");
        str = str.replace("one", "1");
        str = str.replace("two", "2");
        str = str.replace("three", "3");
        str = str.replace("four", "4");
        str = str.replace("five", "5");
        str = str.replace("six", "6");
        str = str.replace("seven", "7");
        str = str.replace("eight", "8");
        str = str.replace("nine", "9");

        answer = Long.valueOf(str);

        return answer;
    }

    public static long solution2(String numbers) {
        long answer = 0;

        String[] numbers_arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < numbers_arr.length; i++) {
            numbers = numbers.replaceAll(numbers_arr[i], String.valueOf(i));
        }

        answer = Long.parseLong(numbers);

        return answer;
    }
}
