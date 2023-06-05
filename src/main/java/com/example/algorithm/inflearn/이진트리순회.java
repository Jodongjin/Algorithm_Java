package com.example.algorithm.inflearn;

public class 이진트리순회 {
    static class Node {
        int data;
        Node lt, rt;
        public Node(int val) {
            data = val;
            lt = rt = null; // 이렇게 초기화 가능
        }
    }
    Node root;
    public void DFS(Node root) {
        if(root == null) return;
        DFS(root.lt); // 여기에 오면 전위
        System.out.println(root.data); // 중위
        DFS(root.rt); // 여기에 오면 후위
    }
    public static void main(String[] args) {
        이진트리순회 tree = new 이진트리순회();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.DFS(tree.root);
    }
}
