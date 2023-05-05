package com.example.algorithm.programmers;

import java.util.Arrays;

public class 체육복 {
    public static void main(String[] args) {
        int answer = solution(5, new int[]{2, 4}, new int[]{1, 3, 5});
        System.out.println("answer = " + answer);
    }

    /**
     *
     */
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌 체육복을 가져온 학생의 도난
        for(int i = 0; i < reserve.length; i++) {
            for(int j = 0; j < lost.length; j++) {
                if(reserve[i] == lost[j]) {
                    answer++;
                    reserve[i] = -1;
                    lost[j] = -1;
                    break;
                }
            }
        }

        // 체육복 가능 인원 계산
        for(int i = 0; i < reserve.length; i++) {
            for(int j = 0; j < lost.length; j++) {
                if(reserve[i] == lost[j] + 1 || reserve[i] == lost[j] - 1) {
                    answer++;
                    reserve[i] = -1;
                    lost[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }

    public static int solution2(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost)
            people[l-1]--;
        for (int r : reserve)
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else
                    answer--;
            }
        }
        return answer;
    }
}
