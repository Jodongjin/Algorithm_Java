package com.example.algorithm.programmers;

import java.util.*;

public class 캐시_1 {
    public static void main(String[] args) {
        캐시_1 T = new 캐시_1();
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        System.out.println(T.my_solution(cacheSize, cities));
    }

    /**
     * First In First Out
     * 캐시 크기만큼 Queue
     * queue.contains -> +1
     * !queue.contains -> + 5, queue.poll() & queue.add()
     *
     * 0.8솔
     * cacheSize가 0일 때를 생각하지 못 함
     * cache hit일 때, 해당 요소 다시 가장 뒤로 가야하는 지 몰랐음
     */
    public int my_solution(int cacheSize, String[] cities) {
        if(cacheSize == 0)
            return cities.length * 5; // 이거 놓쳤다,, 입력값 항상 주의 !

        int answer = 0;
        Queue<String> queue = new LinkedList<>();

        queue.add(cities[0].toLowerCase()); // 첫 요소 삽입
        answer += 5;

        for(int i = 1; i < cities.length; i++) {
            String tmp = cities[i].toLowerCase();
            if(queue.contains(tmp)) {
                answer++;
                queue.remove(tmp);
                queue.add(tmp);
            }
            else {
                answer += 5;
                if(queue.size() < cacheSize)
                    queue.add(tmp);
                else {
                    queue.poll();
                    queue.add(tmp);
                }
            }
        }

        return answer;
    }
}
