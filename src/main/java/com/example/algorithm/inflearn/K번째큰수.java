package com.example.algorithm.inflearn;

import java.time.temporal.Temporal;
import java.util.*;

public class K번째큰수 {
    public static void main(String[] args) {
        K번째큰수 T = new K번째큰수();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(arr, n, k));
    }

    /**
     * 완전 바보 ,,
     * 3중 for 문을 돌아야 함
     * 밑에 코드는 단순히 정렬된 거 훑으면서 더하는 것
     * 모든 경우의 수를 구하려면 3중 for 문
     */
    public int my_solution(int n, int k, int[] arr) {
        int answer = Integer.MAX_VALUE;
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

        int sum = 0;
        for(int i = n - 1; i >= 2; i--) {
            sum = arr[i] + arr[i - 1] + arr[i - 2];
            map.put(sum, map.getOrDefault(sum, 0) + 1);

            if(map.size() == 3) {
                System.out.println(map.keySet());
                break;
            }
        }

        for(int i : map.keySet()) {
            if(answer > i)
                answer = i;
        }

        return answer;
    }

    /**
     * <TreeSet>
     * 중복 제거, 정렬
     */
    public int solution(int[] arr, int n, int k) {
        int answer = -1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder()); // 내림차순 정렬
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int l = j + 1; l < n; l++) {
                    Tset.add(arr[i] + arr[j] + arr[l]); // 중복 제거하면서 내림차순 정렬
                }
            }
        }

        int cnt = 0;
        for(int x : Tset) {
            cnt++;
            if(cnt == k) return x;
        }

        /*
        Tset.remove(143); // 지우기
        Tset.size(); // 크기(원소의 개수)
        Tset.first(); // 첫 번째 요소
        Tset.last(); // 마지막 요소
        TreeMap<Integer, Integer> map = new TreeMap<>(); // 정렬 기능 제공하는 Map
         */

        return answer;
    }
}
