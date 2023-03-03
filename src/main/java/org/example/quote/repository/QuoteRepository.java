package org.example.quote.repository;

import org.example.quote.entity.Quote;
import java.util.ArrayList;
import java.util.List;

public class QuoteRepository {
    private long lastIndex;
    private List<Quote> quoteList;
    public QuoteRepository() {
        lastIndex = 0;
        quoteList = new ArrayList<>();
        
    }

    public List<Quote> findAll() {
        return quoteList;
    }

    public long write(String content, String author) {
        long id = lastIndex + 1;

        Quote newQuote = new Quote(id, content, author);
        quoteList.add(newQuote);

        lastIndex = id;

        return id;
    }
    
    public void delete(Quote quote) {
        quoteList.remove(quote);
    }


    public Quote findById(long id) {
        for (Quote quote : quoteList) {
            if (quote.getId() == id) {
                return quote;
            }
        }
        return null;
    }

    public void edit(Quote quote, String content, String author) {
        quote.setContent(content);
        quote.setWriter(author);
    }
}
