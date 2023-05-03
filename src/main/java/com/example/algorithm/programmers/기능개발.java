package com.example.algorithm.programmers;

import java.util.*;

public class 기능개발 {
    public static void main(String[] args) {
        int[] answer = solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
        System.out.println("answer = " + Arrays.toString(answer));
    }
    /**
     * day = (100 - progress) / speed (나머지가 0이 아니면 + 1)
     * day array (작업의 순서대로)
     * day array loop -> 이전 index의 day보다 작으면(빨리 되면) cnt++
     *   크면(늦게 되면) cnt -> answer에 출력
     */
    // 테스트 케이스 4개 틀림
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        List<Integer> dayList = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) % speeds[i] == 0 ?
                    (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] + 1;
            dayList.add(day);
        }
        System.out.println("dayList = " + dayList);

        int preDay = dayList.get(0);
        int cnt = 1;
        for(int i = 1; i < dayList.size(); i++) {
            if(preDay > dayList.get(i))
                cnt++;
            else {
                answerList.add(cnt);
                cnt = 1;
                preDay = dayList.get(i);
            }
        }
        answerList.add(cnt);
        answer = answerList.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    /**
     * cnt 역할이 q.size()
     */
    public static int[] solution2(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain); // day 계산

            if (!q.isEmpty() && q.peek() < date) { // 이전 day가 더 작으면(빠르면) => 바로 출시
                answerList.add(q.size());
                q.clear();
            }

            q.offer(date); // 현재 작업의 day를 넣고 다음 작업과 비교
        }
        answerList.add(q.size()); // 남은 cnt를 add
        answer = answerList.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}
