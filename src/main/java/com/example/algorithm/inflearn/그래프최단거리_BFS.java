package com.example.algorithm.inflearn;

import java.util.*;

public class 그래프최단거리_BFS {
    static int n, m;
    static int[][] graph;
    static int[] ch;
    public static void main(String[] args) {
        그래프최단거리_BFS T = new 그래프최단거리_BFS();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();

        /* 인접행렬
        graph = new int[n + 1][n + 1];
        for(int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph[a][b] = 1;
        }
         */

        ch = new int[n + 1];

        dis = new int[n + 1];
        graph2 = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++)
            graph2.add(new ArrayList<Integer>());
        for(int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph2.get(a).add(b);
        }

        T.BFS(1);
        for(int i = 2; i <= n; i++)
            System.out.println(i + " : " + dis[i]); // 2 번 정점부터

    }

    /**
     * 레벨 순회로 구현
     * 레벨 == 거리
     */
    public void my_BFS() {
        Queue<Integer> queue = new LinkedList<>();
        int level = 0;

        queue.add(1);
        ch[1] = 1;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int tmp = queue.poll();
                System.out.println(tmp + " : " + level);
                for(int j = 1; j <= n; j++) {
                    if(graph[tmp][j] == 1 && ch[j] == 0) {
                        queue.add(j);
                        ch[j] = 1;
                    }
                }
            }
            level++;
        }
    }

    /**
     * 거리를 나타내는 배열로 구현
     * dis[n] -> 1번 정점에서 각 정점(idx)까지의 거리를 값으로 지님
     * queue에서 나온 값에서 갈 수 있는 곳을 queue에서 나온 값 + 1의 값으로 세팅
     * 최종 각 dis 값이 정점 1에서의 거리
     */
    static ArrayList<ArrayList<Integer>> graph2;
    static int[] dis;

    public void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();

        ch[v] = 1;
        dis[v] = 0;
        queue.offer(v);
        while (!queue.isEmpty()) {
            int cv = queue.poll();
            for(int nv : graph2.get(cv)) {
                if(ch[nv] == 0) { // 갈 수 있는지에 대한 확인은 안 해도 됨 -> 인접 리스트
                    ch[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[cv] + 1; // 다음 정점은 "현재" 정점에서 + 1 만큼의 거리
                }
            }
        }
    }
}
