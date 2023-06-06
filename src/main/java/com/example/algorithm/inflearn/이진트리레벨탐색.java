package com.example.algorithm.inflearn;

import java.util.LinkedList;
import java.util.Queue;

public class 이진트리레벨탐색 {
    static class Node {
        int data;
        Node lt, rt;
        public Node(int data) {
            this.data = data;
            lt = rt = null;
        }
    }
    Node root;
    Queue<Node> queue;
    public static void main(String[] args) {
        이진트리레벨탐색 T = new 이진트리레벨탐색();
        T.root = new Node(1);
        T.queue = new LinkedList();

        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        T.root.rt.lt = new Node(6);
        T.root.rt.rt = new Node(7);

        T.BFS(T.root);
    }

    public void my_BFS(Node node) {
        queue.add(node);
        while(!queue.isEmpty()) {
            Node tmp = queue.poll();
            System.out.println(tmp.data);

            if(tmp.lt == null || tmp.rt == null)
                continue;
            else {
                queue.add(tmp.lt);
                queue.add(tmp.rt);
            }
        }
    }

    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()) { // 한 번의 반복에 1 level
            int len = Q.size(); // level 단위로 출력하기 위해
            System.out.print(L + " : ");
            for(int i = 0; i < len; i++) {
                Node cur = Q.poll();
                System.out.print(cur.data + " ");
                if(cur.lt != null) Q.offer(cur.lt);
                if(cur.rt != null) Q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
    }
}
