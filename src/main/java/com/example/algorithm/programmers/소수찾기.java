package com.example.algorithm.programmers;

import java.util.HashSet;

public class 소수찾기 {
    public static void main(String[] args) {
        int answer = solution2("17");
        System.out.println("answer = " + answer);
    }

    /**
     *
     */
    public static int solution2(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set); // 순열을 set에 저장 (중복 x)
        System.out.println("set = " + set);
        System.out.println("numbers = " + numbers.substring(0, 1));
        int count = 0;
        while(set.iterator().hasNext()){
            int a = set.iterator().next();
            set.remove(a);
            if(isPrime(a)){
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int n){
        if(n < 2) return false;
        for(int i=2; i<=(int)Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }

    // 순열 함수 -> 순서에 상관 있게
    public static void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++) // i 번째 문자는 제외
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);

    }
}
