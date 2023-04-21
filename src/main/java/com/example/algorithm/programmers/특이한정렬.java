package com.example.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 특이한정렬 {
    public static void main(String[] args) {
        int[] answer = solution2(new int[]{1, 2, 3, 4, 5, 6}, 4);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    public static int[] solution2(int[] numlist, int n) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Arrays.sort(numlist);
        for(int num: numlist) {
            list.add(num);
        }

        list.sort((n1, n2) -> Integer.compare(Math.abs(n - n2), Math.abs(n - n1)));
        Collections.reverse(list);
        answer = list.stream().mapToInt(num -> num).toArray();

        return answer;
    }

    public static int[] solution3(int[] numList, int n) {
        return Arrays.stream(numList)
                .boxed()
                .sorted((a, b) -> Math.abs(a - n) == Math.abs(b - n) ? b.compareTo(a) : Integer.compare(Math.abs(a - n), Math.abs(b - n)))
                .mapToInt(Integer::intValue)
                .toArray();

        // b.compareTo(a)로 해야함
    }
}
