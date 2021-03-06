package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {


    private String name;
    private static int score;
    private static int total;
    private static int wrongButton1;
    private static int wrongButton2;
    private List<String> names = new ArrayList<>();
    private List<Person> person;
    private static int correctButton;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
        //tilbakeknapp på toppen av siden
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        score = 0;
        total = 0;
        //henter info fra databasen
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mViewModel.getAllPerson().observe(this, (List<Person> personList) -> {
            person = personList;
            names = getNames();
            setScreen();
        });
    }

    private void setScreen() {
        Random rand = new Random();
        //sender videre til ResultActivity hvis alle navnene er vist, kunne ha brukt fragment her
        if (person.size() == 0) {
            Intent result = new Intent(this, ResultActivity.class);
            result.putExtra("score", String.valueOf(score));
            result.putExtra("total", String.valueOf(total));
            startActivity(result);
        }else {
            //henter knappene og shuffler rekkefølgen
            Button radioButton1 = (Button) findViewById(R.id.radioButton1);
            Button radioButton2 = (Button) findViewById(R.id.radioButton2);
            Button radioButton3 = (Button) findViewById(R.id.radioButton3);
            List<Button> buttons = Arrays.asList(radioButton1, radioButton2, radioButton3);
            Collections.shuffle(buttons);

            //riktig person setup
            int randomIndex = rand.nextInt(person.size());
            name = person.get(randomIndex).getName();
            correctButton = buttons.get(0).getId();
            buttons.get(0).setText(name);

            //henter random navn fra navnlisten og sjekker at det ikke er samme som riktig person
            int r2 = rand.nextInt(names.size());
            String name2 = names.get(r2);
            while (name.equals(name2)) {
                r2 = rand.nextInt(names.size());
                name2 = names.get(r2);
            }
            String r2n = names.get(r2);
            buttons.get(1).setText(r2n);
            wrongButton1 = buttons.get(1).getId();

            int r3 = rand.nextInt(names.size());
            String name3 = names.get(r3);
            while (name.equals(name3) || r2n.equals(name3)) {
                r3 = rand.nextInt(names.size());
                name3 = names.get(r3);
            }
            String r3n = names.get(r3);
            buttons.get(2).setText(r3n);
            wrongButton2 = buttons.get(2).getId();

            //setter bildet
            ImageView imageView = findViewById(R.id.profile_picture);
            imageView.setImageURI(Uri.parse(person.get(randomIndex).getPath()));

            //tar vekk person fra listen etter den har blitt vist for å ikke repetere person
            person.remove(randomIndex);
        }
    }

    @Override
    public void onClick(View view) {
        String answer = "";
        String displayScore = "";
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton radioButton = (RadioButton) findViewById(selectedId);
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

    private List<String> getNames(){
        Iterator<Person> it = person.iterator();
        while(it.hasNext()){
            names.add(it.next().getName());
        }
        return names;
    }

    //For testing
    public static int getCorrectButton(){
        return correctButton;
    }
    public static int getWrongButton1(){
        return wrongButton1;
    }
    public static int getWrongButton2(){
        return wrongButton2;
    }

}





