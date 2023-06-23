package com.example.algorithm.programmers;

public class 스킬트리 {
    public static void main(String[] args) {
        스킬트리 T = new 스킬트리();
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(T.my_solution(skill, skill_trees));
    }

    public int my_solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String s : skill_trees) {
            int idx = 0;
            boolean check = true;
            for(char c : s.toCharArray()) {
                if(skill.contains(String.valueOf(c))) {
                    if(c != skill.charAt(idx)) {
                        check = false;
                        break;
                    } else {
                        idx++;
                        if(idx == skill.length()) break;
                    }
                }
            }
            if(check) answer++;
        }
        return answer;
    }
}
