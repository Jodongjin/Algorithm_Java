package com.example.algorithm.inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 좌표정렬 {
    public static class Position implements Comparable<Position> {
        public int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * 음수를 return 하게 계산하면 됨
         * 오름차순: this < o 이니까 this - o
         * 내림차순: this > o 이니까 o - this
         */
        @Override
        public int compareTo(Position o) {
            if(this.x == o.x) return this.y - o.y;
            else return this.x - o.x;
        }
    }

    public static void main(String[] args) {
        좌표정렬 T = new 좌표정렬();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Position> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            arr.add(new Position(x, y));
        }
        Collections.sort(arr);

        for(Position o : arr) {
            System.out.println(o.x + " " + o.y);
        }
    }
}