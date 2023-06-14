package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 통계학 {
    public static void main(String[] args) throws IOException {
        /*
        통계학 T = new 통계학();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = kb.nextInt();

        T.my_solution(n, arr);
         */

        /**
         * solution
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int[] nums = new int[cnt];

        double sum  = 0;

        for(int i = 0 ; i < cnt ; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }

        Arrays.sort(nums);

        int count = 0;
        int max = -1;
        int mod = nums[0];

        boolean check = false;

        //최빈값 구하는 반복문
        for(int i = 0; i < cnt - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                count++;
            }else {
                count = 0;
            }

            if(max < count) {
                max = count;
                mod = nums[i];
                check = true;
            }else if(max == count && check == true) {
                mod = nums[i];
                check = false;
            }
        }
        System.out.println(Math.round(sum / cnt)); 	 // 산술평균
        System.out.println(nums[(cnt - 1) / 2]); 	 // 중앙값
        System.out.println(mod); 			 		 // 최빈값
        System.out.println(nums[cnt - 1] - nums[0]); // 최대값 - 최소값
    }

    /**
     * 오답 이유 찾기
     */
    public void my_solution(int n, int[] arr) {
        int avg = 0;
        int mid = 0;
        int maxBin = 0;
        int range = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);

        for(int i : arr) {
            avg += i;
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for(int k : map.keySet()) {
            if(max < map.get(k)) {
                max = map.get(k);
                if(list.size() == 0)
                    list.add(k);
                else {
                    list.clear();
                    list.add(k);
                }
            } else if(max == map.get(k)) {
                list.add(k);
            }
        }
        if(list.size() > 1) {
            Collections.sort(list);
            maxBin = list.get(1);
        } else
            maxBin = list.get(0);

        avg = Math.round((avg / n));
        mid = arr[n / 2];
        range = Math.abs(arr[n - 1] - arr[0]);

        System.out.println(avg + "\n" + mid + "\n" + maxBin + "\n" + range);
    }
}

/**
 * 반올림하여 소수점 나타내기
 * double PI = 3.141592;
 * System.out.println(String.format("%.3f", nn)); -> 3.142
 */