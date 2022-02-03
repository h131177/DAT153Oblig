package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity  {


    public static List<Person> personList = new ArrayList<>();
    Person p1 = new Person ("Regine", R.drawable.obama);
    Person p2 = new Person("Magnus", R.drawable.trump);
    Person p3 = new Person("Kjetil", R.drawable.putin);
    Person p4 = new Person ("Regine", R.drawable.obama);
    Person p5 = new Person("Magnus", R.drawable.trump);
    Person p6 = new Person("Kjetil", R.drawable.putin);
    Person p7 = new Person ("Regine", R.drawable.obama);
    Person p8 = new Person("Magnus", R.drawable.trump);
    Person p9 = new Person("Kjetil", R.drawable.putin);
    Person p10 = new Person ("Regine", R.drawable.obama);
    Person p11 = new Person("Magnus", R.drawable.trump);
    Person p12 = new Person("Kjetil", R.drawable.putin);
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



}