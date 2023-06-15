package com.example.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 영어끝말잇기 {
    public static void main(String[] args) {
        영어끝말잇기 T = new 영어끝말잇기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++)
            arr[i] = kb.next();

        System.out.println(Arrays.toString(T.my_solution(n, arr)));
    }

    public int[] my_solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<>();

        // list의 마지막 요소의 마지막 글자로 시작하는지 && list에 포함된 단어인지
        int cnt = 1;
        for(String word : words) {
            if(list.isEmpty())
                list.add(word);
            else {
                String tmp = list.get(list.size() - 1); // 마지막 요소
                if(list.contains(word) || tmp.charAt(tmp.length() - 1) != word.charAt(0)) {
                    if(cnt % n == 0) {
                        answer[0] = n;
                        answer[1] = cnt / n;
                    }
                    else {
                        answer[0] = cnt % n;
                        answer[1] = cnt / n + 1;
                    }
                    break;
                }
                else
                    list.add(word);
            }
            System.out.println("list = " + list);
            cnt++;
        }

        return answer;
    }
}