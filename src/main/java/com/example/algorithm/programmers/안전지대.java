package com.example.algorithm.programmers;

import java.util.Arrays;

public class 안전지대 {
    public static void main(String[] args) {
        int answer = solution2(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}});
        System.out.println("answer = " + answer);
    }
    public static int solution2(int[][] param) {
        int safeZone = 0;
        // 위험지역 Set
        for (int i = 0; i < param.length; i++) {
            for (int j = 0; j < param.length; j++) {
                if (param[i][j] == 1)
                    setArea(param, i, j);
            }
        }

        // 안전지역 Count
        for (int i = 0; i < param.length; i++) {
            for (int j = 0; j < param.length; j++) {
                if (param[i][j] == 0)
                    safeZone++;
            }
        }

        return safeZone;
    }

    public static void setArea(int[][] param, int x, int y) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                try {
                    if (param[x + i][y + j] == 0)
                        param[x + i][y + j] = 2;
                } catch (Exception e) {
                }
            }
        }
    }

    public int solution3(int[][] board) {
        int answer = 0;
        boolean landmine[][] = new boolean[board.length][board.length];

        for(int row = 0; row < landmine.length; row++) {
            for(int col = 0; col < landmine.length; col++) {
                if(board[row][col] == 1) Destroy(col, row, board.length, landmine);
            }
        }

        for(int i = 0; i < landmine.length; i++) {
            for(int j = 0; j < landmine.length; j++) {
                if(landmine[i][j] == false) answer++;
            }
        }

        return answer;
    }

    private static void Destroy(int col, int row, int n, boolean[][] landmine) {
        for(int r = row-1; r < row+2; r++) {
            if(r < 0 || r >= n) continue;
            else {
                for(int c = col-1; c < col+2; c++) {
                    if(c < 0 || c >= n) continue;
                    else landmine[r][c] = true;
                }
            }
        }
    }
}
