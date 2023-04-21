package com.example.algorithm.programmers;

import java.util.*;

public class 등수매기기 {
    public static void main(String[] args) {
        int[] answer = solution2(new int[][]{{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}});
        System.out.println("answer = " + Arrays.toString(answer));
    }

    public static int[] solution2(int[][] score) {
        int[] answer = {};
        List<Integer> scoreList = new ArrayList<>();
        for(int[] t : score){
            scoreList.add(t[0] + t[1]);
        }
        scoreList.sort(Comparator.reverseOrder()); // 내림차순 정렬

        answer = new int[score.length];
        for(int i=0; i<score.length; i++){
            answer[i] = scoreList.indexOf(score[i][0] + score[i][1]) + 1; // indexOf()는 가장 작은(빨리 찾은) index를 반환
        }
        return answer;
    }

    public static int[] solution3(int[][] score) {
        int[] answer = new int[score.length];
        float[] average = new float[score.length];
        for (int idx = 0; idx < score.length; idx++) {
            float ave = (float) (score[idx][1] + score[idx][0]) / 2f; // 평균값
            average[idx] = ave; // 평균값 배열
        }
        Arrays.sort(average); // 평균배열의 내림차순

        int rank = 0; // 등수
        int chkCount = 0; // 같은 점수 사람 수
        int[] grades = new int[average.length];
        Map<Float, Integer> averageMap = new HashMap<Float, Integer>(); // 평균, 등수 Map

        for (int idx = average.length - 1; idx >= 0; idx--) { // 점수 큰 사람부터
            float grade = average[idx];
            if (averageMap.containsKey(grade)) {
                chkCount++;
            } else {
                rank += chkCount + 1; // rank 값은 초기화 x -> 등수 매기기 가능
                chkCount = 0;
            }
            averageMap.put(grade, rank);
        }

        for (int idx = 0; idx < score.length; idx++) {
            float ave = (float) (score[idx][1] + score[idx][0]) / 2f; // 평균값
            answer[idx] = averageMap.get(ave); // 평균값 랭크
        }
        return answer;
    }
}
