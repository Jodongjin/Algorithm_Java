package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 덱 {
    public static void main(String[] args) throws IOException {
        덱 T = new 덱();
//        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
//        kb.nextLine(); // flush
//        String[] commands = new String[n];
//        for(int i = 0; i < n; i++)
//            commands[i] = kb.nextLine();
        int n = Integer.parseInt(br.readLine());
        dq = new ArrayDeque<Integer>();

        T.solution(n);
    }

    public void my_solution(String[] commands) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        String[] str;
        for(String command : commands) {
            str = command.split(" ");
            switch (str[0]) {
                case "push_front":
                    deque.addFirst(Integer.valueOf(str[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.valueOf(str[1]));
                    break;
                case "pop_front":
                    if(!deque.isEmpty()) sb.append(deque.pollFirst() + "\n");
                    else sb.append(-1 + "\n");
                    break;
                case "pop_back":
                    if(!deque.isEmpty()) sb.append(deque.pollLast() + "\n");
                    else sb.append(-1 + "\n");
                    break;
                case "size":
                    sb.append(deque.size() + "\n");
                    break;
                case "empty":
                    if(!deque.isEmpty()) sb.append(0 + "\n");
                    else sb.append(1 + "\n");
                    break;
                case "front":
                    if(!deque.isEmpty()) sb.append(deque.peekFirst() + "\n");
                    else sb.append(-1 + "\n");
                    break;
                case "back":
                    if(!deque.isEmpty()) sb.append(deque.peekLast() + "\n");
                    else sb.append(-1 + "\n");
            }
        }

        System.out.println(sb);
    }

    /**
     * my_solution 시간 초과
     *  Scanner -> BufferedReader
     *  sout -> StringBuilder
     *  String.split(" ") -> StringTokenizer
     */
    static Deque<Integer> dq;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void solution(int n) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // br.readLine() -> throws IOException
            switch (st.nextToken()) {
                case "push_front":
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(!dq.isEmpty())
                        sb.append(dq.pollFirst() + "\n");
                    else
                        sb.append(-1 + "\n");
                    break;
                case "pop_back":
                    if(!dq.isEmpty())
                        sb.append(dq.pollLast() + "\n");
                    else
                        sb.append(-1 + "\n");
                    break;
                case "size":
                    sb.append(dq.size() + "\n");
                    break;
                case "empty":
                    if(!dq.isEmpty())
                        sb.append(0 + "\n");
                    else
                        sb.append(1 + "\n");
                    break;
                case "front":
                    if(!dq.isEmpty()) sb.append(dq.peekFirst() + "\n");
                    else sb.append(-1 + "\n");
                    break;
                case "back":
                    if(!dq.isEmpty()) sb.append(dq.peekLast() + "\n");
                    else sb.append(-1 + "\n");
            }
        }

        System.out.println(sb);
    }
}