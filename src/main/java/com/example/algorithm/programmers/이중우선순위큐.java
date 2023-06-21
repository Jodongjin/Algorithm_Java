package com.example.algorithm.programmers;

import java.util.*;

public class 이중우선순위큐 {
    public static void main(String[] args) {
        이중우선순위큐 T = new 이중우선순위큐();
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        System.out.println(Arrays.toString(T.my_solution(operations)));
    }

    public int[] my_solution(String[] operations) {
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<>();

        for(String s : operations) {
            String[] split = s.split(" ");
            switch(split[0]) {
                case "I":
                    list.add(Integer.parseInt(split[1]));
                    break;
                case "D":
                    if(list.isEmpty()) continue;
                    if(split[1].equals("1")) { // 최댓값 삭제
                        int max = Integer.MIN_VALUE;
                        int maxIdx = -1;
                        for(int i = 0; i < list.size(); i++) {
                            if(list.get(i) > max) {
                                max = list.get(i);
                                maxIdx = i;
                            }
                        }
                        list.remove(maxIdx);
                    } else { // 최솟값 삭제
                        int min = Integer.MAX_VALUE;
                        int minIdx = -1;
                        for(int i = 0; i < list.size(); i++) {
                            if(list.get(i) < min) {
                                min = list.get(i);
                                minIdx = i;
                            }
                        }
                        list.remove(minIdx);
                    }
                    break;
                default:
            }
        }

        if(!list.isEmpty()) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int minIdx = -1;
            int maxIdx = -1;
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i) > max) {
                    max = list.get(i);
                    maxIdx = i;
                }
                if(list.get(i) < min) {
                    min = list.get(i);
                    minIdx = i;
                }
            }
            answer[0] = list.get(maxIdx);
            answer[1] = list.get(minIdx);
        }

        return answer;
    }

    /**
     * 출제 의도는 이게 맞는 듯 ,,
     * 우선순위 덱이 없어서 List로 구현했는데 reverse 우선순위 큐를 두는 방법이 ,, !
     */
    public int[] solution(String[] operations) {
        int[] answer = {0,0};

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> reverse_pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0; i<operations.length; i++) {
            String temp[] = operations[i].split(" ");
            switch(temp[0]) {
                case "I" :
                    pq.add(Integer.parseInt(temp[1]));
                    reverse_pq.add(Integer.parseInt(temp[1]));
                    break;
                case "D" :
                    if(pq.size() > 0) {
                        if(Integer.parseInt(temp[1]) == 1) {
                            // 최댓값 삭제
                            int max = reverse_pq.poll();
                            pq.remove(max);
                        } else {
                            // 최솟값 삭제
                            int min = pq.poll();
                            reverse_pq.remove(min);
                        }
                    }
                    break;
            }
        }

        if(pq.size() >= 2) {
            answer[0] = reverse_pq.poll();
            answer[1] = pq.poll();
        }

        return answer;
    }
}
