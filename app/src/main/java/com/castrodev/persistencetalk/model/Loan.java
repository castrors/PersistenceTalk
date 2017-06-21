package com.castrodev.persistencetalk.model;

import java.util.Date;

/**
 * Created by rodrigocastro on 21/06/17.
 */

public class Loan {
    private int id;
    private Date startTime;
    private Date endTime;
    private int bookId;
    private int userId;

    public Loan(int id, Date startTime, Date endTime, User user, Book book) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        userId = user.getId();
        bookId = book.getId();
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

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
