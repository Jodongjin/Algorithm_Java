package com.example.algorithm.programmers;

public class 옹알이_1 {
    public static void main(String[] args) {
        int answer = solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"});
        System.out.println("answer = " + answer);
    }

    // 테스트 3개 정도 실패..
    public static int solution(String[] babbling) {
        int answer = 0;
        String[] words = new String[]{"aya", "woo", "ye", "ma"};

        for(String str : babbling) {
            String temp = str;
            for(String word : words) {
                temp = temp.replace(word, "");
            }
            if(temp.length() == 0) {
                answer++;
            }

        }

        return answer;
    }

    public static int solution2(String[] babbling) {
        int answer = 0;

        for(int i =0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replace("aya", "1");
            babbling[i] = babbling[i].replace("woo", "1");
            babbling[i] = babbling[i].replace("ye", "1");
            babbling[i] = babbling[i].replace("ma", "1");
            babbling[i] = babbling[i].replace("1", "");
            if(babbling[i].isEmpty()) {
                answer = answer + 1;
            }
        }

        return answer;
    }
}
