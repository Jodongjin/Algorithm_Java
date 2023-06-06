package com.example.algorithm.inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 송아지찾기 {
    public static void main(String[] args) {
        송아지찾기 T = new 송아지찾기();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();

        System.out.println(T.solution(s, e));
    }

    public int my_solution(int s, int e) {
        int answer = 0;

        while (s != e) {
            if(e < s)
                s--;
            else if(e >= s + 3)
                s += 5;
            else
                s += 1;

            answer++;
        }

        return answer;
    }

    /**
     * 레벨 == 횟수
     * 이미 방문한 곳을 체크하기 위한 변수 필요
     */
    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();
    public int solution(int s, int e) {
        ch = new int[10001]; // 10000까지
        ch[s] = 1; // 방문 체크
        Q.offer(s); // 위치
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                int x = Q.poll();
//                if(x == e) return L;
                for(int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if(nx == e) return L + 1; // 다음 레벨이 정답
                    if(nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }

        return 0;
    }
}
