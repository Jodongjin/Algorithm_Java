package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 겹치는선분의길이 {
    public static void main(String[] args) {
        int answer = solution2(new int[][]{{0, 1}, {2, 5}, {3, 9}});
        System.out.println("answer = " + answer);
    }

    public static int solution2(int[][] lines) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<lines.length; i++) {
            int min = Math.min(lines[i][0], lines[i][1]);
            int max = Math.max(lines[i][0], lines[i][1]);

            for (int j=min; j<max; j++) { // 겹치는 점이 아닌 선이므로 max - 1까지
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }

        int answer = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                answer++;
            }
        }

        return answer;
    }
}
