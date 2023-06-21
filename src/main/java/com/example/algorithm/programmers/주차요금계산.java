package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 주차요금계산 {
    public static void main(String[] args) {
        주차요금계산 T = new 주차요금계산();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        System.out.println(Arrays.toString(T.my_solution(fees, records)));
    }

    /**
     * 차량 번호 별로 시간을 Map에 저장 -> IN 시간을 어디에 보관 ?
     * 입차 시간을 저장하는 맵과 총 시간을 저장하는 맵을 따로 둬야할 듯
     * IN -> 입차 시간 저장, OUT -> 맵에서 해당되는 차 번호의 입차 시간을 가져온 후 map.remove && 총 시간 저장
     * (입차 시간 맵에 남아 있는 데이터 -> OUT이 안 나옴. 즉, 23:59 출차로 계산)
     * Map의 keySey을 배열에 저장, 배열을 정렬, 각 배열의 값(key)에 해당하는 value를 재저장
     *
     * 주의!
     * Math.ceil(), Math.round() 등 올림 계산할 때 인자로 double을 줘야함 !
     * Math.ceil(int / int) -> 이미 int로 나눠서 버림이 되었으므로 올림이 안 되었던 것
     */
    public int[] my_solution(int[] fees, String[] records) {
        System.out.println("Math.ceil(154 / 10.0) = " + Math.ceil(154 / 10.0));
        int[] answer = {};
        Map<String, String> record = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();

        for(String s : records) {
            String[] split = s.split(" ");
            switch(split[2]) {
                case "IN":
                    record.put(split[1], split[0]);
                    break;
                case "OUT":
                    String[] inHM = record.get(split[1]).split(":");
                    String[] outHM = split[0].split(":");
                    int inM = (Integer.parseInt(inHM[0]) * 60) + Integer.parseInt(inHM[1]);
                    int outM = (Integer.parseInt(outHM[0]) * 60) + Integer.parseInt(outHM[1]);
                    total.put(split[1], total.getOrDefault(split[1], 0) + (outM - inM));
                    record.remove(split[1]);
                    break;
                default:
            }
        }

        if(!record.isEmpty()) {
            for(String key : record.keySet()) {
                String[] inHM = record.get(key).split(":");
                int inM = (Integer.parseInt(inHM[0]) * 60) + Integer.parseInt(inHM[1]);
                total.put(key, total.getOrDefault(key, 0) + (1439 - inM)); // 23:59 -> 1439M
            }
        }

        String[] keySet = new String[total.size()];
        int idx = 0;
        for(String key : total.keySet()) {
            int minute = total.get(key);
            if(minute <= fees[0])
                total.put(key, fees[1]);
            else {
                int fee = fees[1] + ((int)Math.ceil((minute - fees[0]) / (double)fees[2]) * fees[3]);
                total.put(key, fee);
            }
            keySet[idx++] = key;
        }

        Arrays.sort(keySet);
        answer = new int[total.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = total.get(keySet[i]);

        return answer;
    }
}
