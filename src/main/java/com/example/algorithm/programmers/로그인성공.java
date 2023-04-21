package com.example.algorithm.programmers;

import java.util.HashMap;
import java.util.Map;

public class 로그인성공 {
    public static void main(String[] args) {
        String answer = solution(new String[]{"meosseugi", "1234"}, new String[][]{{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}});
        System.out.println("answer = " + answer);
    }
    public static String solution(String[] id_pw, String[][] db) {
        String answer = "";

        for(String[] arr: db) {
            if(id_pw[0].equals(arr[0]))
                answer = "wrong pw";
        }

        if(answer.equals("wrong pw")) {
            for(String[] arr: db) {
                if(id_pw[1].equals(arr[1]))
                    answer = "login";
            }
        }

        return answer;
    }

    public static String solution2(String[] id_pw, String[][] db) {
        String answer = "";

        for(int i = 0; i < db.length; i++){
            if(db[i][0].equals(id_pw[0])){
                if(db[i][1].equals(id_pw[1])){
                    answer = "login";
                }
                answer = "wrong pw";
            }
        }
        return answer;
    }

    public static String solution3(String[] id_pw, String[][] db) {
        Map<String, String> dbMap = new HashMap<String, String>();

        for (String[] strings : db) {
            dbMap.put(strings[0], strings[1]);
        }

        if (dbMap.containsKey(id_pw[0])) {
            if (dbMap.get(id_pw[0]).equals(id_pw[1])) {
                return "login";
            } else {
                return "wrong pw";
            }
        } else {
            return "fail";
        }
    }
}
