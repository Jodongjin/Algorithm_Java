package com.example.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 같은숫자는싫어 {
    public static void main(String[] args) {
        int[] answer = solution2(new int[]{1,1,3,3,0,1,1});
        System.out.println("answer = " + Arrays.toString(answer));
    }
    /**
     *
     */
    public static int[] solution2(int []arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();

        int preInt = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != preInt) {
                list.add(arr[i]);
                preInt = arr[i];
            }
        }
        answer = list.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}
