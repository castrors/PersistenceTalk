package com.castrodev.persistencetalk.model;

import java.util.Date;

/**
 * Created by rodrigocastro on 21/06/17.
 */

public class Loan {
    private int id;
    private Date startTime;
    private Date endTime;
    private Book book;
    private User user;

    public Loan(int id, Date startTime, Date endTime, User user, Book book) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.user = user;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "\n\tid=" + id +
                "\n\t, startTime=" + startTime +
                "\n\t, endTime=" + endTime +
                "\n\t, book=" + book +
                "\n\t, user=" + user +
                "\n}";
    }
}
