package com.example.algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        int answer = solution3(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
        System.out.println("answer = " + answer);
    }
    /**
     * queue: 다리 공간
     */
    public static int solution2(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }

        int idx = 0;
        int nowWeight = 0;
        while(idx < truck_weights.length) {
            nowWeight -= queue.poll(); // 빠짐
            answer++; // 들어옴
            if(nowWeight + truck_weights[idx] <= weight) { // 추가 가능하면
                queue.add(truck_weights[idx]); // 다리에 트럭 추가
                nowWeight += truck_weights[idx]; // 현재 다리 무게 추가
                idx++; // 트럭을 넣었으니까 idx 증가
            }
            else // 추가가 안 되면
                queue.add(0); // 0을 추가 -> 트럭의 진행
        }
        answer += bridge_length; // 마지막에 추가된 트럭이 지나갈 시간 == 다리 길이

        return answer;
    }

    static class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public static int solution3(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++; // 시간은 초 단위로 증가, 아래는 매 초마다 일어나는 일

            if (moveQ.isEmpty()) { // 다리 위에 트럭이 없을 때
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            for (Truck t : moveQ) { // 다리 위 모든 트럭 한 칸씩 전진
                t.moving();
            }

            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) { // 다리에 트럭 추가 가능한 경우
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t); // 다리 위 트럭 추가, moving()은 안 함 default가 1이기 때문
            }
        }

        return answer;
    }
}
