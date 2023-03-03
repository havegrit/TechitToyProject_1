package org.example.quote.entity;

public class Quote {
    private long id;
    private String content;
    private String writer;

    public Quote(long id, String content, String writer) {
        this.id = id;
        this.content = content;
        this.writer = writer;
    }

    public long getId() {
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