package com.castrodev.room;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.castrodev.room.db.AppDatabase;
import com.castrodev.room.db.Loan;
import com.castrodev.room.db.utils.DatabaseInitializer;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDatabase mDb;

    private TextView mYoungUsersTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mYoungUsersTextView = (TextView) findViewById(R.id.young_users_tv);

        // Note: Db references should not be in an activity.
        mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());

        populateDb();

        fetchData();
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    private void populateDb() {
        DatabaseInitializer.populateSync(mDb);
    }

    private void fetchData() {
        // Note: this kind of logic should not be in an activity.
        StringBuilder sb = new StringBuilder();
//        List<User> youngUsers = mDb.userModel().findYoungerThan(35);
//        for (User youngUser : youngUsers) {
//            sb.append(String.format(Locale.US,
//                    "%s, %s (%d)\n", youngUser.lastName, youngUser.name, youngUser.age));
//        }

        List<Loan> allLoans = mDb.loanModel().findAll();
        for (Loan loan : allLoans) {
            sb.append(loan.toString());
        }

        mYoungUsersTextView.setText(sb);
    }
}
