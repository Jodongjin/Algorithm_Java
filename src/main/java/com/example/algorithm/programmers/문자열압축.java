package com.example.algorithm.programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 문자열압축 {
    public static void main(String[] args) {
        문자열압축 T = new 문자열압축();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();

        System.out.println(T.solution(s));
    }

    /**
     * 0.5 솔
     */
    public int my_solution(String s) {
        int answer = s.length();

        for(int i = 1; i <= s.length() / 2; i++) {
            int tmpLen = 0;
            int cnt = 1;
            for(int j = i; j <= s.length() - i; j += i) {
                if(s.substring(j - i, j).equals(s.substring(j, j + i))) {
                    cnt++;
                }
                else {
                    if(cnt >= 2)
                        tmpLen += i + 1;
                    else
                        tmpLen += i;
                    cnt = 1;
                }
            }
            if(cnt >= 2)
                tmpLen += i + 1;
            else
                tmpLen += i;

            tmpLen += s.length() % i;

            if(tmpLen < answer)
                answer = tmpLen;
        }

        return answer;
    }

    /**
     * String.substring(start, end) -> 같은 수를 입력하면 null return (길이 이하)
     */
    public int solution(String s) {
        int answer = s.length();

        int count = 1;
        for(int i = 1; i <= s.length() / 2; i++) {
            StringBuilder result = new StringBuilder();
            String base = s.substring(0, i);
            for (int j = i; j <= s.length(); j += i) {
                int endIdx = Math.min(j + i, s.length()); // 인덱스 이탈 방지
                String compare = s.substring(j, endIdx);
                if (base.equals(compare)) // 이전 문자열(base)와 현재 문자열(compare) 비교
                    count++;
                else { // 비교 결과가 다르면
                    if (count >= 2) // 중복이 2 이상이면 숫자 추가
                        result.append(count);
                    result.append(base); // 비교 결과 다르면 어쨋든 문자는 추가해야 함
                    base = compare;
                    count = 1;
                }
            }
            result.append(base); // 마지막 문자 붙이기
            answer = Math.min(answer, result.length());
        }

        return answer;
    }
}
