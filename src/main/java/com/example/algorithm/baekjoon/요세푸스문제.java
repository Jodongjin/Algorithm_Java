package com.example.algorithm.baekjoon;

import java.util.*;

public class 요세푸스문제 {
    public static void main(String[] args) {
        요세푸스문제 T = new 요세푸스문제();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();

        System.out.println(T.my_solution(n, k).toString().
                replace("[", "<").
                replace("]", ">"));
    }

    public List<Integer> my_solution(int n, int k) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++)
            queue.add(i);

        int cnt = 1;
        while(!queue.isEmpty()) {
            if(cnt % k == 0)
                answer.add(queue.poll());
            else
                queue.add(queue.poll());

            cnt++;
        }

        return answer;
    }
}
