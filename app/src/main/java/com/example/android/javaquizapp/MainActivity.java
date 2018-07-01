package com.example.android.javaquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {

        } else {
            EditText name = findViewById(R.id.begin);
            name.setText(extras.getString("username"));
            if (extras.getChar("sex") == 'F') {
                RadioButton female = findViewById(R.id.female);
                female.setChecked(true);
            }
            if (extras.getChar("sex") == 'M') {
                RadioButton male = findViewById(R.id.male);
                male.setChecked(true);
            }
        }
    }

    // This variable is for the score
    public int score = 0;

    /**
     * This method starts the quiz
     *
     * @param v
     */
    public void start(View v) {
        EditText name = findViewById(R.id.begin);
        String username = name.getText().toString();
        Intent intent = new Intent(this, QuestionOne.class);
        intent.putExtra("username", username);
        intent.putExtra("score", score);
        RadioButton radioButtonFemale = findViewById(R.id.female);
        RadioButton radioButtonMale = findViewById(R.id.male);
        if (radioButtonMale.isChecked()) {
            intent.putExtra("sex", 'M');
        }
        if (radioButtonFemale.isChecked()) {
            intent.putExtra("sex", 'F');
        }
        startActivity(intent);
    }

    /**
     * This method set the image of the user
     *
     * @param v
     */
    public void setImgFemale(View v) {
        ImageView img = findViewById(R.id.img);
        img.setImageResource(R.drawable.female);
    }

    /**
     * This method set the image of the user
     *
     * @param v
     */
    public void setImgMale(View v) {
        ImageView img = findViewById(R.id.img);
        img.setImageResource(R.drawable.male);
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
