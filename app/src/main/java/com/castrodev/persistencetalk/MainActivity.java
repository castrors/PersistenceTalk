package com.castrodev.persistencetalk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.castrodev.persistencetalk.data.LoanDbHelper;
import com.castrodev.persistencetalk.model.Book;
import com.castrodev.persistencetalk.model.Loan;
import com.castrodev.persistencetalk.model.User;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoanDbHelper loanDbHelper = LoanDbHelper.getInstance(this);
        User user = new User(1, "Joao", "da Silva", 20);
        loanDbHelper.addUser(user);
        Book book = new Book(123, "American Gods");
        loanDbHelper.addBook(book);
        loanDbHelper.addLoan(new Loan(50, new Date(), null, user, book));
    }
}
