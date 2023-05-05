package com.example.algorithm.programmers;

public class 조이스틱 {
    public static void main(String[] args) {
        int answer = solution("JEROEN");
        System.out.println("answer = " + answer);
    }

    /**
     * 시작은 무조건 첫 번째 위치
     * 1. 첫 번째가 A일 때
     * 2. 마지막이 A일 때
     * 3. 양 끝이 A일 때
     * 4. 중간에 A가 들어갈 때 -> 이 경우는 1, 2, 3 어디든 들어갈 수 있음
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
}
