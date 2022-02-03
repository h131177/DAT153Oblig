package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener{


    private String name;
    private String answer;
    private int score;
    private int total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Random rand = new Random();
        List<Person> person = new LinkedList<>( Arrays.asList(new Person("Obama", R.drawable.obama),
                new Person("Beyonce", R.drawable.obama),
                new Person("Steve Jobs", R.drawable.obama)));
        int numberOfElements = person.size()-1;

        Button radioButton1 = (Button) findViewById(R.id.radioButton1);
        Button radioButton2 = (Button) findViewById(R.id.radioButton2);
        Button radioButton3 = (Button) findViewById(R.id.radioButton3);

        Button submit = (Button)findViewById(R.id.submit);
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radio_group);

        for (int i = 0; i < numberOfElements; i++) {

            //indekser for valgt person og to andre navn
            int randomIndex = rand.nextInt(person.size());
            int r2 = rand.nextInt(person.size());
            int r3= rand.nextInt(person.size());

            //henter ut rikitg navn og de andre navn alternativene
            name = person.get(randomIndex).getName();
            String r2n = person.get(r2).getName();
            String r3n = person.get(r3).getName();

            // må ha noe som velger random knapp å sitte det på
            radioButton1.setText(name);
            radioButton2.setText(r2n);
            radioButton3.setText(r3n);
            //tar vekk person fra listen etter den har blitt vist
            person.remove(randomIndex);
        }

//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
//                if (checkedId != -1) {
//                    RadioButton rb = (RadioButton) findViewById(checkedId);
//                    if (rb != null) {
//                        total++;
//                        String display = "";
//                        answer = (String) rb.getText();
//                        if(answer.equals(name)){
//                            display = answer + " is correct answer";
//                            score++;
//                        } else{
//                            display = answer + " is wrong answer";
//                        }
//                        Toast.makeText(QuizActivity.this, display, Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(QuizActivity.this, "choose one", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });


    }


    @Override
    public void onClick(View view) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId != -1) {
                    RadioButton rb = (RadioButton) findViewById(checkedId);
                    if (rb != null) {
                        total++;
                        String display = "";
                        answer = (String) rb.getText();
                        if (answer.equals(name)) {
                            display = answer + " is correct answer";
                            score++;
                        } else {
                            display = answer + " is wrong answer";
                        }
                        Toast.makeText(QuizActivity.this, display, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(QuizActivity.this, "choose one", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}





