package com.example.algorithm.programmers;

import com.example.algorithm.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    public static void main(String[] args) {
        int answer = solution2(new int[][]{
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}});
        System.out.println("answer = " + answer);
    }

    static class Position {
        int x,y;

        public Position(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public static int solution2(int[][] maps) {
        int answer = 0;
        int[][] move ={{0,1},{0,-1},{1,0},{-1,0}}; // up, down, right, left
        Queue<Position> que = new LinkedList();
        int[][] count =new int[maps.length][maps[0].length];

        que.add(new Position(0,0));
        count[0][0]=1;

        while(!que.isEmpty()){
            Position cur = que.poll();
            int curcount = count[cur.y][cur.x];
            for(int i=0;i<4;i++){ // 상하좌우 이동
                Position p = new Position(cur.x+move[i][0],cur.y+move[i][1]);
                //맵밖으로 나갈때
                if(p.x<0||p.y<0||p.x==maps[0].length||p.y==maps.length){
                    continue;
                }
                //벽에 부딪힐때
                if(maps[p.y][p.x]==0){
                    continue;
                }
                count[p.y][p.x]=curcount+1;
                //이미 지난길은 벽으로 만들어버리기
                maps[p.y][p.x]=0;
                que.add(p);
            }
        }
        answer=count[maps.length-1][maps[0].length-1];
        if(answer==0){
            return -1;
        }
        return answer;
    }



    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static int solution3(int[][] maps) {
        int answer = 0;

        int[][] visited = new int[maps.length][maps[0].length];

        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1];

        if(answer == 0){
            answer = -1;
        }

        return answer;
    }

    public static void bfs(int[][] maps, int[][] visited){
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] current = queue.remove();
            int cX = current[0];
            int cY = current[1];

            for(int i = 0; i < 4; i++){
                int nX = cX + dx[i];
                int nY = cY + dy[i];

                if(nX < 0 || nX > maps.length-1 || nY < 0 || nY > maps[0].length-1)
                    continue;

                if(visited[nX][nY] == 0 && maps[nX][nY] == 1){
                    visited[nX][nY] = visited[cX][cY] + 1;
                    queue.add(new int[]{nX, nY});
                }
            }

        }
    }

    public static int solution_1(int[][] maps) {
        int answer = 0;
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // up, down, right, left
        Queue<Position> queue = new LinkedList<>();
        int[][] count = new int[maps.length][maps[0].length];

        queue.add(new Position(0, 0)); // 출
        count[0][0] = 1; // 발

        while(!queue.isEmpty()) {
            Position currentPos = queue.poll();
            int currentCnt = count[currentPos.y][currentPos.x]; // 주의: 0 번째 idx가 y
            for(int i = 0; i < 4; i++) {
                Position nextPos = new Position(currentPos.x + move[i][1], currentPos.y + move[i][0]);
                if(nextPos.x < 0 || nextPos.y < 0 || nextPos.x == maps[0].length || nextPos.y == maps.length) // 맵 밖으로 나갈 때
                    continue;

                if(maps[nextPos.y][nextPos.x] == 0) // 벽에 부딪힐 때
                    continue;

                count[nextPos.y][nextPos.x] = currentCnt + 1;
                maps[nextPos.y][nextPos.x] = 0; // * 이미 지난 길은 벽으로 만들기
                queue.add(nextPos);
            }
        }
        answer = count[maps.length - 1][maps[0].length - 1];
        if(answer == 0) // 도착하지 못 했을 때
            return -1;

        return answer;
    }
}
