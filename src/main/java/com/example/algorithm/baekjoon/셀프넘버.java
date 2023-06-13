package com.example.algorithm.baekjoon;

public class 셀프넘버 {
    public static void main(String[] args) {
        셀프넘버 T = new 셀프넘버();
        T.solution();
    }

    public void solution() {
        boolean[] checkN = new boolean[10001]; // idx 10000까지

        for(int i = 1; i <= 10000; i++) {
            int n = check(i);

            if(n <= 10000)
                checkN[n] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 10000; i++) {
            if(!checkN[i])
                sb.append(i).append('\n');
        }

        System.out.println(sb);
    }

    public int check(int n) {
        int sum = n;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}
