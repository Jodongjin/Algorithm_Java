package com.example.algorithm.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 프린터큐 {
    public static void main(String[] args) {
        프린터큐 T = new 프린터큐();
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        for(int i = 0; i < t; i++) {
            int n = kb.nextInt();
            int m = kb.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++)
                arr[j] = kb.nextInt();
            T.my_solution(n, m, arr);
        }
    }

    public void my_solution(int n, int m, int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i : arr)
            queue.add(i);

        int cnt = 0;
        while (!queue.isEmpty()) {
            boolean isBig = false;

            for(int i : queue) {
                if(queue.peek() < i) {
                    isBig = true;
                    queue.add(queue.poll());
                    if(m == 0)
                        m = queue.size() - 1;
                    else
                        m--;
                    break;
                }
            }

            if(!isBig) {
                queue.poll();
                cnt++;
                if(m == 0) {
                    System.out.println(cnt);
                    break;
                }
                else
                    m--;
            }
        }
    }
}
