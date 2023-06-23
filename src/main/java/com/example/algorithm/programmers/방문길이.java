package com.example.algorithm.programmers;

import java.util.*;

public class 방문길이 {
    public static void main(String[] args) {
        방문길이 T = new 방문길이();
        Scanner kb = new Scanner(System.in);
        String dirs = kb.next();

        System.out.println(T.solution(dirs));
    }

    public int solution(String dirs) {
        int answer = 0;
        boolean visit[][][] = new boolean[11][11][4]; // 방향(4) 포함
        int x = 5, y = 5; // 시작 위치 5, 5
        for(char c : dirs.toCharArray()) {
            int d = 0;
            int nx = x;
            int ny = y;
            if(c == 'U') {
                ny++;
                d = 0;
            }
            else if(c == 'D') {
                ny--;
                d = 1;
            }
            else if(c == 'L') {
                nx--;
                d = 2;
            }
            else if(c == 'R') {
                nx++;
                d = 3;
            }

            if(nx < 0 || ny < 0 || nx > 10 || ny > 10) continue;

            if(!visit[nx][ny][d]) {
                visit[nx][ny][d] = true;
                /* 왕복을 생각해서 반대 방향에서 오는 경우도 true로 체크 해둔다 */
                d = (d % 2 == 0) ? 2 - d: 4 - d;
                visit[x][y][d] = true;
                answer++;
            }
            x = nx;
            y = ny;
        }

        return answer;
    }

    /**
     * 처음 머릿속으로 그렸던 방법을 코드로 구현하신 분의 코드 ,, 존경스럽다
     */
    public int solution2(String dirs) {
        Map<String, int[]> map = new HashMap<>();
        map.put("U", new int[] {0, 1});
        map.put("D", new int[] {0, -1});
        map.put("R", new int[] {1, 0});
        map.put("L", new int[] {-1, 0});

        String[] arr = dirs.split("");

        Set<String> set = new HashSet<>();
        int cx = 0;
        int cy = 0;

        for(int i=0; i<arr.length; i++) {
            String s = arr[i];

            int x = map.get(s)[0];
            int y = map.get(s)[1];

            cx += x;
            cy += y;

            if(cx < -5 || cx > 5) {
                cx -= x;
                continue;
            }
            if(cy < -5 || cy > 5) {
                cy -= y;
                continue;
            }
            set.add(""+(cx-x)+ ""+ (cy-y)+ ""+cx + ""+cy);
            set.add(""+cx + ""+cy+""+(cx-x)+ ""+ (cy-y));
        }
        return set.size()/2;
    }
}
