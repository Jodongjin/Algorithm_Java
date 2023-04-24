package com.example.algorithm.programmers;

public class 옹알이_1 {
    public static void main(String[] args) {
        int answer = solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"});
        System.out.println("answer = " + answer);
    }

    public static int solution(String[] babbling) {
        int answer = 0;
        String[] words = new String[]{"aya", "ye", "woo", "ma"};

        for(String str : babbling) {
            String temp = str;
            for(String word : words) {
                System.out.println("str = " + str);
                System.out.println("word = " + word);
                temp = temp.replace(word, "");
                System.out.println("temp = " + temp);
            }
            if(temp.length() == 0) {
                answer++;
            }

        }

        return answer;
    }
}
