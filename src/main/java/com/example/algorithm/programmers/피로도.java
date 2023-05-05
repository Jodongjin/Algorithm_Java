package com.example.algorithm.programmers;

public class 피로도 {
    static boolean[] visited;
    static int count = 0;
    static int idx = 0;
    public static void main(String[] args) {
        int answer = solution(80, new int[][]{{80,20},{50,40},{30,10}});
        System.out.println("answer = " + answer);
    }

    /**
     * DFS 활용
     */
    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return count;
    }

    /**
     * DFS: 깊이 우선 탐색
     * 최대 탐험 가능 던전 수 == 얼마나 깊이 갈 수 있냐
     */
    public static void dfs(int depth, int fatugue, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i] || dungeons[i][0] > fatugue) { // 이미 방문했거나 체력이 안 되면
                continue; // pass
            }
            visited[i] = true;
            dfs(depth + 1, fatugue - dungeons[i][1], dungeons);
            visited[i] = false; // 다음 i를 위해 false로 초기화
        }
        count = Math.max(count, depth);
    }
}
