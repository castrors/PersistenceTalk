package com.castrodev.persistencetalk.model;

/**
 * Created by rodrigocastro on 21/06/17.
 */

public class Book {
    private int id;
    private String title;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "\n\t\tid=" + id +
                "\n\t\t, title='" + title + '\'' +
                "\n\t}";
    }
}
