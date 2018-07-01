package com.example.android.javaquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayScore extends AppCompatActivity {
    public String name;
    public int score;
    public char sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_score);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            name = null;
        } else {
            name = extras.getString("username");
            score = extras.getInt("score");
            sex = extras.getChar("sex");
            ImageView pic = findViewById(R.id.pic);
            if (sex == 'M')
                pic.setImageResource(R.drawable.male);
            if (sex == 'F')
                pic.setImageResource(R.drawable.female);
            TextView user = findViewById(R.id.username);
            user.setText(name);
        }
        String msg = "Name: " + name + "\nscore: " + score;
        Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void restart(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("username", name);
        intent.putExtra("sex", sex);
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
