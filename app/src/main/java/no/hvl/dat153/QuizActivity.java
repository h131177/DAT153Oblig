package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {


    private String name;
    private String answer;
    private String displayScore;
    private int score;
    private int total;
    private RadioButton radioButton;


    private List<Person> person;


    private void mockList() {
        person = new LinkedList<>(Arrays.asList(new Person("Obama", R.drawable.obama),
                new Person("Putin", R.drawable.putin),
                new Person("Trump", R.drawable.trump),
                new Person("Trump2", R.drawable.trump),
                new Person("Trump3", R.drawable.trump),
                new Person("Trump4", R.drawable.trump)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mockList();
        setScreen();
    }

    private void setScreen() {
        Random rand = new Random();

        //sender videre til ResultActivity hvis alle navnene er vist
        if (person.size() == 0) {
            Intent result = new Intent(this, ResultActivity.class);
            result.putExtra("score", String.valueOf(score));
            result.putExtra("total", String.valueOf(total));
            startActivity(result);
        }

        //indekser for valgt person og to andre navn, tester litt med de andre for å se hvordan random oppfører seg
        int randomIndex = rand.nextInt(person.size());
        int r2 = rand.nextInt(person.size());
        int r3 = rand.nextInt(person.size());
        int r4 = rand.nextInt(person.size());
        int r5 = rand.nextInt(person.size());
        int r6 = rand.nextInt(person.size());
        System.out.println(" test " + randomIndex + " " + r2 + " " + r3);

        //henter ut rikitg navn og de andre navn alternativene
        name = person.get(randomIndex).getName();
        String r2n = person.get(r2).getName();
        String r3n = person.get(r3).getName();

        // Henter ut knapper og setter de i en liste for å shuffle rekkefølgen
        Button radioButton1 = (Button) findViewById(R.id.radioButton1);
        Button radioButton2 = (Button) findViewById(R.id.radioButton2);
        Button radioButton3 = (Button) findViewById(R.id.radioButton3);
        List<Button> list = Arrays.asList(radioButton1, radioButton2, radioButton3);
        Collections.shuffle(list);
        System.out.println(list);
//        list.get(0).setText(name);
//        list.get(1).setText(r2n);
//        list.get(2).setText(r3n);
        radioButton1.setText(name);
        radioButton2.setText(r2n);
        radioButton3.setText(r3n);

        //setter bildet
        ImageView imageView = findViewById(R.id.profile_picture);
        imageView.setImageResource(person.get(randomIndex).getPath());

        //tar vekk person fra listen etter den har blitt vist for å ikke repetere person
        person.remove(randomIndex);
    }

    @Override
    public void onClick(View view) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);

        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId != -1) {
            radioButton = (RadioButton) findViewById(selectedId);
            if (radioButton != null) {
                total++;
                String display = "";
                answer = (String) radioButton.getText();
                if (answer.equals(name)) {
                    display = answer + " is correct answer";
                    score++;
                } else {
                    display = answer + " is wrong answer";
                }
                Toast.makeText(QuizActivity.this, display, Toast.LENGTH_SHORT).show();
                displayScore = "Score: " + score + " of " + total;
                TextView textView = findViewById(R.id.score);
                textView.setText(displayScore);
                radioGroup.clearCheck();

                //setter opp skjermen på nytt
                setScreen();
            }
        } else {
            Toast.makeText(QuizActivity.this, "choose one", Toast.LENGTH_SHORT).show();
        }
    }
}





