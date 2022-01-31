package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    List<Person> person = Arrays.asList(new Person("Obama", "path til bilde"),
            new Person("Beyonce", "path til bilde"),
            new Person("Steve Jobs", "path til bilde"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Button radioButton1 = (Button) findViewById(R.id.radioButton1);
        Button radioButton2 = (Button) findViewById(R.id.radioButton2);
        Button radioButton3 = (Button) findViewById(R.id.radioButton3);


        //toast som sier om det var riktig eller feil





    }
}