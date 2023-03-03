package org.example.quote.services;

import org.example.quote.entity.Quote;
import java.util.ArrayList;
import java.util.List;

public class QuoteService {
    private long lastIndex;
    private List<Quote> quoteList;

    public QuoteService() {
        this.lastIndex = 0;
        this.quoteList = new ArrayList<>();
    }

    public Quote findById(long id) {
        for(Quote quote: quoteList) {
            if(quote.getId() == id) {
                return quote;
            }
        }
        return null;
    }

    public long write(String content, String writer) {
        long id = lastIndex + 1;

        Quote newQuote = new Quote(id, content, writer);
        quoteList.add(newQuote);

        lastIndex = id;

        return id;
    }


    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (Quote quote : quoteList) {
            System.out.printf("%d / %s / %s\n", quote.getId(), quote.getWriter(), quote.getContent());
        }
    }

    public void delete(Quote quote) {
        quoteList.remove(quote);
    }

    public void edit(Quote quote, String content, String writer) {
        quote.setContent(content);
        quote.setWriter(writer);
    }
}
