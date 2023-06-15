package com.example.algorithm.programmers;

import java.util.*;

public class 구명보트 {
    public static void main(String[] args) {
        구명보트 T = new 구명보트();
        Scanner kb = new Scanner(System.in);
        int[] people = {70, 50, 80,50};
        int limit = 100;

        System.out.println(T.my_solution(people, limit));
    }

    /**
     * 문제에서 두 명까지라는 것을 못 보고 구현해버림 ,, ㅜㅜ
     */
    public int my_solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int sum;
        int idx = 0;
        while (idx < people.length) {
            sum = 0;
            while (sum + people[idx] <= limit) {
                sum += people[idx];
                idx++;
                if(idx == people.length) break;
            }
            answer++;
        }

        return answer;
    }

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int min = 0;
        for(int max = people.length - 1; min <= max; max--) {
            if(people[min] + people[max] <= limit) min++; // 가능하면 min++으로 한 명 더 태움
            answer++;
        }

        return answer;
    }
}
