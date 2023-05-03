package com.example.algorithm.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 프로세스 {
    public static void main(String[] args) {
        int answer = solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        System.out.println("answer = " + answer);
    }
    /**
     *
     */
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        priorities[location] += 10; // +10으로 location을 구분
        Queue<Integer> queue = new LinkedList<>();
        for(int i : priorities) {
            queue.add(i);
        }

        boolean isFound = false; // 찾았으면 while break
        boolean isPass = true; // 뒤에 더 큰 우선순위가 없으면 통과 -> poll()
        while(!isFound) {
            isPass = true;
            int p = queue.poll();
            for(int i : queue) {
                if(p % 10 < i % 10) { // 뒤에 우선순위가 큰 요소가 있다면
                    queue.add(p); // 다시 넣고
                    isPass = false;
                    break;
                }
            }
            if(isPass) { // 한 바퀴 돌았는데 뒤에 우선순위가 큰 요소가 없다면
                answer++; // location의 순서 증가
                if(p > 10) // p가 location이라면
                    isFound = true; // 반복문 종료
            }
        }

        return answer;
    }

    public static int solution2(int[] priorities, int location) {
        List<Integer> list = new ArrayList<>();
        for (int priority : priorities) {
            list.add(priority);
        }

        int turn = 1;
        while (!list.isEmpty()) {
            final Integer j = list.get(0);
            if (list.stream().anyMatch(v -> j < v)) { // j보다 우선순위가 큰 게 있다면
                list.add(list.remove(0)); // 뺐다가 제일 뒤로 넣기
            } else {
                if (location == 0) {
                    return turn;
                }
                list.remove(0);
                turn++;
            }

            if (location > 0) { // location이 0보다 크다면
                location--; // location도 함께 앞으로 한 칸씩 이동
            } else {
                location = list.size() - 1; // 0이면 0으로 만든다 -> 이 코드는 없어도 될 거 같은데?
            }
        }

        throw new IllegalArgumentException();
    }
}
