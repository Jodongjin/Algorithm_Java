package com.example.algorithm.inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 교육과정설계 {
    public static void main(String[] args) {
        교육과정설계 T = new 교육과정설계();
        Scanner kb = new Scanner(System.in);
        String required = kb.next();
        String hyunsoo = kb.next();

        System.out.println(T.my_solution(required, hyunsoo));
    }

    public String my_solution(String required, String hyunsoo) {
        String answer = "NO";
        Queue<Character> queue = new LinkedList<>();
        for(char c : required.toCharArray()) queue.add(c);

        for(char c : hyunsoo.toCharArray()) {
            if(queue.peek() == c)
                queue.poll();

            if(queue.isEmpty()) {
                answer = "YES";
                break;
            }
        }

        return answer;
    }

    public String solution(String need, String plan) {
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();
        for(char x : need.toCharArray()) Q.offer(x);
        for(char x : plan.toCharArray()) {
            if(Q.contains(x)) {
                if(x != Q.poll()) return "NO";
            }
        }
        if(!Q.isEmpty()) return "NO";

        return answer;
    }
}
