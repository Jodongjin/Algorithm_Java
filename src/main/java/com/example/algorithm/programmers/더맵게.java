package com.example.algorithm.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 더맵게 {
    public static void main(String[] args) {
        int answer = solution2(new int[]{1, 2, 3, 9, 10, 12}, 7);
        System.out.println("answer = " + answer);
    }
    /**
     * 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우 -> 요소가 하나만 남았을 때
     * scoville 오름차순 정렬
     *
     * 실패 3개..
     */
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i : scoville) {
            list.add(i);
        }
        // 리스트의 최소값이 K보다 작거나 리스트의 길이가 1보다 크면 반복
        while (Collections.min(list) < K && list.size() > 1) {
            int min1 = Collections.min(list); // 가장 작은 값
            list.remove(Integer.valueOf(min1));
            int min2 = Collections.min(list); // 두 번째 작은 값
            list.remove(Integer.valueOf(min2));
            list.add(min1 + (min2 * 2)); // 두 번째로 작은 값 * 가장 작은 값 insert
            answer++;
        }

        return answer;
    }

    /**
     * 우선순위 큐를 이용하여 구현
     */
    public static int solution2(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // 낮은 게 우선
        for(int i : scoville) {
            queue.add(i);
        }

        while(queue.peek() < K && queue.size() > 1) {
            int min1 = queue.poll();
            int min2 = queue.poll();
            queue.add(min1 + (min2 * 2));

            answer++;
        }
        if(queue.size() == 1 && queue.peek() < K) // 하나만 남고 K보다 작으면 불가능
            answer = -1;

        return answer;
    }
}
