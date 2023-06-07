package com.example.algorithm.inflearn;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 정점의 개수가 많으면 인접 리스트로 구현
 * 메모리 효율 훨씬 좋음
 * 갈 수 있는 정점인지 확인할 필요 없음 -> 방문 했는지만 확인하면 됨
 */
public class 경로탐색_인접리스트 {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public static void main(String[] args) {
        경로탐색_인접리스트 T = new 경로탐색_인접리스트();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        /* 정점마다 리스트 생성 */
        for(int i = 0; i <= n; i++) // 1부터 사용
            graph.add(new ArrayList<Integer>());
        ch = new int[n + 1];
        for(int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b); // 1부터 사용하게 생성했으므로 바로 get(idx) 가능
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }

    public void DFS(int v) {
        if(v == n) answer++;
        else {
            for(int nv : graph.get(v)) {
                if(ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }
}
