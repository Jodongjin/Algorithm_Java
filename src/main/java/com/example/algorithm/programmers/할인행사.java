package com.example.algorithm.programmers;

import java.util.HashMap;
import java.util.Map;

public class 할인행사 {
    public static void main(String[] args) {
        할인행사 T = new 할인행사();
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(T.my_solition(want, number, discount));
    }

    /**
     * 10일 "연속"으로 일치해야 함
     * 문제를 잘 읽자 ,, !
     */
    public int my_solition(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i < want.length; i++)
            wantMap.put(want[i], number[i]);

        for(int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> tmp = new HashMap<>();
            for(int j = i; j < i + 10; j++)
                tmp.put(discount[j], tmp.getOrDefault(discount[j], 0) + 1);

            boolean check = true;
            for(String key : wantMap.keySet()) {
                if(wantMap.get(key) != tmp.get(key)) {
                    check = false;
                    break;
                }
            }

            answer += check ? 1 : 0;
        }

        return answer;
    }
}
