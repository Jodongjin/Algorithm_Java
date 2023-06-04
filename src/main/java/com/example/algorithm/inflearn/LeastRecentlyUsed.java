package com.example.algorithm.inflearn;

import java.util.*;

public class LeastRecentlyUsed {
    public static void main(String[] args) {
        LeastRecentlyUsed T = new LeastRecentlyUsed();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = kb.nextInt();

        System.out.println(Arrays.toString(T.solution(s, n, arr)));
    }

    /**
     * 리스트로 구현
     */
    public List<Integer> my_solution(int s, int n, int[] arr) {
        List<Integer> list = new ArrayList<>();

        for(int i : arr) {
            if(list.contains(i)) { // 캐시에 있으면 제일 앞으로
                list.remove(list.indexOf(i));
                list.add(0, i);
            }
            else { // 없으면 제일 앞에 추가, 길이 초과 시 제일 뒤 삭제
                if(list.size() == s)
                    list.remove(s - 1);
                list.add(0, i);
            }
        }

        return list;
    }

    /**
     * 배열로 구현
     */
    public int[] my_solution2(int s, int n, int[] arr) {
        int[] answer = new int[s];

        for(int x : arr) {
            boolean isContain = false;
            for(int i = 0; i < s; i++) {
                if(answer[i] == x) {
                    isContain = true;
                    for(int j = i; j > 0; j--)
                        answer[j] = answer[j - 1];
                    answer[0] = x;
                }
            }

            if(!isContain) {
                for(int i = s - 1; i > 0; i--)
                    answer[i] = answer[i - 1];
                answer[0] = x;
            }
        }

        return answer;
    }

    public int[] solution(int s, int n, int[] arr) {
        int[] cache = new int[s];
        for(int x : arr) {
            int pos = -1;
            for(int i = 0; i < s; i++) if(x == cache[i]) pos = i;
            if(pos == -1) {
                for(int i = s - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            else {
                for(int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }

        return cache;
    }
}
