package org.example.quote.services;

import org.example.quote.entity.Quote;
import org.example.quote.repository.QuoteRepository;
import java.util.List;

public class QuoteService {

    private final QuoteRepository quoteRepository;

    public QuoteService() {
        quoteRepository = new QuoteRepository();
    }

    public Quote findById(long id) {
        return quoteRepository.findById(id);
    }

    public List<Quote> findAll() {
        return quoteRepository.findAll();
    }

    public long write(String content, String author) {
        return quoteRepository.write(content, author);

    }

    public void delete(Quote quote) {
        quoteRepository.delete(quote);
    }

    public void edit(Quote quote, String content, String author) {
        quoteRepository.edit(quote, content, author);

    }
}
