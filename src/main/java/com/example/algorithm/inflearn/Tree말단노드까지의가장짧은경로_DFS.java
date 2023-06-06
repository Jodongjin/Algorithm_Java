package com.example.algorithm.inflearn;

public class Tree말단노드까지의가장짧은경로_DFS {
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
    int answer = 0;
    public static void main(String[] args) {
        Tree말단노드까지의가장짧은경로_DFS T = new Tree말단노드까지의가장짧은경로_DFS();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);

        System.out.println(T.DFS(0, T.root));
    }

    /**
     * 완전 이진트리가 아니라면 BFS로 푸는 게 맞다 -> 양 쪽으로 뻗어가야 하기 떄문
     * 또한 이 문제는 최단 거리를 구하는 것이므로 BFS가 더 맞음
     */
    public int DFS(int L, Node root) {
        if(root.lt == null && root.rt == null) return L; // 단말 노드
        else return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt)); // 모든 루트가 깊이가 더 작은 서브 트리의 레벨을 받음
    }
}
