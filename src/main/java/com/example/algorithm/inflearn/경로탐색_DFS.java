package com.example.algorithm.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class 경로탐색_DFS {
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch; // visit check
    public static void main(String[] args) {
        경로탐색_DFS T = new 경로탐색_DFS();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new int[n + 1][n + 1]; // 정점 번호 1번부터 사용
        ch = new int[n + 1];
        for(int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }

    /**
     * back tracking 할 때, 방문 체크를 해제해야 함
     */
    public void DFS(int v) {
        if(v == n) answer++;
        else {
            for(int i = 1; i <= n; i++) {
                if(graph[v][i] == 1 && ch[i] == 0) { // 갈 수 있음 && 방문 안 함
                    ch[i] = 1; // 방문 전에 체크
                    DFS(i);
                    ch[i] = 0; // 체크 해제 !!!중요!!!
                }
            }
        }
    }
}
