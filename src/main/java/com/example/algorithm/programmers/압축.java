package com.example.algorithm.programmers;

import java.util.*;

public class 압축 {
    public static void main(String[] args) {
        압축 T = new 압축();
        Scanner kb = new Scanner(System.in);
        String msg = kb.next();

        System.out.println(Arrays.toString(T.solution(msg)));
    }

    /**
     * List, Map 사용까진 맞췄는데 ,, 로직이 부족했다 ㅜ
     */
    public int[] solution(String msg) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        int idx = 1;
        for(char i = 'A'; i <= 'Z'; i++) // char형 for문
            map.put(i + "", idx++);

        int size = msg.length();
        for(int i = 0; i < size; i++) {
            int a = 1;
            while(i + a <= size && map.containsKey(msg.substring(i, i + a)))
                a++;
            if(i + a > size) { // 마지막 요소로 인해 while문 탈출이라면
                list.add(map.get(msg.substring(i)));
                break;
            }
            list.add(map.get(msg.substring(i, i + a - 1))); // 정답에 추가 (i + a - 1 -> 사전에 있는 단어)
            map.put(msg.substring(i, i + a), idx++); // 사전에 추가
            if(a > 1) i += a - 2; // for문에서 i++ 해주고 있어서 - 2
        }

        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = list.get(i);

        return answer;
    }
}