package com.example.algorithm.inflearn;

import java.util.*;

public class 크레인인형뽑기 {
    public static void main(String[] args) {
        크레인인형뽑기 T = new 크레인인형뽑기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        int m = kb.nextInt();
        int[] move = new int[m];
        for(int i = 0; i < m; i++) {
            move[i] = kb.nextInt();
        }

        System.out.println(T.my_solution(n, board, m, move));
        System.out.println(T.solution(board, move));
    }

    public int my_solution(int n, int[][] board, int m, int[] move) {
        int answer = 0;
        List<Stack<Integer>> list = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            list.add(new Stack<Integer>());
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                list.get(i).push(board[j][i]);
            }
        }

        stack.push(-1);
        for(int t : move) {
            if(list.get(t - 1).isEmpty())
                continue;

            while(list.get(t - 1).peek() == 0) { // 0이면 계속 제거
                list.get(t - 1).pop();
            }

            if(stack.peek() == list.get(t - 1).peek()) {
                stack.pop();
                list.get(t - 1).pop();
                answer += 2;
            } else
                stack.push(list.get(t - 1).pop());
        }

        return answer;
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int pos : moves) {
            for(int i = 0; i < board.length; i++) {
                if(board[i][pos - 1] != 0) { // 세로로 탐색, 인형 발견
                    int tmp = board[i][pos - 1];
                    board[i][pos - 1] = 0;
                    if(!stack.isEmpty() && tmp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    }
                    else stack.push(tmp);
                    break; // 인형 하나만 꺼내고 break
                }
            }
        }

        return answer;
    }
}







