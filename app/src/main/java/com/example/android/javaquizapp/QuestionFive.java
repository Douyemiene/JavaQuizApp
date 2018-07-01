package com.example.android.javaquizapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class QuestionFive extends AppCompatActivity {
    public String name;
    public int score;
    public char sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_five);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            name = null;
        } else {
            name = extras.getString("username");
            TextView user = findViewById(R.id.username);
            sex = extras.getChar("sex");
            ImageView pic = findViewById(R.id.pic);
            if (sex == 'M')
                pic.setImageResource(R.drawable.male);
            if (sex == 'F')
                pic.setImageResource(R.drawable.female);
            score = extras.getInt("score");
            user.setText("Name: " + name);
        }
    }

    /**
     * This method opens the next question's activity
     *
     * @param v
     */
    public void next(View v) {
        RadioButton ans = findViewById(R.id.ans);
        if (ans.isChecked())
            score++;
        Intent intent = new Intent(this, DisplayScore.class);
        intent.putExtra("username", name);
        intent.putExtra("score", score);
        intent.putExtra("sex", sex);
        startActivity(intent);
    }

    /**
     * This method opens the previous question's activity
     *
     * @param v
     */
    public void previous(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.notImplemented, Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * This method ends the quiz
     *
     * @param v
     */
    public void endApp(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * override the onBackPressed method
     */
    @Override
    public void onBackPressed() {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.notImplemented, Toast.LENGTH_SHORT);
        toast.show();
    }
}
