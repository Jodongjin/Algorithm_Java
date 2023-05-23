package com.example.algorithm.inflearn;

import java.util.*;

public class 등수구하기 {
    public static void main(String[] args) {
        등수구하기 T = new 등수구하기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for(int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }

    public int[] my_solution(int n, int[] arr) {
        int[] answer = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(arr[i], 0); // 점수 : 등수
        }
        Integer[] gradeArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(gradeArr, Collections.reverseOrder()); // 내림차순 정렬

        map.put(gradeArr[0], 1); // 1등
        int cnt = 1;
        int grade = 1;
        for(int i = 1; i < n; i++) {
            if(gradeArr[i - 1] == gradeArr[i]) {
                gradeArr[i] = grade;
                map.put(gradeArr[i], grade);
                cnt++;
            }
            else {
                grade += cnt;
                map.put(gradeArr[i], grade);
                cnt = 1;
            }
        }

        for(int i = 0; i < n; i++) {
            answer[i] = map.get(arr[i]);
        }

        return answer;
    }

    /**
     * 2중 반복문으로 큰 점수가 있다면 등수 증가
     * 같은 점수가 있으면 해당 부분에서 모두 cnt(등수)가 증가 -> 같은 등수 구현 가능
     */
    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            int cnt = 1;
            for(int j = 0; j < n; j++) {
                if(arr[j] > arr[i])
                    cnt++;
            }
            answer[i] = cnt;
        }

        return answer;
    }
}
