package com.example.algorithm.programmers;

import java.util.*;

public class 오픈채팅방 {
    public static void main(String[] args) {
        오픈채팅방 T = new 오픈채팅방();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        System.out.println(Arrays.toString(T.my_solution(record)));
    }

    /**
     * uid로 list 구성 -> 마지막에 map에 저장된 uid : nickname으로 치환
     */
    public String[] my_solution(String[] record) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for(String s : record) {
            String[] arr = s.split(" ");
            switch(arr[0]) {
                case "Enter":
                    map.put(arr[1], arr[2]);
                    list.add(arr[1] + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    list.add(arr[1] + "님이 나갔습니다.");
                    break;
                case "Change":
                    map.put(arr[1], arr[2]);
                    break;
                default:
            }
        }

        for(int i = 0; i < list.size(); i++) {
            String tmp = list.get(i);
            int idx = tmp.indexOf("님");
            String finalStr = map.get(tmp.substring(0, idx)) + tmp.substring(idx, tmp.length());
            list.set(i, finalStr);
        }

        answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}
