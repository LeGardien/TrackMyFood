package fr.pevere.trackmyfoodtwo.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import fr.pevere.trackmyfoodtwo.R;

public class FormActivity extends AppCompatActivity {

    public static final String BUNDLE_EXTRA_WHEN = "BUNDLE_EXTRA_WHEN";
    public static final String BUNDLE_EXTRA_WHAT = "BUNDLE_EXTRA_WHAT";
    public static final String BUNDLE_EXTRA_HOW_MUCH = "BUNDLE_EXTRA_HOW_MUCH";



    private TextView mTitleTextView;
    private TextView mQuestionWhenTextView;
    private TextView mQuestionWhatTextView;
    private TextView mQuestionHowMuchTextView;
    private RadioButton mQuestionWhenBreakfast1;
    private RadioButton mQuestionWhenBreakfast2;
    private RadioButton mQuestionWhenBreakfast3;
    private RadioButton mQuestionWhenBreakfast4;
    private EditText mQuestionWhatText;
    private EditText mQuestionHowMuchText;
    private Button mNextButton;

    private String mWhen;

    private DBManager dbManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        mTitleTextView = findViewById(R.id.game_activity_textview_question);
        mQuestionWhenTextView = findViewById(R.id.game_activity_textview_question2);
        mQuestionWhatTextView = findViewById(R.id.game_activity_textview_question3);
        mQuestionHowMuchTextView = findViewById(R.id.game_activity_textview_question4);

        mQuestionWhenBreakfast1 = findViewById(R.id.game_activity_button_meal1);
        mQuestionWhenBreakfast2 = findViewById(R.id.game_activity_button_meal2);
        mQuestionWhenBreakfast3 = findViewById(R.id.game_activity_button_meal3);
        mQuestionWhenBreakfast4 = findViewById(R.id.game_activity_button_meal4);

        mQuestionWhatText = findViewById(R.id.main_edittext_what);
        mQuestionHowMuchText = findViewById(R.id.main_edittext_quantity);


        mNextButton = findViewById(R.id.game_activity_button_4);

        dbManager = new DBManager(this);
        dbManager.open();

        mQuestionWhenBreakfast1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWhen = "Breakfast";
                Toast.makeText(getApplicationContext(), "You have selected " + mWhen, Toast.LENGTH_SHORT).show();
            }
        });

        mQuestionWhenBreakfast2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWhen = "Lunch";
                Toast.makeText(getApplicationContext(), "You have selected " + mWhen, Toast.LENGTH_SHORT).show();
            }
        });

        mQuestionWhenBreakfast3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWhen = "Dinner";
                Toast.makeText(getApplicationContext(), "You have selected " + mWhen, Toast.LENGTH_SHORT).show();
            }
        });

        mQuestionWhenBreakfast4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWhen = "Snack";
                Toast.makeText(getApplicationContext(), "You have selected " + mWhen, Toast.LENGTH_SHORT).show();
            }
        });


        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormActivity.this, SumUpMealActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);;
//                intent.putExtra(BUNDLE_EXTRA_WHEN, mWhen);
//                intent.putExtra(BUNDLE_EXTRA_WHAT, mQuestionWhatText.getText().toString());
//                intent.putExtra(BUNDLE_EXTRA_HOW_MUCH, mQuestionHowMuchText.getText().toString());
//                setResult(RESULT_OK, intent);

                dbManager.insert(mQuestionWhatText.getText().toString(), mWhen, mQuestionHowMuchText.getText().toString());

                startActivity(intent);
            }
        });

    }

}
