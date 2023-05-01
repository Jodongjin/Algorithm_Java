package com.example.algorithm.programmers;

import java.util.HashMap;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        String answer = solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
        System.out.println("answer = " + answer);
    }

    /**
     * key value로 저장 (value = count)
     * completion이랑 비교하면서 데이터 하나씩 지움
     * 최종으로 남은 데이터가 answer
     */
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(String s : participant) {
            if(hashMap.get(s) == null)
                hashMap.put(s, 1);
            else {
                int cnt = hashMap.get(s);
                hashMap.put(s, ++cnt);
            }
        }
        System.out.println("hashMap = " + hashMap);

        for(String s : completion) {
            if(hashMap.get(s) == 1)
                hashMap.remove(s);
            else {
                int cnt = hashMap.get(s);
                hashMap.put(s, --cnt);
            }
        }
        System.out.println("hashMap = " + hashMap);
        String[] arr = hashMap.keySet().toArray(new String[0]);
        answer = arr[0];

        return answer;
    }

    public static String solution2(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}
