package com.example.algorithm.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class 뮤직비디오 {
    public static void main(String[] args) {
        뮤직비디오 T = new 뮤직비디오();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = kb.nextInt();

        System.out.println(T.my_solution(n, m, arr));
    }

    public int my_solution(int n, int m, int[] arr) {
        int answer = 0;
        answer = Arrays.stream(arr).sum() / m;

        while(true) {
            int cnt = 1; // DVD의 개수
            int sum = 0; // DVD의 용량
            for(int i = 0; i < n; i++) {
                if(sum + arr[i] <= answer) // DVD의 용량이 설정한 최소 용량을 넘어가지 않으면 더하기
                    sum += arr[i];
                else { // 새로운 sum(DVD)을 만드는 순간 cnt(DVD 개수) 증가
                    sum = arr[i];
                    cnt++;
                }
            }
            if(cnt == m) // DVD의 개수가 m과 같다면 answer(DVD의 최소 용량)가 정답
                break;
            answer++; // 같지 않다면 answer(DVD의 최소 용량) 증가
        }

        return answer;
    }

    /**
     * 찾고자 하는 답이 lt ~ rt 사이에 무조건 있을 때, 결정 알고리즘을 사용
     * 결정 알고리즘 -> 이분법으로 답을 추려나가는 것 (더 좋은 값을 탐색)
     */
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1; // 정답이 가능하므로 더 작은 갑을 시도
            }
            else lt = mid + 1;
        }

        return answer;
    }

    public int count(int[] arr, int capacity) { // 가능한 답인지 확인 (m 장 안에 담기는지)
        int cnt = 1; // DVD 장 수
        int sum = 0;
        for(int x : arr) {
            if(sum + x > capacity) {
                cnt++;
                sum = x;
            }
            else sum += x;
        }

        return cnt;
    }
}
