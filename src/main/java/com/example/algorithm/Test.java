package com.example.algorithm;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        int answer = solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}});
        System.out.println("answer = " + answer);
    }

    /**
     *
     */
    public static int solution(int[][] board) {
        int answer = 0;
        int iIdx = -1;
        int jIdx = -1;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1) {
                    iIdx = i;
                    jIdx = j;
                }
            }
        }
        return answer;
    }
}

