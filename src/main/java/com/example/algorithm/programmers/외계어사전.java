package com.example.algorithm.programmers;

public class 외계어사전 {
    public static void main(String[] args) {
        int answer = solution(new String[]{"z", "d", "x"}, new String[]{"def", "dww", "dzx", "loveaw"});
        System.out.println("answer = " + answer);
    }

    public static int solution(String[] spell, String[] dic) {
        int answer = 0;
        int count = 0;
        answer = 2;

        for(int i = 0; i < dic.length; i++) {
            for(int j = 0; j < spell.length; j++) {
                if(dic[i].contains(spell[j]))
                    count++;
            }
            if(count == spell.length && dic[i].length() == spell.length)
                answer = 1;

            count = 0;
        }

        return answer;
    }
}
