package com.example.algorithm.inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 공주구하기 {
    public static void main(String[] args) {
        공주구하기 T = new 공주구하기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();

        System.out.println(T.my_solution(n, k));
    }

    public int my_solution(int n, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int cnt = 1;
        while(queue.size() > 1) {
            if(cnt % 3 == 0)
                queue.poll();
            else
                queue.add(queue.poll());
            cnt++;
        }
        answer = queue.poll();

        return answer;
    }

    public int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();
        for(int i = 1; i <= n; i++) Q.offer(i);
        while(!Q.isEmpty()) {
            for(int i = 1; i < k; i++) Q.offer(Q.poll());
            Q.poll();
            if(Q.size() == 1) answer = Q.poll();
        }

        return answer;
    }
}
