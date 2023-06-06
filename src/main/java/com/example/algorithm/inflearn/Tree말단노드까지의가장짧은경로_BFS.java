package com.example.algorithm.inflearn;

import java.util.LinkedList;
import java.util.Queue;

public class Tree말단노드까지의가장짧은경로_BFS {
    static class Node {
        int data;
        Node lt, rt;
        public Node(int data) {
            this.data = data;
            lt = rt = null;
        }

        @Override
        public String toString() {
            return "data: " + this.data;
        }
    }

    Node root;
    public static void main(String[] args) {
        Tree말단노드까지의가장짧은경로_BFS T = new Tree말단노드까지의가장짧은경로_BFS();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);

        System.out.println(T.BFS(T.root));
    }

    /**
     * BFS는 level 탐색이기 때문에 완전 이진 트리가 아니어도 됨
     * lt, rt가 없는 노드에서 level을 출력
     */
    public int my_BFS(Node root) {
        int answer = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Node tmp = queue.poll();
                if (tmp.lt == null && tmp.rt == null)
                    return answer;
                else {
                    queue.add(tmp.lt);
                    queue.add(tmp.rt);
                }
            }
            answer++;
        }

        return answer;
    }

    public int BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                Node cur = Q.poll();
                if(cur.lt == null && cur.rt == null) return L;
                if(cur.lt != null) Q.offer(cur.lt); // 완전 이진 트리가 아닐 수 있음
                if(cur.rt != null) Q.offer(cur.rt);
            }
            L++;
        }

        return 0;
    }
}
