package org.example;

import java.util.Scanner;

public class App {
    Scanner sc;
    App(Scanner sc) {
        this.sc = sc;
    }
    public void run() {
        int cnt = 1;
        System.out.println("== 명언 앱 ==");
        while(true){
            System.out.printf("명언) ");
            String input = sc.nextLine().trim();
            if (input.equals("종료")) {
                sc.close();
                return;
            } else if (input.equals("등록")) {
                System.out.printf("명언: ");
                String content = sc.nextLine();
                System.out.printf("작가: ");
                String writer = sc.nextLine();
                System.out.println(cnt++ + "번 명언이 등록되었습니다.");
            }
        }
    }
}
