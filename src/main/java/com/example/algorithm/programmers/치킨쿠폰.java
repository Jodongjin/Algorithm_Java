package com.example.algorithm.programmers;

public class 치킨쿠폰 {
    public static void main(String[] args) {
        int answer = solution(1081);
        System.out.println("answer = " + answer);
    }
    public static int solution(int chicken) {
        int answer = -1;
        int service = chicken / 10;
        int coupon = (chicken / 10) + (chicken % 10);

        while(coupon >= 10) {
            service += coupon / 10;
            coupon = (coupon / 10) + (coupon % 10);
        }
        answer = service;

        return answer;
    }
}
