package com.example.algorithm;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int answer = solution4("1a2b3c4d123Z");
        System.out.println("answer = " + answer);
    }

    /* String.split() */
    public static int solution2(String my_string) {
        int answer = 0;
        String[] arr = my_string.split("[A-Za-z]");

//        for(String s: arr) {
//            if(s != "")
//                answer += Integer.parseInt(s);
//        }

        for(int i = 0; i < arr.length; i++) {
            if(!arr[i].isEmpty())
                answer += Integer.parseInt(arr[i]);
        }

        return answer;
    }

    /* String.replaceAll() */
    public static int solution3(String my_string) {
        int answer = 0;
        String[] str = my_string.replaceAll("[a-zA-Z]", " ").split(" ");

        for(String s: str) {
            if(!s.equals(""))
                answer += Integer.parseInt(s);
        }

        return answer;
    }

    /* StringTokenizer */
    public static int solution4(String my_string) {
        int answer = 0;
        String s = my_string.replaceAll("[^0-9]", " ");
        StringTokenizer st = new StringTokenizer(s, " ");

        while(st.hasMoreTokens()) {
            answer += Integer.parseInt(st.nextToken());
        }

        return answer;
    }
}
