package org.example.quote.controller;

import org.example.Container;
import org.example.Rq;
import org.example.quote.entity.Quote;
import org.example.quote.services.QuoteService;
import java.util.List;

public class QuotesController {
    private final QuoteService quoteService;

    public QuotesController() {
        quoteService = new QuoteService();
    }

    public void write() {
        System.out.print("명언: ");
        String content = Container.getScanner().nextLine();
        System.out.print("작가: ");
        String writer = Container.getScanner().nextLine();
        long id = quoteService.write(content, writer);
        System.out.printf("%d번 명언이 등록되었습니다.\n", id);

    }

    public void list() {
        List<Quote> quoteList = quoteService.findAll();
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (Quote quote : quoteList) {
            System.out.printf("%d / %s / %s\n", quote.getId(), quote.getWriter(), quote.getContent());
        }
    }

    public void delete(Rq rq) {
        int id = rq.getLongParam("id", -1);

        if(id == -1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }
        Quote quote = quoteService.findById(id);

        if(quote == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        quoteService.delete(quote);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

    public void edit(Rq rq) {
        long id = rq.getLongParam("id", -1);
        Quote quote = quoteService.findById(id);

        if(quote == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.println("명언(기존): " + quote.getContent());
        System.out.print("명언: ");
        String content = Container.getScanner().nextLine();
        System.out.println("작가(기존): " + quote.getWriter());
        System.out.print("작가: ");
        String writer = Container.getScanner().nextLine();

        quoteService.edit(quote, content, writer);
    }

    public void saveData(List<Quote> quoteList) {

    }


}
