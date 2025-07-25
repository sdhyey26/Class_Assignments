package com.tss.prototype.model;

//Prototype Class
public class Book implements Cloneable {
    private String title;
    private String author;
    private int pages;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public void setTitle(String title) { this.title = title; }

    @Override
	public Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }

    @Override
    public String toString() {
        return "Book [Title=" + title + ", Author=" + author + ", Pages=" + pages + "]";
    }
}

