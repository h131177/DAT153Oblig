package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class AddEntryActivity extends AppCompatActivity {

    private ArrayList<Person> personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            personList = extras.getParcelableArrayList("liste");
        }
        System.out.println("Første item: " + personList.get(0).getName());
    }
}