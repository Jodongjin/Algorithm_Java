package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {
    public static void main(String[] args) {
        boolean answer = solution2(new String[]{"119", "97674223", "1195524421"});
        System.out.println("answer = " + answer);
    }

    /**
     * 대상 선정, 각 대상마다 전체 비교 루프
     * String.indexOf() == 0이면 접두어인 경우가 있는 것, answer = false
     */
    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        for(String s : phone_book) {
            for(int i = 0; i < phone_book.length; i++) {
                if(s.equals(phone_book[i]))
                    continue;
                if(phone_book[i].indexOf(s) == 0)
                    answer = false;
            }
        }

        return answer;
    }


    public static boolean solution2(String[] phone_book) {
        boolean answer = true;

        Map<String, String> map = new HashMap<>();

        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], "prefix");
        }

        for(String s : phone_book) {
            for(int i = 1; i < s.length(); i++) {
                if(map.containsKey(s.substring(0, i))) {
                    return false;
                }
            }
        }

        return answer;
    }

    public static boolean solution3(String[] phoneBook) {
        for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }

        return true;
    }
}
