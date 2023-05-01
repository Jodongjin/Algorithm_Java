package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.HashSet;

public class 포켓몬 {
    public static void main(String[] args) {
        int answer = solution(new int[]{3, 1, 2, 3});
        System.out.println("answer = " + answer);
    }

    /**
     * pick num은 nums.length / 2
     * nums 중복 제거 count >= pick num => return pick num
     * nums 중복 제거 count < pick num => return 중복 제거 count
     */
    public static int solution(int[] nums) {
        int answer = 0;
        int pickNum = nums.length / 2;
        int count = (int) Arrays.stream(nums).distinct().count();

        if(count >= pickNum)
            answer = pickNum;
        else
            answer = count;

        return answer;
    }

    public static int solution2(int[] nums) {
        int answer = 0;
        HashSet<Integer> hs = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }

        if(hs.size() > nums.length/2)
            answer = nums.length/2;
        else
            answer = hs.size();

        return answer;
    }
}
