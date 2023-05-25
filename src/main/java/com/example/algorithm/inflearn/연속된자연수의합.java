package com.example.algorithm.inflearn;

import java.util.Scanner;

public class 연속된자연수의합 {
    public static void main(String[] args) {
        연속된자연수의합 T = new 연속된자연수의합();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }

    /**
     * startPoint = 0
     * while(startPoint < n)
     *  int sum = startPoint
     *  while(startPoint < n)
     *    sum += 1
     *  if(sum == n) answer++
     */
    public int my_solution(int n) {
        int answer = 0;
        int startPoint = 1;
        int sum = 0;

        while(startPoint < n) {
            sum = startPoint;
            while(sum < n) {
                sum += sum + 1;
            }
            if(sum == n) answer++;
            startPoint++;
        }

        return answer;
    }

    /**
     * two point
     * n / 2 + 1 까지만 확인
     * lt, rt를 사용
     */
    public int solution(int n) {
        int answer = 0, sum = 0, lt = 0;
        int m = n / 2 + 1;
        int[] arr = new int[m];
        for(int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }

        for(int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if(sum == n) answer++;
            while(sum >= n) {
                sum -= arr[lt++];
                if(sum == n) answer++;
            }
        }

        return answer;
    }

    /**
     * 수학적 방법
     * ex) 15 -> 1과 2를 떼어 12가 남음
     * 12 / 2 = 6
     * 1에 + 6, 2에 + 6 => 7, 8 2자리 연속된 숫자 달성
     * 즉, 떼어낸 개수만큼 나눴을 때 나머지가 0이면 나눈 수를 각자에 더한 게 정답
     * 즉, 빼고 난 나머지를 뺀 수로 나누었을 때 나머지가 0이면 cnt만큼 연속된 숫자로 n 만들기 가능
     * 마지막에 n = 0, cnt = 5가 되는데 0을 5로 나눈 몫과 나머지는 0 (0으로 나눌 때 divide error!)
     */
    public int solution2(int n) {
        int answer = 0, cnt = 1;
        n--;
        while(n > 0) {
            cnt++;
            n = n - cnt; // cnt는 뺀 개수 (첫 loop에서는 n--, n = n - cnt 두 번 뺐으므로 2)
            if(n % cnt == 0) answer++;
        }

        return answer;
    }
}
