package com.example.algorithm.programmers;

import java.util.Scanner;

public class k진수에서소수개수구하기 {
    public static void main(String[] args) {
        k진수에서소수개수구하기 T = new k진수에서소수개수구하기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();

        System.out.println(T.my_solution(n, k));
    }

    /**
     * 0.9솔
     * 케이스 1개가 런타임 에러 ,, ㅜㅜ
     * tmp는 long으로 처리해야 함 -> int로 했다가 런타임 에러 폭탄
     */
    public int my_solution(int n, int k) {
        int answer = 0;
        String convert = Integer.toString(n, k);

        String tmp = "";
        for(char c : convert.toCharArray()) {
            if(c == '0') {
                if(tmp != "" && isPrime(Integer.parseInt(tmp)))
                    answer++;
                tmp = "";
            }
            else tmp += c;
        }
        if(isPrime(Long.parseLong(tmp))) answer++;

        return answer;
    }

    public int solution(int n, int k) {
        int answer = 0;
        String temp="";

        // 내장 함수 없이 N진법으로 변환
        while(n!=0){
            temp=n%k+temp;
            n/=k;
        }

        String[] arr = temp.split("0");

        for(String data: arr){
            if(data.equals("")) continue;
            long num=Long.parseLong(data);
            if(isPrime(num)){
                answer++;
            }
        }

        return answer;
    }

    public boolean isPrime(long n) {
        if(n < 2) return false;
        else if(n == 2) return true;
        else {
            for(int i = 2; i <= Math.sqrt(n); i++) {
                if(n % i == 0) return false;
            }
        }

        return true;
    }
}
