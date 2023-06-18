package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 튜플 {
    public static void main(String[] args) {
        튜플 T = new 튜플();
        String s = "{{20,111},{111}}";

        System.out.println(Arrays.toString(T.my_solution(s)));
    }

    /**
     * s에서 어떻게 숫자만 뽑을지 정하는 게 조금 어려웠다.
     */
    public int[] my_solution(String s) {
        System.out.println((int) '1');
        int[] answer;
        Map<String, Integer> map = new HashMap<>();

        s = s.replace("{", "");
        s = s.replace("}", "");
        String[] arr = s.split(",");

        for(String tmp : arr)
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);

        answer = new int[map.size()]; // map의 size가 최대 빈도수
        int idx = 0;
        for(int i = map.size(); i > 0; i--) { // 빈도수가 가장 많은 것부터 적은 순으로 찾는다
            for(String key : map.keySet()) {
                if(i == map.get(key)) {
                    answer[idx++] = Integer.parseInt(key);
                    break;
                }
            }
        }

        return answer;
    }
}
