package com.example.algorithm;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
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
        return answer;
    }
}

