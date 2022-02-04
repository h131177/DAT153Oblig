package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {


    Uri ObamaB = Uri.parse("android.resource://no.hvl.dat153/drawable/obama");
    Uri PutinB = Uri.parse("android.resource://no.hvl.dat153/drawable/putin");
    Uri TrumpB = Uri.parse("android.resource://no.hvl.dat153/drawable/trump");

    public static List<Person> personList = new ArrayList<>();
    Person p1 = new Person ("Regine", ObamaB, randomColor());
    Person p2 = new Person("Magnus", TrumpB, randomColor());
    Person p3 = new Person("Kjetil", PutinB, randomColor());
    Person p4 = new Person ("Regine", ObamaB, randomColor());
    Person p5 = new Person("Magnus", TrumpB, randomColor());
    Person p6 = new Person("Kjetil", PutinB, randomColor());
    Person p7 = new Person ("Regine", ObamaB, randomColor());
    Person p8 = new Person("Magnus", TrumpB, randomColor());
    Person p9 = new Person("Kjetil", PutinB, randomColor());
    Person p10 = new Person ("Regine", ObamaB, randomColor());
    Person p11 = new Person("Magnus", TrumpB, randomColor());
    Person p12 = new Person("Kjetil", PutinB, randomColor());
 //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);
        personList.add(p6);
        personList.add(p7);
        personList.add(p8);
        personList.add(p9);
        personList.add(p10);
        personList.add(p11);
        personList.add(p12);


        //finner knapp med id
        final Button take_quiz = (Button) findViewById(R.id.take_quiz);
        //lager intent for å vise hvor det skal sendes videre
        Intent quiz = new Intent(this,QuizActivity.class);
        //Overfører heile listen med personer til quiz aktiviteten
        quiz.putExtra("liste", String.valueOf(personList));
        //setter på onClick og sender videre til neste Activity
        take_quiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               startActivity(quiz);
            }
        });

        final Button see_list = (Button) findViewById(R.id.see_list);
        Intent list = new Intent(this,dbActivity.class);
        list.putExtra("liste", String.valueOf(personList));
        see_list.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(list);
            }
        });

        final Button add_entry = (Button) findViewById(R.id.add_entry);
        Intent entry = new Intent(this,AddEntryActivity.class);
        //Overfører heile listen med personer til addEntry aktiviteten
        entry.putExtra("liste", String.valueOf(personList));
        add_entry.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(entry);
            }
        });



    }
    public int randomColor(){
        Random rnd = new Random();
        int currentColor = Color.argb(69, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        return currentColor;
    }


}