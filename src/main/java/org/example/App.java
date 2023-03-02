package org.example;

import java.util.ArrayList;
import java.util.Iterator;
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
            } else if (input.startsWith("삭제?id=")) {
                int id = Integer.parseInt(input.substring(6));
                boolean flag = true;
                for(Iterator<Quotes> quote = quotesList.iterator(); quote.hasNext();) {
                    if(quote.next().getId() == id) {
                        flag = false;
                        System.out.println(id + "번 명언이 삭제되었습니다.");
                        quote.remove();
                    }
                }
                if(flag) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                }
            } else if (input.startsWith("수정?id=")) {
                int id = Integer.parseInt(input.substring(6));
                boolean flag = true;
                for (Quotes quote : quotesList) {
                    if (quote.getId() == id) {
                        flag = false;
                        System.out.println("명언(기존): " + quote.getContent());
                        System.out.printf("명언: ");
                        String content = sc.nextLine();
                        quote.setContent(content);
                        System.out.println("작가(기존): " + quote.getWriter());
                        System.out.printf("작가: ");
                        String writer = sc.nextLine();
                        quote.setWriter(writer);
                    }
                }
                if (flag) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
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
    public void setContent(String content) {
        this.content = content;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}