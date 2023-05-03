package com.example.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 가장큰수 {
    public static void main(String[] args) {
        String answer = solution2(new int[]{6, 10, 2});
        System.out.println("answer = " + answer);
    }

    /**
     *
     */
    public static String solution2(int[] numbers) {
        String answer = "";
        String []res = new String[numbers.length];

        //문자열로 변경
        for(int i=0; i<numbers.length; i++){
            res[i]=String.valueOf(numbers[i]);
        }
        System.out.println("res = " + Arrays.toString(res));

        //문자열을 합쳤을 때 비교 -> 106 vs 610 ... 아스키 코드 값으로 비교
        Arrays.sort(res, (a,b)->{
            return (a+b).compareTo(b+a);
        });

        //정렬한 값 더하기
        for(int i=numbers.length-1; i>=0; i--){
            answer+=res[i];
        }

        //ex) 000인 경우 0으로 리턴
        if(answer.charAt(0)=='0') return "0";

        return answer;
    }

    public static String solution3(int[] numbers) {
        String answer = "";

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });
        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(i);
        }
        answer = sb.toString();
        if(answer.charAt(0) == '0') {
            return "0";
        }else {
            return answer;
        }
    }
}
