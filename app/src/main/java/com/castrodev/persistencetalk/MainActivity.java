package com.castrodev.persistencetalk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.castrodev.persistencetalk.data.LoanDbHelper;
import com.castrodev.persistencetalk.model.Book;
import com.castrodev.persistencetalk.model.Loan;
import com.castrodev.persistencetalk.model.User;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView loansTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loansTextView = (TextView) findViewById(R.id.loans_database);

        LoanDbHelper loanDbHelper = LoanDbHelper.getInstance(this);
        User user = new User(1, "Joao", "da Silva", 20);
        loanDbHelper.addUser(user);
        Book book = new Book(123, "American Gods");
        loanDbHelper.addBook(book);
        loanDbHelper.addLoan(new Loan(50, new Date(), null, user, book));

        StringBuilder loansText = new StringBuilder();
        List<Loan> loans = loanDbHelper.getAllLoans();
        for (Loan loan : loans) {
            loansText.append(loan.toString());
        }

        loansTextView.setText(loansText.toString());
    }
}
