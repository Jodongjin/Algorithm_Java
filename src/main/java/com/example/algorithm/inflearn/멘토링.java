package com.example.algorithm.inflearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 멘토링 {
    public static void main(String[] args) {
        멘토링 T = new 멘토링();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 학생 수
        int m = kb.nextInt(); // 테스트 수
        int[][] arr = new int[m][n]; // 학생 1번부터 시작
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.println(T.solution(n, m, arr));
    }

    /**
     * p = 사람 번호, p loop -> 몇 명의 멘티를 둘 수 있나
     * j = 테스트 번째 (arr row)
     * k = 등수 (arr colunm)
     * 자신보다 앞에 있는 사람의 번호를 지운다
     */
    public int my_solution(int n, int m, int[][] arr) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int p = 0; p < n; p++) {
            for(int l = 0; l < n; l++) { // 자신을 제외하고 모두 멘티로 등록
                if(l == p)
                    continue;
                list.add(l);
            }

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(arr[i][j] == p + 1) { // 현재 학생의 등수는 j
                        for(int k = 0; k < j; k++) { // j보다 앞에 있는 학생 번호를 list에서 제거
                            if(list.indexOf(arr[i][k] - 1) != -1) // list에 있다면
                                list.remove(list.indexOf(arr[i][k] - 1)); // 제거
                        }
                    }
                }
            }
            System.out.println(p + " 번의 멘티 수: " + list.stream().count());

            answer += list.stream().count();
            list.clear();
        }

        return answer;
    }

    /**
     * 총 경우의 수에서 빼가는 식
     * 총 경우의 수는 n x n (i==j인 경우 포함)
     * i, j = 멘토, 멘티 (1 ~ 4) -> 실제 값은 학생 번호이기 때문에 1번 부터
     * k, s = 테스트 번호, 등수 (2차원 배열) (0 ~ 3)
     * 각 테스트에서 i와 j의 등수를 저장
     * i의 등수가 j보다 높으면 cnt++
     * k(테스트)를 다 돌았을 때 cnt == m이면 answer++
     */
    public int solution(int n, int m, int[][] arr) {
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                // i와 j의 값이 같으면 pi, pj의 값이 같으므로 cnt == m이 절대 성사 x
                // if(i == j) continue; 해도 됨
                int cnt = 0;
                for(int k = 0; k < m; k++) {
                    int pi = 0; // 어차피 무조건 초기화 됨
                    int pj = 0;
                    for(int s = 0; s < n; s++) {
                        if(arr[k][s] == i)
                            pi = s;
                        if(arr[k][s] == j)
                            pj = s;
                    }
                    if(pi < pj) // 수가 작아야 등수가 빠름
                        cnt++;
                }

                if(cnt == m)
                    answer++;
            }
        }

        return answer;
    }
}
