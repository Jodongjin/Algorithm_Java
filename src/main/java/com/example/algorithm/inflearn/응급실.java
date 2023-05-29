package com.example.algorithm.inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 응급실 {
    public static void main(String[] args) {
        응급실 T = new 응급실();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, m, arr));
    }

    public int my_solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i : arr) queue.add(i);

        while (true) {
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
                answer++;
                if(m == 0)
                    break;
                else
                    m--;
            }
        }

        return answer;
    }

    /**
     * 클래스를 활용해서 m을 추적
     */
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> Q = new LinkedList<>();
        for(int i = 0; i < n; i++) Q.add(new Person(i, arr[i]));
        while (!Q.isEmpty()) {
            Person tmp = Q.poll();
            for(Person x : Q) {
                if(x.priority > tmp.priority) {
                    Q.add(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null) {
                answer++;
                if(tmp.id == m) return answer;
            }
        }

        return answer;
    }
}

class Person {
    int id;
    int priority;
    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}