package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;


import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private LiveData<List<Person>> personList;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personList = AppDatabase.getDatabase(getApplicationContext()).personDao().getAllPersons();

        //finner knapp med id
        final Button take_quiz = (Button) findViewById(R.id.take_quiz);
        //lager intent for å vise hvor det skal sendes videre
        Intent quiz = new Intent(this,QuizActivity.class);
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
        add_entry.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(entry);
            }
        });
    }



}