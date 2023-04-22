package com.example.algorithm.programmers;

public class 다항식구하기 {
    public static void main(String[] args) {
        String answer = solution("3x + 7x + 10 + 2");
        System.out.println("answer = " + answer);
    }

    public static String solution(String polynomial) {
        String answer = "";
        int intSum = 0;
        int xSum = 0;
        String[] arr = polynomial.split(" \\+ ");

        for(String s: arr) {
            if(s.contains("x")) {
                String temp = s.replace("x", "");
                if(temp == "")
                    xSum += 1;
                else
                    xSum += Integer.valueOf(temp);
            } else {
                intSum += Integer.valueOf(s);
            }
        }

        if(intSum == 0)
            if(xSum == 1) // x가 1일 때를 생각
                answer = "x";
            else
                answer = xSum + "x";
        else if(xSum == 0)
            answer = String.valueOf(intSum);
        else
        if(xSum == 1)
            answer = "x + " + intSum;
        else
            answer = xSum + "x + " + intSum;

        return answer;
    }
}
