package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 파일명정렬 {
    public static void main(String[] args) {
        파일명정렬 T = new 파일명정렬();
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

        System.out.println(Arrays.toString(T.solution(files)));
    }

    /**
     * Comparator<>를 이용한 배열 정렬
     * 유용하니 꼭 알아둘 것
     */
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                String[] file1 = detach(s1);
                String[] file2 = detach(s2);

                int headValue = file1[0].compareTo(file2[0]);

                if(headValue == 0) {
                    int num1 = Integer.parseInt(file1[1]);
                    int num2 = Integer.parseInt(file2[1]);

                    return num1 - num2; // 양수이면 num1이 크고, 음수이면 num2가 큼
                } else {
                    return headValue;
                }
            }

            private String[] detach(String str) {
                String head = "";
                String number = "";
                String tail = "";

                int idx = 0;
                for( ; idx < str.length() ; ++idx) {
                    char ch = str.charAt(idx);
                    if(ch >= '0' && ch <= '9') break;
                    head += ch;
                }

                for( ; idx < str.length() ; ++idx) {
                    char ch = str.charAt(idx);
                    if(!(ch >= '0' && ch <= '9')) break;
                    number += ch;
                }

                for( ; idx < str.length() ; ++idx) {
                    char ch = str.charAt(idx);
                    tail += ch;
                }

                String[] file = {head.toLowerCase(), number, tail};

                return file;
            }
        });
        return files;
    }
}
