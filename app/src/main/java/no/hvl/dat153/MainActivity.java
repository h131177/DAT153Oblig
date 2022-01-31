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
import java.util.Map;

public class MainActivity extends AppCompatActivity  {

    private ArrayList<Person> personList = new ArrayList<>();
    Person p1 = new Person("Regine", "TestPath1");
    Person p2 = new Person("Magnus", "TestPath2");
    Person p3 = new Person("Kjetil", "TestPath3");
 //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        //finner knapp med id
        final Button take_quiz = (Button) findViewById(R.id.take_quiz);
        //lager intent for å vise hvor det skal sendes videre
        Intent quiz = new Intent(this,QuizActivity.class);
        //Overfører heile listen med personer til quiz aktiviteten
        quiz.putExtra("liste", personList);
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
        entry.putExtra("liste", personList);
        add_entry.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(entry);
            }
        });



    }



}