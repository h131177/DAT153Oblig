package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String score = "";
        String total = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            score = extras.getString("score");
            total = extras.getString("total");
        }
        String display = "Your score is " + score + " correct of " + total + " total!";
        TextView textView = findViewById(R.id.result);
        textView.setText(display);
    }
}