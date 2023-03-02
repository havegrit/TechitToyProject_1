package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc;
    App(Scanner sc) {
        this.sc = sc;
    }
    public void run() {
        int cnt = 1;
        System.out.println("== 명언 앱 ==");
        List<Quotes> quotesList = new ArrayList<>();
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
                Quotes newQuote = new Quotes(content, writer);
                newQuote.setId(cnt++);
                quotesList.add(newQuote);
                System.out.println(newQuote.getId() + "번 명언이 등록되었습니다.");
            } else if (input.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (Quotes quote : quotesList) {
                    System.out.printf("%d / %s / %s\n", quote.getId(), quote.getWriter(), quote.getContent());
                }
            }
        }
    }
}

class Quotes {
    private int id;
    private String content;
    private String writer;

    Quotes(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }

    public int getId() {
        return id;
    }
    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public void setId(int id) {
        this.id = id;
    }
}