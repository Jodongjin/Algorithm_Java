package com.example.algorithm.programmers;

import java.util.*;

public class 베스트앨범 {
    public static void main(String[] args) {
        int[] answer = solution2(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        System.out.println("answer = " + Arrays.toString(answer));
    }
    /**
     * Map 장르별 플레이 수 내림차순 -> Key List로 뽑는다.
     * genres loop -> 장르에 해당 && max보다 큼 -> max값, maxIdx 갱신
     * max1, max2 두 번 진행
     * answer[cnt++]에 삽입
     */
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        answer = new int[map.size() * 2];

        List<String> listKeySet = new ArrayList<>(map.keySet());
        Collections.sort(listKeySet, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));

        int cnt = 0;
//        for(String s : listKeySet) {
//            int max1 = 0;
//            int max2 = 0;
//            int maxIdx1 = -1;
//            int maxIdx2 = -1;
//            for(int i = 0; i < genres.length; i++) {
//                if(genres[i].equals(s)) {
//                    if(plays[i] > max1) {
//                        if(max1 > max2) {
//                            max2 = max1;
//                            maxIdx2 = maxIdx1;
//                        }
//                        max1 = plays[i];
//                        maxIdx1 = i;
//                    } else if(plays[i] > max2) {
//                        max2 = plays[i];
//                        maxIdx2 = i;
//                    }
//                }
//            }
//            if(max2 != 0) {
//                answer[cnt++] = maxIdx1;
//                answer[cnt++] = maxIdx2;
//            } else
//                answer[cnt++] = maxIdx1;
//        }
        for(String s : listKeySet) {
            List<Integer> l = new ArrayList<>();
            for(int i = 0; i < genres.length; i++) {
                if(genres[i].equals(s))
                    l.add(plays[i]);
            }
            Collections.sort(l, Collections.reverseOrder());
            int max1 = 0;
            int max2 = 0;
            if(l.size() == 1)
                max1 = l.get(0);
            else {
                max1 = l.get(0);
                max2 = l.get(1);
            }
            int maxIdx1 = -1;
            int maxIdx2 = -1;
            for(int i = 0; i < plays.length; i++) {
                if(max1 == plays[i])
                    maxIdx1 = i;
                else if(max2 == plays[i])
                    maxIdx2 = i;
            }
            if(maxIdx2 != -1) {
                answer[cnt++] = maxIdx1;
                answer[cnt++] = maxIdx2;
            } else
                answer[cnt++] = maxIdx1;
        }

        return answer;
    }

    /**
     * solution2_1은 되는데 왜 solution2는 안 되지
     */
    public static int[] solution2(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        answer = new int[map.size() * 2];
        int cnt = 0;

        List<String> listKeySet = new ArrayList<>(map.keySet());
        Collections.sort(listKeySet, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));

        for(String g : listKeySet) {
            //해당 장르의 음악 중에서 play횟수가 가장 큰 인덱스를 찾는다
            int max = 0;
            int firstIdx = -1;
            for(int j = 0; j < genres.length; j++) {
                if(g.equals(genres[j]) && max < plays[j]) {
                    max = plays[j];
                    firstIdx = j;
                }
            }

            //해당 장르의 음악 중에서 play횟수가 두번째로 큰 인덱스를 찾는다.
            max = 0;
            int secondIdx = -1;
            for(int j = 0; j < genres.length; j++) {
                if(g.equals(genres[j]) && max < plays[j] && j != firstIdx) {
                    max = plays[j];
                    secondIdx = j;
                }
            }

            answer[cnt++] = firstIdx;
            if(secondIdx >= 0)
                answer[cnt++] = secondIdx; //secondIdx는 존재 할수도, 안할수도 있다.
        }

        return answer;
    }

    public static int[] solution2_1(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        //key값만 가져와서 genre에 넣어준다
        ArrayList<String> genre = new ArrayList<>();
        for(String key : map.keySet()) {
            genre.add(key);
        }
        Collections.sort(genre, (o1, o2) -> map.get(o2) - map.get(o1)); //key값에 해당하는 value를 내림차순으로 정렬한다.

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < genre.size(); i++) {
            String g = genre.get(i);

            //해당 장르의 음악 중에서 play횟수가 가장 큰 인덱스를 찾는다
            int max = 0;
            int firstIdx = -1;
            for(int j = 0; j < genres.length; j++) {
                if(g.equals(genres[j]) && max < plays[j]) {
                    max = plays[j];
                    firstIdx = j;
                }
            }

            //해당 장르의 음악 중에서 play횟수가 두번째로 큰 인덱스를 찾는다.
            max = 0;
            int secondIdx = -1;
            for(int j = 0; j < genres.length; j++) {
                if(g.equals(genres[j]) && max < plays[j] && j != firstIdx) {
                    max = plays[j];
                    secondIdx = j;
                }
            }

            list.add(firstIdx);
            if(secondIdx >= 0) list.add(secondIdx); //secondIdx는 존재 할수도, 안할수도 있다.
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
