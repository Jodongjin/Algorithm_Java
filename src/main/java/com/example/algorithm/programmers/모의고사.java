package com.example.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {
    public static void main(String[] args) {
        int[] answer = solution(new int[]{1, 3, 2, 4, 2});
        System.out.println("answer = " + Arrays.toString(answer));
    }

    /**
     * 1번: 1, 2, 3, 4, 5 반복
     * 2번: 2, 1, 2, 3, 2, 4, 2, 5 반복
     * 3번: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 반복
     */
    public static int[] solution(int[] answers) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int[] supo1 = new int[]{1, 2, 3, 4, 5};
        int[] supo2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] supo3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int supo1Cnt = 0;
        int supo2Cnt = 0;
        int supo3Cnt = 0;
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == supo1[i % supo1.length])
                supo1Cnt++;
            if(answers[i] == supo2[i % supo2.length])
                supo2Cnt++;
            if(answers[i] == supo3[i % supo3.length])
                supo3Cnt++;
        }
        int max = Math.max(supo1Cnt, Math.max(supo2Cnt, supo3Cnt));

        if(max == supo1Cnt)
            list.add(1);
        if(max == supo2Cnt)
            list.add(2);
        if(max == supo3Cnt)
            list.add(3);

        answer = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);

        return answer;
    }
}
