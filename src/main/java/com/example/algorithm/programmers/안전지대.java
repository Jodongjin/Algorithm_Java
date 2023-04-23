package com.example.algorithm.programmers;

public class 안전지대 {
    public static void main(String[] args) {
        int answer = solution(new int[][]{{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}});
        System.out.println("answer = " + answer);
    }
    public static int solution(int[][] board) {
        int answer = 0;
        int cnt = 0;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1)
                    cnt++;
            }
        }

        int[][] arr = new int[cnt][2];
        int idx = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1) {
                    arr[idx][0] = i;
                    arr[idx][1] = j;
                    idx++;
                }
            }
        }

        for(int[] ar: arr) {
            int i = ar[0];
            int j = ar[1];

            if(i == 0) {
                board[i - 1][j + 1] = 1;
                board[i][j - 1] = 1;
                board[i][j + 1] = 1;
                board[i + 1][j - 1] = 1;
                board[i + 1][j] = 1;
                board[i + 1][j + 1] = 1;
            } else if(j == 0) {
                board[i - 1][j] = 1;
                board[i - 1][j + 1] = 1;
                board[i][j + 1] = 1;
                board[i + 1][j] = 1;
                board[i + 1][j + 1] = 1;
            } else if(i == 0 && j == 0) {

            }

            board[i - 1][j - 1] = 1;
            board[i - 1][j] = 1;
            board[i - 1][j + 1] = 1;
            board[i][j - 1] = 1;
            board[i][j + 1] = 1;
            board[i + 1][j - 1] = 1;
            board[i + 1][j] = 1;
            board[i + 1][j + 1] = 1;
        }
        System.out.println("ok");

        cnt = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 0)
                    cnt++;
            }
        }
        answer = cnt;

        return answer;
    }
}
