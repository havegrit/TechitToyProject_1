package org.example.quote.entity;

public class Quotes {
    private int id;
    private String content;
    private String writer;

    public Quotes(String content, String writer) {
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