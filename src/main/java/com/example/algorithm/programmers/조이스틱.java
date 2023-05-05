package com.example.algorithm.programmers;

public class 조이스틱 {
    public static void main(String[] args) {
        int answer = solution2("JEROEN");
        System.out.println("answer = " + answer);
    }

    /**
     *
     * 거의 실패
     */
    public static int solution(String name) {
        int answer = 0;
        String[] arr = name.split("");
        int rowCnt = 0;
        int colCnt = 0;
        boolean isChecked = false;

        for(String s : arr) {
            if(s.equals("A") && isChecked) {
                rowCnt--;
                isChecked = true;
            }

            if(s.charAt(0) - 'A' >= 13)
                colCnt += 26 - (s.charAt(0) - 'A');
            else
                colCnt += s.charAt(0) - 'A';
            rowCnt++;
        }
        rowCnt--;
        answer = rowCnt + colCnt;

        return answer;
    }

    public static int solution2(String name) {
        int answer = 0;
        int move = name.length() - 1; // row 이동 cnt

        for(int i = 0; i < name.length(); i++) {
            // col move
            if(name.charAt(i) - 'A' >= 13)
                answer += 26 - (name.charAt(i) - 'A');
            else
                answer += name.charAt(i) - 'A';

            // A의 마지막 위치
            int idxA = i + 1;
            while(idxA < name.length() && name.charAt(idxA) == 'A') {
                idxA++;
            }

            // 최소 이동거리 탐색
            System.out.println("i = " + i);
            System.out.println("move = " + move);
            System.out.println("i + (name.length() - idxA) = " + (i + (name.length() - idxA)));
            System.out.println("name.length() - idxA = " + (name.length() - idxA));
            move = Math.min(move, i+(name.length() - idxA) + Math.min(i, name.length() - idxA));
        }
        answer += move;

        return answer;
    }
}
