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
    private int score;
    private int total;
    private List<String> names;
    private List<Person> person;
    //private PersonDao dao = new PersonDao();
    // TODO Lage ein kopi av listen, slik at databasen ikkje blir sletta

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        person = PersonDao.getInstance().getAllPersons();
        names = PersonDao.getInstance().getNames();
        setScreen();
//        final Button quiz_back = findViewById(R.id.quiz_back);
//        quiz_back.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                startActivity(quiz);
//            }
//        });
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
            buttons.get(0).setText(name);

            //henter random navn fra navnlisten og sjekker at det ikke er samme som riktig person
            int r2 = rand.nextInt(names.size());
            String name2 = names.get(r2);
            while (name.equals(name2)) {
                r2 = rand.nextInt(names.size());
                name2 = names.get(r2);
                System.out.println(" while 1 ");
            }
            String r2n = names.get(r2);
            buttons.get(1).setText(r2n);

            int r3 = rand.nextInt(names.size());
            String name3 = names.get(r3);
            while (name.equals(name3) || r2n.equals(name3)) {
                r3 = rand.nextInt(names.size());
                name3 = names.get(r3);
                System.out.println("while 2");
                System.out.println("r3 " + r3);
                System.out.println("name 3 " + name3);
                System.out.println("name " + name);
                System.out.println("r2n " + r2n);
            }
            String r3n = names.get(r3);
            buttons.get(2).setText(r3n);

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
}





