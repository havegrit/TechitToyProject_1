package org.example.quote.controller;

import org.example.Container;
import org.example.Rq;
import org.example.quote.entity.Quotes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuotesController {
    private int cnt;
    private List<Quotes> quotesList;

    public QuotesController() {
        this.cnt = 1;
        this.quotesList = new ArrayList<>();
    }

    public void write() {
        System.out.print("명언: ");
        String content = Container.getScanner().nextLine();
        System.out.print("작가: ");
        String writer = Container.getScanner().nextLine();
        Quotes newQuote = new Quotes(content, writer);
        newQuote.setId(cnt++);
        quotesList.add(newQuote);
        System.out.println(newQuote.getId() + "번 명언이 등록되었습니다.");
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (Quotes quote : quotesList) {
            System.out.printf("%d / %s / %s\n", quote.getId(), quote.getWriter(), quote.getContent());
        }
    }

    public void delete(Rq rq) {
        int id = rq.getIntParam("id", -1);

        if(id == -1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }

        Quotes quote = findById(id);
        quotesList.remove(quote);

        if(quote == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

    public void edit(Rq rq) {
        int id = rq.getIntParam("id", -1);
        boolean flag = true;

        Quotes quote = findById(id);
        if(quote == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        System.out.println("명언(기존): " + quote.getContent());
        System.out.print("명언: ");
        String content = Container.getScanner().nextLine();
        quote.setContent(content);
        System.out.println("작가(기존): " + quote.getWriter());
        System.out.print("작가: ");
        String writer = Container.getScanner().nextLine();
        quote.setWriter(writer);
    }

    public void saveData(List<Quotes> quotesList) {

    }

    private Quotes findById(int id) {
        for(Quotes quote:quotesList) {
            if(quote.getId() == id) {
                return quote;
            }
        }
        return null;
    }
}
