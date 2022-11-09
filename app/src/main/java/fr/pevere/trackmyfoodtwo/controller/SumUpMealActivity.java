package fr.pevere.trackmyfoodtwo.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import fr.pevere.trackmyfoodtwo.R;

public class SumUpMealActivity extends AppCompatActivity {

    private SimpleCursorAdapter adapter;

    final String[] from = new String[] { DatabaseHelper.HOWMUCH,
            DatabaseHelper.WHAT, DatabaseHelper.TIMEMEAL };

    final int[] to = new int[] { R.id.id, R.id.title, R.id.desc };

    private DBManager dbManager;
    private Cursor cursor;


    private ListView listView;
    private TextView mGreetingUserTextView;
    private Button mAddMealButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum_up_meal);

        dbManager = new DBManager(this);
        dbManager.open();
        cursor = dbManager.fetch();

        Log.i("test", String.valueOf(cursor));

        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        mGreetingUserTextView = findViewById(R.id.main_textview_greeting);
        mAddMealButton = findViewById(R.id.main_button_add_meal);

        adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        mAddMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameActivityIntent = new Intent(SumUpMealActivity.this, FormActivity.class);
                startActivity(gameActivityIntent);
            }
        });
    }
}